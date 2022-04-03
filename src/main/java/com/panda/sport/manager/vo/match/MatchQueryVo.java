package com.panda.sport.manager.vo.match;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author :  dorich
 * @project Name :  panda_data_service
 * @package Name :  com.panda.sports.manager.query
 * @description :   查询比赛的条件 vo
 * @date: 2019-08-07 13:09
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Data
@Slf4j
//@ApiModel(description = "比赛查询条件")
public class MatchQueryVo {
    /**
     * 每页数据个数
     **/
    //@ApiModelProperty(name = "每页数据量，默认50")
    private Integer size = 50;

    /**
     * 体育种类id
     */
    //@ApiModelProperty(name = "体育种类")
    private Long sportId;

    /**
     * 从第几页开始
     **/
    //@ApiModelProperty(name = "从第几页开始，默认1")
    private Integer page = 1;

    //@ApiModelProperty(name = "标准赛事的id列表", notes = "标准赛事的id列表")
    private List<Long> ids;

    //@ApiModelProperty(name = "三方赛事id", notes = "三方赛事id")
    private List<Long> thirds;

    //@ApiModelProperty(name = "是否仅查询标准赛事", notes = "1:仅查询标准赛事")
    private Integer onlyStandard;


    //@ApiModelProperty(name = "赛事状态")
    private Long matchStatus;
    //@ApiModelProperty(name = "赛事阶段", notes = "")
    private Long matchPeriodId;

    //@ApiModelProperty(name = "比赛开始时间上限参数", notes = "时间戳精确到毫秒，UTC时间")
    private Long startTimeFrom;

    //@ApiModelProperty(name = "比赛结束时间上限参数", notes = "时间戳精确到毫秒，UTC时间")
    private Long endTimeFrom;

    //@ApiModelProperty(name = "是否为其他早盘", notes = "1：其他早盘； 其他查询页面可以不传或传0")
    private Integer isEarlyTrading;

    //@ApiModelProperty(name = "联赛级别")
    private List<String> leagueLevel;

    /**
     * 数据来源编码。
     **/
    //@ApiModelProperty(name = "联赛数据来源编码列表", notes = "联赛数据来源编码列表. SR BC 其余值: 全部")
    private List<String> dataSourceCode;

    /**
     * 商业数据源编码。 用于在第三方赛事列表中查询
     **/
    private List<String> commerceDataSourceCode;
    /**
     * 匹配规则列表
     **/
    //@ApiModelProperty(name = "匹配规则", notes = "匹配规则。MA:已匹配；UMA:未匹配；其他任意值：全部")
    private List<String> matchList;

    /**
     * 可以移入预开售
     **/
    //@ApiModelProperty(name = "可以移入预开售赛事", notes = "可以移入预开售赛事还未移入的标准赛事")
    private Integer canMoveIntoPreSale;

    /**
     * 一小时以内推得赛事
     **/
    //@ApiModelProperty(name = "一小时以内推得赛事", notes = "一小时以内推得赛事")
    private Integer oneHourMatch;

    //@ApiModelProperty(name = "盘口状态-数据供应商")
    private String oddStatusFirst;

    //@ApiModelProperty(name = "盘口状态-开盘状态", notes = "0：未开盘；1：开盘；2：关盘；3：封盘；开盘后用户可下注")
    private Integer oddStatusSecond;

    //@ApiModelProperty(name = "是否查询历史赛程", notes = "0：非历史；1：历史；")
    private Integer historyFlag;

    //@ApiModelProperty(name = "是否查询滚球", notes = "0：不查询；1：查询；")
    private Integer liveOddQuery;

    //@ApiModelProperty(name = "球队名", notes = "球队名，主场客场都搜，搜索标准赛事对应的标准球队名(中文简体和英文)或独立的第三方赛事对应第三方球队名(中文简体和英文)")
    private String teamName;

    //@ApiModelProperty(name = "球队管理ID", notes = "球队管理ID，主场客场都搜，搜索标准赛事对应的标准球队管理ID")
    private String teamManagerId;

    //@ApiModelProperty(name = "联赛名", notes = "联赛名，搜索标准赛事对应的标准联赛名(中文简体和英文)或独立的第三方赛事对应第三方联赛名(中文简体和英文)")
    private String tournamentName;

    //@ApiModelProperty(name = "联赛管理ID", notes = "联赛管理ID，搜索标准赛事对应的标准球队管理ID")
    private String tournamentManagerId;

    //@ApiModelProperty(name = "赛事管理ID", notes = "赛事管理ID，搜索标准赛事对应的赛事管理ID")
    private String matchManageId;

    //@ApiModelProperty(name = "联赛信息", notes = "联赛信息")
    List<MatchTouInfoVO> touLanguagelist;

    //@ApiModelProperty(name = "三方赛事源Id", notes = "三方赛事源Id")
    private String thirdMatchSourceId;

    /*** 是否分页 0: 否  null 是 ***/
    private Integer isPage;

    //@ApiModelProperty(name = "联赛官网地址", notes = "联赛官网地址")
    private String leagueUrl;

    //@ApiModelProperty(name = "联赛別名", notes = "联赛別名")
    private String tournamentNameCode;

    //@ApiModelProperty(name = "彩票号.(爬虫爬取)", notes = "彩票号.(爬虫爬取)")
    private String lotteryNumber;

    //@ApiModelProperty(name = "赛事是否被订阅", notes = "赛事是否被订阅")
    private Integer booked;

    public MatchQueryVo() {

        //  设置默认值，跟前端保持一致，GMT+4  时间
        //this.startTimeFrom = TimeUtils.getPageToday();
    }
}
