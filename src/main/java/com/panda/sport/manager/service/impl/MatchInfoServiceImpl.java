package com.panda.sport.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.panda.sport.manager.basicservice.vo.PandaPage;
import com.panda.sport.manager.constant.Constant;
import com.panda.sport.manager.db.entity.*;
import com.panda.sport.manager.db.service.*;
import com.panda.sport.manager.dbext.entity.MatchQueryExt;
import com.panda.sport.manager.dbext.mapper.StandardMatchInfoExtMapper;
import com.panda.sport.manager.dbext.service.DataSourceExtService;
import com.panda.sport.manager.enums.DataSourceCodeEnum;
import com.panda.sport.manager.utils.TimeUtils;
import com.panda.sport.manager.vo.ConvertExt2Vo;
import com.panda.sport.manager.vo.MatchQueryRule;
import com.panda.sport.manager.vo.MatchRule;
import com.panda.sport.manager.vo.match.MatchQueryVo;
import com.panda.sport.manager.vo.match.MatchTouInfoVO;
import com.panda.sport.manager.vo.match.MatchVO;
import com.panda.sport.manager.vo.match.ThirdMatchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class MatchInfoServiceImpl {
    @Autowired
    private StandardMatchInfoService standardMatchInfoService;
    @Autowired
    private StandardSportTournamentService standardSportTournamentService;
    @Autowired
    private ThirdMatchInfoService thirdMatchInfoService;
    @Autowired
    private DataSourceExtService dataSourceExtService;
    @Autowired
    private ThirdSportTournamentService thirdSportTournamentService;
    @Autowired
    private StandardMatchInfoExtMapper standardMatchInfoExtMapper;
    @Autowired
    private ThirdSportMarketService thirdSportMarketService;

    //@Override
    public PandaPage<MatchVO> queryMatchByCondition(MatchQueryVo query) {
        PandaPage<MatchVO> returnPage = null;
        Integer total = 0;
        // 如果选择数据源，则默认选择所有的数据源
        if (CollectionUtils.isEmpty(query.getDataSourceCode())) {
            //query.setDataSourceCode(dataSourceExtService.getAllDataSourceCodeList());
        }

        //  初始化，防止前端不传
        if (query.getHistoryFlag() == null) {
            query.setHistoryFlag(0);
        }
        if (query.getLiveOddQuery() == null) {
            query.setLiveOddQuery(0);
        }
        if (query.getIsEarlyTrading() == null) {
            query.setIsEarlyTrading(0);
        }
        if (query.getIds() == null) {
            query.setIds(new ArrayList<Long>());
        }

        MatchQueryExt matchQueryExt = ConvertExt2Vo.convert(query);
        matchQueryExt.setLeagueLevel(query.getLeagueLevel());
        matchQueryExt.setStartTime(query.getStartTimeFrom());
        //log.info(PandaLog.op("getTournamentPage").msg("赛事查询参数").kv("query", query).toString());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("1-查询赛事标准数据组装条件");
        /*** 关于数据源，需要重新筛选 这个地方有问题，需要跟前端协商. ***/

        MatchRule matchRule = MatchQueryRule.getMatchQueryCode(query.getDataSourceCode(), query.getMatchList());

        //前端选择结束时间
        if (!query.getEndTimeFrom().equals(Constant.DB_DEFAULT_LONG_VALUE) && query.getEndTimeFrom() != null) {
            if (query.getEndTimeFrom() < query.getStartTimeFrom()) {
                log.error("query.getEndTimeFrom:{},getStartTimeFrom:{}", query.getEndTimeFrom(), query.getStartTimeFrom());
                //throw new BusinessException(i18n.getMsg(10163));
            }
            matchQueryExt.setEndTime(query.getEndTimeFrom() + 1);
        } else {
            //系统计算结束时间
            if (query.getIds().size() > 0) {
                matchQueryExt.setEndTime(null);
                matchQueryExt.setStartTime(null);
            }
            if (Constant.MATCH_LIVE_ODD_SUPPORT_TRUE.equals(query.getLiveOddQuery())) {
                //赛程滚球列表包含7天内
                matchQueryExt.setStartTime(query.getStartTimeFrom() - Constant.millSecondDay * 8);
                matchQueryExt.setEndTime(query.getStartTimeFrom() + Constant.millSecondDay);
            } else {
                // 1.历史赛程 2.其它早盘 3.其它基本查询
                matchQueryExt.setEndTime(query.getStartTimeFrom() + Constant.millSecondDay);
            }

            //  只要按 联赛名，联赛管理ID，球队名，球队管理ID，赛事管理ID 任意一个条件搜索，则需要将 查询范围分成两块
            boolean queryIdOrNameFlag = !org.springframework.util.StringUtils.isEmpty(query.getTeamName())
                    || StringUtils.isNotBlank(query.getTeamManagerId())
                    || (!org.springframework.util.StringUtils.isEmpty(query.getTournamentName()))
                    || StringUtils.isNotBlank(query.getTournamentManagerId())
                    || (StringUtils.isNotBlank(query.getMatchManageId()));
            if (queryIdOrNameFlag) {
                matchQueryExt.setEndTime(query.getStartTimeFrom() + (7 * Constant.millSecondDay));
            }
        }

        Set<Long> touIds = new HashSet<>();
        touIds.add(-1L);
        if (!CollectionUtils.isEmpty(query.getTouLanguagelist())) {
            Map<Integer, List<MatchTouInfoVO>> toulanguage = query.getTouLanguagelist().stream().collect(Collectors.groupingBy(MatchTouInfoVO::getType));
            List<MatchTouInfoVO> thirdTouInfoIds = toulanguage.get(Constant.ZERO);
            List<MatchTouInfoVO> standardInfoTouIds = toulanguage.get(Constant.ONE);
            if (CollectionUtils.isNotEmpty(thirdTouInfoIds)) {
                matchQueryExt.setThirdTouIds(thirdTouInfoIds.stream().map(MatchTouInfoVO::getTouIds).collect(Collectors.toSet()));
            } else {
                matchQueryExt.setThirdTouIds(touIds);
            }
            if (CollectionUtils.isNotEmpty(standardInfoTouIds)) {
                matchQueryExt.setStandardTouIds(standardInfoTouIds.stream().map(MatchTouInfoVO::getTouIds).collect(Collectors.toSet()));
            } else {
                matchQueryExt.setStandardTouIds(touIds);
            }
        }

        /*** 获取商业数据源 ***/
        List<String> commerceList = dataSourceExtService.getCommerceDataSourceList().stream().map(DataSource::getCode).collect(Collectors.toList());
        stopWatch.stop();
        stopWatch.start("2-查询赛事标准数据");
        /*** 先查出 页面展示的赛事表的数据+关联的第三方数据（不一定查，根据数据来源判断） +球队信息 ***/
        Integer offset = (query.getPage() - 1) * query.getSize();
//        log.info(PandaLog.op("queryMatchByCondition").msg("查看参数").kv("matchQueryExt", matchQueryExt)
//                .kv("commerceList", commerceList).kv("queryThirdFlag", MatchQueryRule.queryThirdFlagByMatchQuery(query))
//                .kv("isToday", TimeUtils.isTodayZeorForPage(query.getStartTimeFrom())).kv("QueryList", matchRule.getQueryList())
//                .kv("QueryStandardCount", matchRule.getQueryStandardCount()).toString());
        List<MatchVO> matchVOList = new ArrayList<>();
        //1.源id搜索
        if (StringUtils.isNotBlank(matchQueryExt.getThirdMatchSourceId())) {
            MatchVO thirdMatchSource = this.getThirdMatchSource(matchQueryExt);
            if (thirdMatchSource != null) {
                matchVOList.add(thirdMatchSource);
                returnPage = new PandaPage<>(matchVOList.size(), query.getSize(), query.getPage());
                returnPage.setRecords(matchVOList);
            } else {
                return new PandaPage<>();
            }
        } else {
            //1.普通查询
            if (matchQueryExt.getBooked() != null) {
                matchQueryExt.setBookedPlus(matchQueryExt.getBooked() + 1);
            }
            matchVOList = ConvertExt2Vo.convertMatchVO(standardMatchInfoExtMapper.getMatchVoForPandaPage(matchQueryExt, commerceList,
                    offset, query.getSize(), MatchQueryRule.queryThirdFlagByMatchQuery(query), matchRule.getQueryList(),
                    matchRule.getQueryStandardCount(), TimeUtils.isTodayZeorForPage(query.getStartTimeFrom())));
            //log.info("标准列表queryMatchByCondition的查询 size{}:", matchVOList.size());
            if (CollectionUtils.isNotEmpty(matchVOList)) {
                total = matchVOList.size();
                // 不是第一页，且当前总数大于等于每页数时，再查询总数
                if (total >= query.getSize() || query.getPage() > 1) {
                    //stopWatch.start("查询赛事标准数据Count");
                    total = standardMatchInfoExtMapper.getMatchVoForPandaPageCount(matchQueryExt, commerceList,
                            offset, query.getSize(), MatchQueryRule.queryThirdFlagByMatchQuery(query),
                            matchRule.getQueryList(), matchRule.getQueryStandardCount(),
                            TimeUtils.isTodayZeorForPage(query.getStartTimeFrom()));
                    //stopWatch.stop();
                }
            }
            returnPage = new PandaPage<>(total, query.getSize(), query.getPage());
            returnPage.setRecords(matchVOList);
        }
        stopWatch.stop();
        if (CollectionUtils.isEmpty(matchVOList)) {
            return new PandaPage<>();
        }

        stopWatch.start("3-开始查询分页的标准数据下挂的数据");
        List<String> standardMatchIdListBefro = matchVOList.stream().filter(item -> item.getStandard()).map(MatchVO::getId).collect(Collectors.toList());

        List<Long> standardMatchIdList = standardMatchIdListBefro.stream().map(matchIdStr -> Long.valueOf(matchIdStr)).collect(Collectors.toList());


       /* //处理联赛信息
        this.buildSportTournament(standardMatchIdList, returnPage);


        if (CollectionUtils.isNotEmpty(standardMatchIdList)) {
            List<ThirdMatchVo> thirdmatchVOlist = ConvertExt2Vo.convertThirdMatchVo(standardMatchInfoExtService.getUnderThirdMatchForPandaPage(standardMatchIdList, query.getSportId()));
            //将查询出的下挂的第三方赛事拼到 标准赛事对象中
            this.dealStandardMatch(matchVOList, thirdmatchVOlist);
        }*/
        stopWatch.stop();
      /*  stopWatch.start("4-开始对查询的赛事下挂的数据排序");
        //  对标准联赛 下 第三方联赛进行排序  SR，BC，188
        if (CollectionUtils.isNotEmpty(returnPage.getRecords())) {
            for (MatchVO vo : returnPage.getRecords()) {

                if (!CollectionUtils.isEmpty(vo.getRelatedMatch()) && (StringUtils.isNotBlank(vo.getAssociationId()) || vo.getStandard())) {
                    // 对标准赛事关联的第三方数据进行排序，排序规则是 按照数据源的优先级进行排序。优先级越高，排序越靠前。
                    dataSourceExtService.sortByPriority(vo.getRelatedMatch(), ThirdMatchVo.class);
                }
            }
        }
        *//*** 是否有盘口数据处理 ***//*
        stopWatch.stop();*/
       /* stopWatch.start("5-是否有盘口数据处理");
        this.isMarketData(returnPage, commerceList);
        stopWatch.stop();
        //  补充球队相关信息
        stopWatch.start("6-补充球队数据");
        //log.info("标准列表queryMatchByCondition的球队处理参数:{}", JSON.toJSONString(returnPage) );
        this.setSportTeamInfo(returnPage);
        stopWatch.stop();
        //对排序完的 赛事结果集 的nameCode转换 国际化语言数据
        stopWatch.start("7-转换nameCode值的国际化数据");
        this.setMatchName(returnPage);
        stopWatch.stop();
        log.info("查询赛事列表页面耗时:{}" + stopWatch.prettyPrint());*/
        return returnPage;
    }


    //1.源id搜索
    private MatchVO getThirdMatchSource(MatchQueryExt matchQueryExt) {
        String thirdMatchSourceId = matchQueryExt.getThirdMatchSourceId();
        MatchVO matchVO = new MatchVO();
        List<ThirdMatchInfo> thirdMatchInfos = thirdMatchInfoService.list(new QueryWrapper<ThirdMatchInfo>().lambda()
                .in(ThirdMatchInfo::getDataSourceCode, DataSourceCodeEnum.getCommersCode()).eq(ThirdMatchInfo::getThirdMatchSourceId, thirdMatchSourceId).last("LIMIT 1"));
        if (CollectionUtils.isEmpty(thirdMatchInfos)) {
            //log.info(PandaLog.op("getThirdMatchSource").msg("源id查询").kv(thirdMatchSourceId, JSON.toJSON(thirdMatchInfos)).toString());
            return null;
        }
        ThirdMatchInfo thirdMatchInfo = thirdMatchInfos.get(0);
        if (thirdMatchInfo.getMatchType() == Constant.TWO && matchQueryExt.getBooked() != null && thirdMatchInfo.getBooked() != matchQueryExt.getBooked()) {
            log.info("getThirdMatchSource源id查询三方赛事id:{},电竞订阅过滤;三方数据源订阅状态:{},查询订阅条件:{}", thirdMatchInfo.getId(), thirdMatchInfo.getBooked(), matchQueryExt.getBooked());
            return null;
        }
        if (thirdMatchInfo.getReferenceId().equals(Constant.DB_DEFAULT_LONG_VALUE)) {
            BeanUtils.copyProperties(thirdMatchInfo, matchVO);
            matchVO.setId(String.valueOf(thirdMatchInfo.getId()));
            matchVO.setStandard(Boolean.FALSE);
            matchVO.setStandardTournamentId(String.valueOf(thirdMatchInfo.getTournamentId()));
            matchVO.setThirdTournamentId(String.valueOf(thirdMatchInfo.getTournamentId()));
            ThirdSportTournament tournamentServiceById = thirdSportTournamentService.getById(thirdMatchInfo.getTournamentId());
            matchVO.setTournamentNameCode(tournamentServiceById.getNameCode());
        } else {
            matchVO = this.standardMatchInfoBulid(thirdMatchInfo, matchVO);
        }
        return matchVO;
    }


    private MatchVO standardMatchInfoBulid(ThirdMatchInfo thirdMatchInfo, MatchVO matchVO) {
        StandardMatchInfo standardMatchInfo = standardMatchInfoService.getById(thirdMatchInfo.getReferenceId());
        if (standardMatchInfo == null) {
            log.info("三方赛事对应的伪标准赛事或标准赛事经进入历史表,三方赛事源ID:{}", thirdMatchInfo.getThirdMatchSourceId());
            return null;
        }
        if (standardMatchInfo.getStandardTournamentId().equals(Constant.DB_DEFAULT_LONG_VALUE)) {
            BeanUtils.copyProperties(thirdMatchInfo, matchVO);
            matchVO.setId(String.valueOf(standardMatchInfo.getId()));
            matchVO.setStandard(Boolean.FALSE);
            matchVO.setThirdMatchId(String.valueOf(standardMatchInfo.getThirdMatchId()));
            matchVO.setStandardTournamentId(Constant.DB_DEFAULT_LONG_VALUE.toString());
            ThirdSportTournament tournamentServiceById = thirdSportTournamentService.getById(thirdMatchInfo.getTournamentId());
            matchVO.setTournamentNameCode(tournamentServiceById.getNameCode());
        } else {
            BeanUtils.copyProperties(standardMatchInfo, matchVO);
            matchVO.setId(String.valueOf(standardMatchInfo.getId()));
            matchVO.setThirdMatchId(String.valueOf(standardMatchInfo.getThirdMatchId()));

            matchVO.setStandard(Boolean.TRUE);
            StandardSportTournament byId = standardSportTournamentService.getById(standardMatchInfo.getStandardTournamentId());
            if (byId != null) {
                matchVO.setRegionId(byId.getRegionId());
                matchVO.setTouLogoUrl(byId.getLogoUrl());
                matchVO.setTournamentNameCode(byId.getNameCode());
                matchVO.setTournamentManagerId(byId.getTournamentManagerId());
                matchVO.setStandardTournamentId(String.valueOf(byId.getId()));
                matchVO.setTournamentLevel(byId.getTournamentLevel());
            }
            QueryWrapper<ThirdSportMarket> thirdSportMarketQueryWrapper = new QueryWrapper<>();
            thirdSportMarketQueryWrapper.lambda().eq(ThirdSportMarket::getMatchId, standardMatchInfo.getThirdMatchId()).eq(ThirdSportMarket::getMarketType, Constant.ZERO);
            List<ThirdSportMarket> list = thirdSportMarketService.list(thirdSportMarketQueryWrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                matchVO.setIsMarketData(Constant.ONE);
            }
        }
        return matchVO;
    }

}
