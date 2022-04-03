package com.panda.sport.manager.dbext.entity;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

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
public class MatchQueryExt {
    /**
     * 每页数据个数
     **/
    private Integer size;

    /**
     * 体育种类id
     */
    private Long sportId;

    /**
     * 从第几页开始
     **/
    private Integer page;

    private List<Long> ids;

    private Integer onlyStandard;

    //@ApiModelProperty(name = "赛事状态")
    private Long matchStatus;
    //@ApiModelProperty(name = "赛事阶段", notes = "")
    private Long matchPeriodId;

    private Integer isEarlyTrading;

    private Long startTime;

    private Long endTime;

    private List<String> leagueLevel;

    //@ApiModelProperty(name = "三方赛事id", notes = "三方赛事id")
    private List<Long> thirds;
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
    /**
     * 数据来源编码。
     **/
    private List<String> dataSourceCode;

    /**
     * 商业数据源编码。 用于在第三方赛事列表中查询
     **/
    private List<String> commerceDataSourceCode;
    /**
     * 匹配规则列表
     **/
    private List<String> matchList;

    private String oddStatusFirst;

    private Integer oddStatusSecond;

    private Integer historyFlag;

    /**
     * 是否查询滚球
     */
    private Integer liveOddQuery;

    private String teamName;

    private String teamManagerId;

    private String tournamentName;

    private String tournamentManagerId;

    private String matchManageId;

    private Set<Long> thirdTouIds;

    private Set<Long> standardTouIds;

    private Integer booked;

    private Integer bookedPlus;

    private String thirdMatchSourceId;

    /*** 是否分页 ***/
    private Integer isPage;

}
