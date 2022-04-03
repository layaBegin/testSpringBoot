package com.panda.sport.manager.vo.match;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Mirro
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.vo
 * @Description:
 * @date 2019/9/5 11:38
 * @ModificationHistory Who    When    What
 */
@Data
//@ApiModel(description = "赛事数据传输模型")
public class MatchVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 保存多语言信息  key 语言类型    value 文本信息
     **/
    //@ApiModelProperty("所属联赛名称")
    private Map<String , String> leagueName;

    //@ApiModelProperty("关联第三方赛事")
    private List<ThirdMatchVo> relatedMatch;

    //@ApiModelProperty(value = "标准数据的数据来源(true:是；false:否)")
    private Boolean standard;

    //@ApiModelProperty(value = "主场队ID")
    private String homeTeamId;

    //@ApiModelProperty(value = "主场队名称")
    private Map<String, String> homeTeamNames;

    //@ApiModelProperty(value = "赛事赛季国际化")
    private Map<String, String> seasonNameCodes;

    //@ApiModelProperty(value = "主场队log连接地址")
    private String homeTeamLogoUrl;

    //@ApiModelProperty(value = "主场队log缩略图连接地址")
    private String homeTeamLogoUrlThumb;

//    @ApiModelProperty(value = "主场队log连接地址")
    private String homeTeamLogoUrl2;

//    @ApiModelProperty(value = "主场队log缩略图连接地址")
    private String homeTeamLogoUrlThumb2;

//    @ApiModelProperty(value = "客场队ID")
    private String awayTeamId;

//    @ApiModelProperty(value = "客场队名称")
    private Map<String, String> awayTeamNames;

//    @ApiModelProperty(value = "客场队log连接地址")
    private String awayTeamLogoUrl;

//    @ApiModelProperty(value = "客场队log缩略图连接地址")
    private String awayTeamLogoUrlThumb;

//    @ApiModelProperty(value = "客场队log连接地址")
    private String awayTeamLogoUrl2;

//    @ApiModelProperty(value = "客场队log缩略图连接地址")
    private String awayTeamLogoUrlThumb2;

//    @ApiModelProperty(name = "联赛logo信息", notes = "联赛logo信息")
    private String touLogoUrl;

    @JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty(value = "联赛namecode")
    private Long tournamentNameCode;

    @JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty(value = "联赛管理ID")
    private String tournamentManagerId;

    @JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty(value = "主队namecode")
    private String homeNameCode;

    @JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty(value = "客队namecode")
    private String awayNameCode;

    @JsonSerialize(using= ToStringSerializer.class)
//    @ApiModelProperty(value = "客队管理ID")
    private String awayTeamManageId;

    @JsonSerialize(using= ToStringSerializer.class)
//    @ApiModelProperty(value = "主队管理ID")
    private String homeTeamManageId;


    /**
     * id。id
     */
//    @ApiModelProperty(name = "id", notes = "id。id")
    private String id;
    /**
     * 体育种类id。运动种类id 对应sport.id
     */
//    @ApiModelProperty(name = "sportId", notes = "体育种类id。运动种类id 对应sport.id")
    private Long sportId;
    /**
     * 标准联赛 id。对应联赛 id  对应  standard_sport_tournament.id
     */
//    @ApiModelProperty(name = "standardTournamentId", notes = "标准联赛 id。对应联赛 id  对应  standard_sport_tournament.id")
    private String standardTournamentId;

    /**
     * 标准联赛 id。对应联赛 id  对应  standard_sport_tournament.id
     */
//    @ApiModelProperty(name = "thirdTournamentId", notes = "三方联赛 id。对应联赛 id  对应  thirdTournamentId.id")
    private String thirdTournamentId;
    /**
     * 联赛 级别。 对应标准联赛表的联赛级别
     */
//    @ApiModelProperty(name = "tournamentLevel", notes = "联赛 级别。 对应标准联赛表的联赛级别")
    private Integer tournamentLevel;
    /**
     * 第三方比赛id。第三方比赛在 表 third_match_info 中的id
     */
//    @ApiModelProperty(name = "thirdMatchId", notes = "第三方比赛id。第三方比赛在 表 third_match_info 中的id")
    private String thirdMatchId;
    /**
     * 滚球操盘组的id。滚球盘操盘组id
     */
//    @ApiModelProperty(name = "liveOperateGroupId", notes = "滚球操盘组的id。滚球盘操盘组id")
    private Integer liveOperateGroupId;
    /**
     * 赛前操盘组的id。赛前盘操盘组id
     */
//    @ApiModelProperty(name = "preMatchOperateGroupId", notes = "赛前操盘组的id。赛前盘操盘组id")
    private Integer preMatchOperateGroupId;
    /**
     * 操盘组负责人id。操盘责任人id
     */
//    @ApiModelProperty(name = "operatorLiable", notes = "操盘组负责人id。操盘责任人id")
    private Integer operatorLiable;
    /**
     * 赛事双方的对阵信息。格式：主场队名称 VS 客场队名称
     */
//    @ApiModelProperty(name = "homeAwayInfo", notes = "赛事双方的对阵信息。格式：主场队名称 VS 客场队名称")
    private String homeAwayInfo;
    /**
     * 距离开赛时间。 单位：秒
     */
//    @ApiModelProperty(name = "secondsMatchStart", notes = "比赛开始时间。 单位：秒")
    private Integer secondsMatchStart;
    /**
     * 是否支持赛前盘。是否支持赛前盘。取值为 1  或  0 。1=支持；0=不支持
     */
//    @ApiModelProperty(name = "preMatchSupport", notes = "是否支持赛前盘。是否支持赛前盘。取值为 1  或  0 。1=支持；0=不支持")
    private Integer preMatchSupport;

//    @ApiModelProperty(name = "preMatchBusiness", notes = "赛事是否开放滚球. 取值为 1  或  0.  1=开放; 0=不开放")
    private Integer preMatchBusiness;


//    @ApiModelProperty(name = "homeBlock", notes = "球队是否黑名单. 0 否  1 是")
    private Integer homeBlock;


//    @ApiModelProperty(name = "awayBlock", notes = "球队是否黑名单. 0 否  1 是")
    private Integer awayBlock;

    /**
     * 是否支持滚球。取值为 1  或  0 。1=支持；0=不支持
     */
//    @ApiModelProperty(name = "liveOddSupport", notes = "是否支持滚球。取值为 1  或  0 。1=支持；0=不支持")
    private Integer liveOddSupport;

//    @ApiModelProperty(name = "liveOddBusiness", notes = "赛事是否开放赛前盘. 取值为 1  或  0.  1=开放; 0=不开放")
    private Integer liveOddBusiness;

    /**
     * 当前比赛共有几节。当前比赛共有几节
     */
//    @ApiModelProperty(name = "matchPeriodNumber", notes = "当前比赛共有几节。当前比赛共有几节")
    private Integer matchPeriodNumber;
    /**
     * 比赛开盘标识。0：未开盘；1：开盘；2：关盘；3：封盘；开盘后用户可下注
     */
//    @ApiModelProperty(name = "operateMatchStatus", notes = "比赛开盘标识。0：未开盘；1：开盘；2：关盘；3：封盘；开盘后用户可下注")
    private Integer operateMatchStatus;
    /**
     * 比赛开始时间。比赛开始时间 UTC时间
     */
//    @ApiModelProperty(name = "beginTime", notes = "比赛开始时间。比赛开始时间 UTC时间")
    private Long beginTime;
    /**
     * 比赛结束时间。当前事件结束时间，比如：足球正式宣布结束的时间
     */
//    @ApiModelProperty(name = "endTime", notes = "比赛结束时间。当前事件结束时间，比如：足球正式宣布结束的时间")
    private Long endTime;
    /**
     * 比赛是否被激活。1：激活；0：未激活。 激活的比赛可以进行下注。
     */
    //@ApiModelProperty(name = "active", notes = "比赛是否被激活。1：激活；0：未激活。 激活的比赛可以进行下注。")
    private Integer active;
    /**
     * 上次锁盘时间。UTC 。 仅做记录，不做下注判断。
     */
    //@ApiModelProperty(name = "lastLockTime", notes = "上次锁盘时间。UTC 。 仅做记录，不做下注判断。")
    private Long lastLockTime;
    /**
     * 上次开盘时间。UTC 。 仅做记录，不做下注判断。
     */
    //@ApiModelProperty(name = "lastOpenTime", notes = "上次开盘时间。UTC 。 仅做记录，不做下注判断。")
    private Long lastOpenTime;
    /**
     * 是否支持串关。1 支持串关;0 不支持串关
     */
    //@ApiModelProperty(name = "canParlay", notes = "是否支持串关。1 支持串关;0 不支持串关")
    private Integer canParlay;
    /**
     * 赛前盘下注状态。赛前盘：1 可下注；0不可下注；用于数据源控制下注状态
     */
    //@ApiModelProperty(name = "preMatchBetStatus", notes = "赛前盘下注状态。赛前盘：1 可下注；0不可下注；用于数据源控制下注状态")
    private Integer preMatchBetStatus;
    /**
     * 滚球下注状态。滚球中使用：1 可下注；0不可下注；用于数据源控制下注状态
     */
    //@ApiModelProperty(name = "liveOddsBetStatus", notes = "滚球下注状态。滚球中使用：1 可下注；0不可下注；用于数据源控制下注状态")
    private Integer liveOddsBetStatus;
    /**
     * 赛事状态。0:not_started;1:live;2:suspended;3:ended;4:closed;5:cancelled;6:abandoned;7:delayed;8:unknown;9:post
     */
    //@ApiModelProperty(name = "matchStatus", notes = "赛事状态。0:not_started;1:live;2:suspended;3:ended;4:closed;5:cancelled;6:abandoned;7:delayed;8:unknown;9:post")
    private Integer matchStatus;
    /**
     * 是否为中立场。取值为 0  和1  。  1:是中立场，0:非中立场。操盘人员可手动处理
     */
    //@ApiModelProperty(name = "neutralGround", notes = "是否为中立场。取值为 0  和1  。  1:是中立场，0:非中立场。操盘人员可手动处理")
    private Integer neutralGround;
    /**
     * 对用户可见。1：可见； 0：不可见
     */
    //@ApiModelProperty(name = "visible", notes = "对用户可见。1：可见； 0：不可见")
    private Integer visible;
    /**
     * 比赛是否结束。0: 未结束； 1：结束。（比赛彻底结束，双方不再有加时赛，点球大战，且裁判宣布结束）
     */
    //@ApiModelProperty(name = "matchOver", notes = "比赛是否结束。0: 未结束； 1：结束。（比赛彻底结束，双方不再有加时赛，点球大战，且裁判宣布结束）")
    private Integer matchOver;
    /**
     * 标准赛事编码。用于管理的赛事id
     */
    //@ApiModelProperty(name = "matchManageId", notes = "标准赛事编码。用于管理的赛事id")
    private String matchManageId;

    /**
     * 比赛场地名称,仅限中文。用于查看mysql 时 使用。
     */
    @JsonSerialize(using= ToStringSerializer.class)
    //@ApiModelProperty(name = "matchPositionName", notes = "比赛场地名称,仅限中文。用于查看mysql 时 使用。")
    private String matchPositionName;

    /**
     * 比赛场地的国际化编码。
     */
    //@ApiModelProperty(name = "matchPositionNameCode", notes = "比赛场地的国际化编码。")
    private Long matchPositionNameCode;

    /**
     * 谁先晋级。 取值： home away both none 。home:主场队；away:客场队；both: 都晋级；none ：都没晋级
     */
    //@ApiModelProperty(name = "whoAdvance", notes = "谁先晋级。 取值： home away both none 。home:主场队；away:客场队；both: 都晋级；none ：都没晋级")
    private String whoAdvance;
    /**
     * 先开球的球队。 取值： home away。home:主场队；away:客场队。
     */
    //@ApiModelProperty(name = "whoKickOff", notes = "先开球的球队。 取值： home away。home:主场队；away:客场队。")
    private String whoKickOff;
    /**
     * 风控服务商编码。sr bc pa 等。详见 数据源表 data_source中的code字段
     */
    //@ApiModelProperty(name = "riskManagerCode", notes = "风控服务商编码。sr bc pa 等。详见 数据源表 data_source中的code字段")
    private String riskManagerCode;
    /**
     * 赛事来源编码。赛事由那个数据商的第三方数据导致创建。sr bc pa 等。详见 数据源表 data_source中的code字段
     */
    //@ApiModelProperty(name = "dataSourceCode", notes = "赛事来源编码。赛事由那个数据商的第三方数据导致创建。sr bc pa 等。详见 数据源表 data_source中的code字段")
    private String dataSourceCode;

    /**
     * 关联数据源个数。 被关联的第三方数据源个数
     */
    //@ApiModelProperty(name = "relatedDataSourceCoderNum", notes = "关联数据源个数。 被关联的第三方数据源个数")
    private Integer relatedDataSourceCoderNum;
    /**
     * 关联数据源编码列表。 数据样例：SR,BC,188; SR,188; BC,188
     */
    //@ApiModelProperty(name = "relatedDataSourceCoderList", notes = "关联数据源编码列表。 数据样例：SR,BC,188; SR,188; BC,188")
    private String relatedDataSourceCoderList;
    /**
     * 开盘使用的数据供应商编码。指的是当前赛事使用哪个数据供应商的数据。使用该数据，则使用该风控
     */
    //@ApiModelProperty(name = "matchDataProviderCode", notes = "开盘使用的数据供应商编码。指的是当前赛事使用哪个数据供应商的数据。使用该数据，则使用该风控")
    private String matchDataProviderCode;

    /**
     * 第三方赛事原始id。该厂比赛在第三方数据供应商中的id。比如： SportRadar 发送数据时，这场比赛的ID。
     */
    //@ApiModelProperty(name = "thirdMatchSourceId", notes = "第三方赛事原始id。该厂比赛在第三方数据供应商中的id。比如： SportRadar 发送数据时，这场比赛的ID。")
    private String thirdMatchSourceId;

    /**
     * 比分。 仅显示 90分钟内的比分。
     */
    //@ApiModelProperty(name = "score", notes = "比分。 仅显示 90分钟内的比分。")
    private String score;
    /**
     * 比赛阶段id。取自基础表 ：match_status.id
     */
    //@ApiModelProperty(name = "matchPeriodId", notes = "比赛阶段id。取自基础表 ：match_status.id")
    private Long matchPeriodId;

    /**
     * 备注。
     */
    //@ApiModelProperty(name = "remark", notes = "备注。")
    private String remark;

    /**
     * 赛事是否被订阅
     */
    //@ApiModelProperty(name = "赛事是否被订阅", notes = "赛事是否被订阅")
    private Integer booked;

    /**
     * league多语言编辑Lock状态
     */
    //@ApiModelProperty(name = "leagueIsLock", notes = "联赛多语言编辑Lock状态")
    private Integer leagueIsLock;

    /**
     * awayTeam多语言编辑Lock状态
     */
    //@ApiModelProperty(name = "awayTeamIsLock", notes = "客队多语言编辑Lock状态")
    private Integer awayTeamIsLock;

    /**
     * homeTeam多语言编辑Lock状态
     */
    //@ApiModelProperty(name = "homeTeamIsLock", notes = "主队多语言编辑Lock状态")
    private Integer homeTeamIsLock;

    /**
     * 创建时间。
     */
    //@ApiModelProperty(name = "createTime", notes = "创建时间。")
    private Long createTime;
    /**
     * 修改时间。
     */
    //@ApiModelProperty(name = "modifyTime", notes = "修改时间。")
    private Long modifyTime;

    /**
     *是否有新的三方赛事 0 没有 1 有
     */
    private Integer newThird;

    /**
     * 标准赛事下所属球队多语言信息列表，默认为顺序为  主，客，其他
     */
    //@ApiModelProperty(name = "teamName", notes = "球队多语言信息列表")
    //private List<TeamName> teamName;

    /**
     * 标准赛事下所属球队管理ID列表，默认为顺序为  主，客，其他
     */
    //@ApiModelProperty(name = "teamManageId", notes = "球队管理ID列表")
    private List<String> teamManageId;

    //@ApiModelProperty(name = "局数(赛制)", notes = "局数(赛制).数字,例如:5,7,代表最多打5局7局")
    private Integer roundType;

    //@ApiModelProperty(name = "场地类型",notes ="1 室外泥地球场  2 室外硬地球场  3 室内硬地球场 4 室外草地球场" )
    private Integer siteType;

    //@ApiModelProperty(name = "financialTime",notes = "账务时间")
    private Long financialTime;
    //@ApiModelProperty(name = "homeAwayOpposite",notes = "主客队是否相反 0:否; 1:是 ")
    private Integer homeAwayOpposite;
    /**
     * 早盘操盘平台
     */
    //@ApiModelProperty(name = "早盘操盘平台", notes = "早盘操盘平台。")
    private String preRiskManagerCode;

    /**
     * 滚球操盘平台
     */
    //@ApiModelProperty(name = "滚球操盘平台", notes = "滚球盘平台。")
    private String liveRiskManagerCode;

    /**
     * 影响级别. 该字段用于给前端返回当前赛事被球队影响的情况.
     */
    //@ApiModelProperty(name = "影响级别", notes = "0:需要取消关联的赛事;1:需要停售操作的赛事;2:可删除数据;")
    private Integer affectedLevel;

    //@ApiModelProperty(name = "三方关联ID", notes = "三方关联ID")
    private String associationId;

    //@ApiModelProperty(name = "三方赛事ID集,分隔", notes = "三方赛事ID集,分隔")
    private String thirdIds;

    //@ApiModelProperty(name = "是否预售", notes = "Out ,In")
    private String soldFlag;

    //@ApiModelProperty(name = "是否标方", notes = "Reverse:反, Positive:正")
    private String reverseStatus;

   // @ApiModelProperty(name = "球队类型", notes = "球队类型.1:男子团体;2:男子单打;3:女子单打;4:男子双打体;5,女子双打6:混合双打,7,其它,8:女子团体;")
    private Integer teamType;

    //@ApiModelProperty(name = "区域id", notes = "区域id")
    private Long regionId;

    //@ApiModelProperty(name = "是否有盘口数据", notes = "0:没有 1:有")
    private Integer isMarketData = 0;

    //@ApiModelProperty(name = "联赛官网地址", notes = "联赛官网地址")
    private String leagueUrl;

    //@ApiModelProperty(name = "是否为子联赛", notes = "0 否 1 是")
    private Integer simpleFlage;

    //@ApiModelProperty(name = "联赛轮次", notes = "联赛轮次")
    private Integer tournamentRoundNumber;

    //@ApiModelProperty(name = "赛季seasonNameCode", notes = "赛季seasonNameCode")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long seasonNameCode;

    //@ApiModelProperty(name = "赛季开始时间", notes = "赛季开始时间")
    private Long startDate;

    //@ApiModelProperty(name = "赛季结束时间", notes = "赛季结束时间")
    private Long endDate;

    //@ApiModelProperty(name = "赛事联赛国际化", notes = "赛事联赛国际化")
    private Long tournamentMatchNameCode;

    //@ApiModelProperty(name = "彩票号.(爬虫爬取)", notes = "彩票号.(爬虫爬取)")
    private String lotteryNumber;
}
