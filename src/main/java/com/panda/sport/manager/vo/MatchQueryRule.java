package com.panda.sport.manager.vo;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.panda.sport.manager.constant.Constant;
import com.panda.sport.manager.vo.match.MatchQueryVo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.query
 * @Description :  TODO
 * @Date: 2019-09-03 22:37
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */

public class MatchQueryRule {

    /**
     * 联赛查询，球队查询 页面 数据来源 筛选条件列表
     *
     * @param dataSourceCodeList
     * @return MatchRule
     * @description 联赛查询，球队查询 页面 数据来源 筛选条件列表
     * @author Alair
     * @date 2019/9/3 22:51
     **/
    public static MatchRule getQueryDataSourceCode(List<String> dataSourceCodeList, List<String> matchList) {
        //log.info("getTournamentPagelist2: dataSourceCodeList:{} matchList:{}" , dataSourceCodeList,matchList);
        //  关于数据源，需要重新筛选
        List<String> queryList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dataSourceCodeList)) {
           // queryList = dataSourceCodeList.stream().filter(item -> !Constant.DATA_SOURCE_PANDA.equals(item)).collect(Collectors.toList());
            queryList = dataSourceCodeList.stream().collect(Collectors.toList());
        }
        Integer queryStandardCount = null;//    标准联赛关联的第三方联赛个数
        if (CollectionUtils.isNotEmpty(matchList)) {
            if (matchList.contains(Constant.DATA_SOURCE_MA) && matchList.contains(Constant.DATA_SOURCE_UM)) {
                //   已匹配+未匹配：查询全量
            } else if (matchList.contains(Constant.DATA_SOURCE_MA) && !matchList.contains(Constant.DATA_SOURCE_UM)) {
                //   已匹配 + 其他：1.查询标准数据源  2.含两条及以上第三方数据源个数
                queryStandardCount = 2;
            } else if (!matchList.contains(Constant.DATA_SOURCE_MA) && matchList.contains(Constant.DATA_SOURCE_UM)) {
                //   未匹配 + 其他：1.查询标准数据源  2.仅1条第三方联赛生成的标准联赛   3.未关联的第三方联赛
                queryStandardCount = 1;
            }
        }
        //log.info("getTournamentPagelist3: queryList:{} queryStandardCount:{}" , queryList,queryStandardCount);
        //log.info("getTournamentPagelist4: new MatchRule:{}" , new MatchRule(queryList, queryStandardCount));
        return new MatchRule(queryList, queryStandardCount);
    }

    /**
     * 赛事 页面 数据来源 筛选条件列表
     *
     * @param dataSourceCodeList
     * @return MatchRule
     * @description 赛事  页面 数据来源 筛选条件列表
     * @author Mirro
     * @date 2019/9/7 15:51
     **/
    public static MatchRule getMatchQueryCode(List<String> dataSourceCodeList, List<String> matchList) {
        //  关于数据源，需要重新筛选
        List<String> queryList = new LinkedList<>();
        if (CollectionUtils.isNotEmpty(dataSourceCodeList)) {
            queryList = dataSourceCodeList.stream().filter(item -> !Constant.DATA_SOURCE_PANDA.equals(item)
                    && !Constant.DATA_SOURCE_MA.equals(item) && !Constant.DATA_SOURCE_UM.equals(item)).collect(Collectors.toList());
        }
        //    标准赛事关联的第三方赛事个数
        Integer queryStandardCount = null;
        if (CollectionUtils.isNotEmpty(matchList)) {
            if (matchList.contains(Constant.DATA_SOURCE_MA) && !matchList.contains(Constant.DATA_SOURCE_UM)) {
                //   已匹配 + 其他：1.查询标准数据源  2.含两条及以上第三方数据源个数
                queryStandardCount = 2;
            } else if (!matchList.contains(Constant.DATA_SOURCE_MA) && matchList.contains(Constant.DATA_SOURCE_UM)) {
                //   未匹配 + 其他：1.查询标准数据源  2.仅1条第三方联赛生成的标准联赛   3.未关联的第三方联赛
                queryStandardCount = 1;
            }
        }
        return new MatchRule(queryList, queryStandardCount);
    }

    /**
     * 是否需要查询单独的第三方联赛表 true表示需要
     *
     * @param query
     * @return boolean
     * @description 是否需要查询单独的第三方联赛表 true表示需要
     * @author Alair
     * @date 2019/9/3 22:52
     **//*
    public static boolean queryThirdFlagByTournamentQuery(TournamentQueryVo query) {
        //如果仅查询标准赛事，则不查询 第三方赛事
        if (null != query.getOnlyStandard() && query.getOnlyStandard().intValue() == Constant.DEFAULT_VALUE_ONLY_QUERY) {
            return false;
        }
        // 前端希望仅使用id 查询 指定标准联赛的数据
        if (CollectionUtils.isNotEmpty(query.getIds())) {
            return false;
        }
        // 如果指定联赛级别，则 不再查询未关联数据
        if (null != query.getTournamentLevel() && !Constant.DB_DEFAULT_INTEGER_VALUE.equals(query.getTournamentLevel())) {
            return false;
        }
        // 有联赛管理的ID 默认为 1。则不直接查询第三方联赛数据。 需要的第三方数据由 标准联赛查询结果进行查询。
        if (null != query.getTournamentManagerIdStatus() && query.getTournamentManagerIdStatus().equals(Constant.TOUR_ID_STATUS_YES)) {
            return false;
        }
        if (StringUtils.isNotEmpty(query.getTournamentManagerId())) {
            return false;
        }
        if (CollectionUtils.isNotEmpty(query.getDataSourceCode())) {
            //  如果数据源列表中仅包含 已匹配，没有 未匹配，则不查询第三方表
            return !query.getDataSourceCode().contains(Constant.DATA_SOURCE_MA) || query.getDataSourceCode().contains(Constant.DATA_SOURCE_UM);
        }
        return true;
    }
*/
    /**
     * 是否需要查询单独的第三方联赛表 true表示需要
     *
     * @param query
     * @return boolean
     * @description 是否需要查询单独的第三方联赛表 true表示需要
     * @author Alair
     * @date 2019/9/3 22:52
     **/
    public static boolean queryThirdFlagByMatchQuery(MatchQueryVo query) {
        //如果仅查询标准赛事，则不查询 第三方赛事
        if (null != query.getOnlyStandard() && query.getOnlyStandard().intValue() == Constant.DEFAULT_VALUE_ONLY_QUERY) {
            return false;
        }
        // 前端希望仅使用id 查询 指定标准联赛的数据
        if (CollectionUtils.isNotEmpty(query.getIds())) {
            return false;
        }
        // 如果指定联赛级别，则不再查询未关联数据
        if (null != query.getLeagueLevel() && query.getLeagueLevel().size() > 0 && !Constant.DB_DEFAULT_INTEGER_VALUE.equals(Integer.parseInt(query.getLeagueLevel().get(0)))) {
            return false;
        }
        //  如果搜索联赛ID 球队ID 赛事ID，则不需要查询第三方表      
        if (
                (StringUtils.isNotBlank(query.getTeamManagerId()))
                        || StringUtils.isNotBlank(query.getTournamentManagerId())
                        || StringUtils.isNotBlank(query.getTournamentManagerId())) {
            return false;
        }
       /*
        // 有联赛管理的ID 默认为 1。则不直接查询第三方联赛数据。 需要的第三方数据由 标准联赛查询结果进行查询。
        if (null != query.getTournamentManagerIdStatus() && query.getTournamentManagerIdStatus().equals(TournamentQuery.TOUR_ID_STATUS_YES)) {
            return false;
        }
        if (null != query.getTournamentManagerId() && query.getTournamentManagerId().intValue() > 0) {
            return false;
        }*/
        if (CollectionUtils.isNotEmpty(query.getDataSourceCode())) {
            //  如果数据源列表中仅包含 已匹配，没有 未匹配，则不查询第三方表
            return !query.getDataSourceCode().contains(Constant.DATA_SOURCE_MA) || query.getDataSourceCode().contains(Constant.DATA_SOURCE_UM);
        }
        return true;
    }

    /**
     * 是否需要查询单独的第三方球队表 true表示需要
     *
     * @param query
     * @return boolean
     * @description 是否需要查询单独的第三方球队表 true表示需要
     * @author Alair
     * @date 2019/9/3 22:52
     **/
    /*public static boolean queryThirdFlagBySportTeamQuery(SportTeamQueryVo query) {
        //如果仅查询标准球队，则不查询 第三方赛事
        if (null != query.getOnlyStandard() && query.getOnlyStandard().intValue() == Constant.DEFAULT_VALUE_ONLY_QUERY) {
            return false;
        }
        // 前端希望仅使用id 查询 指定标准球队的数据
        if (CollectionUtils.isNotEmpty(query.getIds())) {
            return false;
        }

        // 有球队管理的ID 默认为 1。则不直接查询第三方球队数据。 需要的第三方数据由 标准球队查询结果进行查询。
        if (null != query.getSportTeamManagerIdStatus() && query.getSportTeamManagerIdStatus().equals(Constant.TOUR_ID_STATUS_YES)) {
            return false;
        }
        if (StringUtils.isNotBlank(query.getTeamManageId())) {
            return false;
        }
        if (CollectionUtils.isNotEmpty(query.getDataSourceCode())) {
            //  如果数据源列表中仅包含 已匹配，没有 未匹配，则不查询第三方表
            return !query.getDataSourceCode().contains(Constant.DATA_SOURCE_MA) || query.getDataSourceCode().contains(Constant.DATA_SOURCE_UM);
        }
        return true;
    }*/
}
