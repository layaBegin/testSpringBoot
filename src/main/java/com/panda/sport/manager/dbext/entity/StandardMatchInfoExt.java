package com.panda.sport.manager.dbext.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.dbext.entity
 * @Description :  TODO
 * @Date: 2019-10-05 16:03
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StandardMatchInfoExt extends Model<StandardMatchInfoExt> {
    private static final long serialVersionUID = 1L;

    /**
     * 保存多语言信息  key 语言类型    value 文本信息
     **/
    private Map<String, String> leagueName;

    private List<ThirdMatchInfoExt> relatedMatch;

    private Boolean standard;

    private Long homeTeamId;

    private Map<String, String> homeTeamNames;

    private String homeTeamLogUrl;

    private String homeTeamLogUrlThumb;

    private Long awayTeamId;

    private Map<String, String> awayTeamNames;

    private String awayTeamLogUrl;

    private String awayTeamLogUrlThumb;

    private Long tournamentNameCode;

    private String tournamentManagerId;

    private Long homeNameCode;

    private Long awayNameCode;

    private String awayTeamManageId;

    private String homeTeamManageId;

    private Long id;

    private Long sportId;
    /**
     * 标准联赛 id。对应联赛 id  对应  standard_sport_tournament.id
     */
    private Long standardTournamentId;
    /**
     * 联赛 级别。 对应标准联赛表的联赛级别
     */
    private Integer tournamentLevel;
    /**
     * 第三方比赛id。第三方比赛在 表 third_match_info 中的id
     */
    private Long thirdMatchId;
    /**
     * 滚球操盘组的id。滚球盘操盘组id
     */
    private Integer liveOperateGroupId;
    /**
     * 赛前操盘组的id。赛前盘操盘组id
     */
    private Integer preMatchOperateGroupId;
    /**
     * 操盘组负责人id。操盘责任人id
     */
    private Integer operatorLiable;
    /**
     * 赛事双方的对阵信息。格式：主场队名称 VS 客场队名称
     */
    private String homeAwayInfo;
    /**
     * 距离开赛时间。 单位：秒
     */
    private Integer secondsMatchStart;
    /**
     * 是否支持赛前盘。是否支持赛前盘。取值为 1  或  0 。1=支持；0=不支持
     */
    private Integer preMatchSupport;

    private Integer preMatchBusiness;

    /**
     * 是否支持滚球。取值为 1  或  0 。1=支持；0=不支持
     */
    private Integer liveOddSupport;

    private Integer liveOddBusiness;

    /**
     * 当前比赛共有几节。当前比赛共有几节
     */
    private Integer matchPeriodNumber;
    /**
     * 比赛开盘标识。0：未开盘；1：开盘；2：关盘；3：封盘；开盘后用户可下注
     */
    private Integer operateMatchStatus;
    /**
     * 比赛开始时间。比赛开始时间 UTC时间
     */
    private Long beginTime;
    /**
     * 比赛结束时间。当前事件结束时间，比如：足球正式宣布结束的时间
     */
    private Long endTime;
    /**
     * 比赛是否被激活。1：激活；0：未激活。 激活的比赛可以进行下注。
     */
    private Integer active;
    /**
     * 上次锁盘时间。UTC 。 仅做记录，不做下注判断。
     */
    private Long lastLockTime;
    /**
     * 上次开盘时间。UTC 。 仅做记录，不做下注判断。
     */
    private Long lastOpenTime;
    /**
     * 是否支持串关。1 支持串关;0 不支持串关
     */
    private Integer canParlay;
    /**
     * 赛前盘下注状态。赛前盘：1 可下注；0不可下注；用于数据源控制下注状态
     */
    private Integer preMatchBetStatus;
    /**
     * 滚球下注状态。滚球中使用：1 可下注；0不可下注；用于数据源控制下注状态
     */
    private Integer liveOddsBetStatus;
    /**
     * 赛事状态。0:not_started;1:live;2:suspended;3:ended;4:closed;5:cancelled;6:abandoned;7:delayed;8:unknown;9:post
     */
    private Integer matchStatus;
    /**
     * 是否为中立场。取值为 0  和1  。  1:是中立场，0:非中立场。操盘人员可手动处理
     */
    private Integer neutralGround;
    /**
     * 对用户可见。1：可见； 0：不可见
     */
    private Integer visible;
    /**
     * 比赛是否结束。0: 未结束； 1：结束。（比赛彻底结束，双方不再有加时赛，点球大战，且裁判宣布结束）
     */
    private Integer matchOver;
    /**
     * 标准赛事编码。用于管理的赛事id
     */
    private String matchManageId;

    /**
     * 比赛场地名称,仅限中文。用于查看mysql 时 使用。
     */
    private String matchPositionName;

    /**
     * 比赛场地的国际化编码。
     */
    private Long matchPositionNameCode;

    /**
     * 谁先晋级。 取值： home away both none 。home:主场队；away:客场队；both: 都晋级；none ：都没晋级
     */
    private String whoAdvance;
    /**
     * 先开球的球队。 取值： home away。home:主场队；away:客场队。
     */
    private String whoKickOff;
    /**
     * 风控服务商编码。sr bc pa 等。详见 数据源表 data_source中的code字段
     */
    private String riskManagerCode;
    /**
     * 赛事来源编码。赛事由那个数据商的第三方数据导致创建。sr bc pa 等。详见 数据源表 data_source中的code字段
     */
    private String dataSourceCode;

    /**
     * 关联数据源个数。 被关联的第三方数据源个数
     */
    private Integer relatedDataSourceCoderNum;
    /**
     * 关联数据源编码列表。 数据样例：SR,BC,188; SR,188; BC,188
     */
    private String relatedDataSourceCoderList;
    /**
     * 开盘使用的数据供应商编码。指的是当前赛事使用哪个数据供应商的数据。使用该数据，则使用该风控
     */
    private String matchDataProviderCode;

    /**
     * 第三方赛事原始id。该厂比赛在第三方数据供应商中的id。比如： SportRadar 发送数据时，这场比赛的ID。
     */
    private String thirdMatchSourceId;
    /**
     * 比分。 仅显示 90分钟内的比分。
     */
    private String score;
    /**
     * 比赛阶段id。取自基础表 ：match_status.id
     */
    private Long matchPeriodId;
    /**
     * 备注。
     */
    private String remark;

    /**
     * 赛事是否被订阅
     */
    private Integer booked;

    /**
     * 赛事类型，电竞赛事或是常规赛事
     */
    private Integer matchType;

    /**
     * 联赛的多语言锁状态
     */
    private Integer leagueIsLock;
    /**
     * 创建时间。
     */
    private Long createTime;
    /**
     * 修改时间。
     */
    private Long modifyTime;

    /**
     * 标准赛事下所属球队多语言信息列表，默认为顺序为  主，客，其他
     */
    //@ApiModelProperty(name = "teamName", notes = "球队多语言信息列表")
    //private List<TeamName> teamName;

    /**
     * 标准赛事下所属球队管理ID列表，默认为顺序为  主，客，其他
     */
    private List<Long> teamManageId;

    /**
     * 局数(赛制).数字,例如:5,7,代表最多打5局7局
     */
    private Integer roundType;

    /**
     * 场地类型 1 室外泥地球场  2 室外硬地球场  3 室内硬地球场 4 室外草地球场
     */
    private Integer siteType;

    /**
     *是否有新的三方赛事 0 没有 1 有
     */
    private Integer newThird;

    /**
     * 账务时间
     */
    private Long financialTime;

    /**
     * 主客队是否相反
     */
    private Integer homeAwayOpposite;

//    @ApiModelProperty(name = "三方关联ID", notes = "三方关联ID")
    private String associationId;

//    @ApiModelProperty(name = "三方赛事ID集,分隔", notes = "三方赛事ID集,分隔")
    private String thirdIds;

//    @ApiModelProperty(name = "Out:In", notes = "'移出 Out,移入 In',")
    private String soldFlag;

//    @ApiModelProperty(name = "标准赛事是否标反", notes = "Reverse:相反,Positive:未标反")
    private String reverseStatus;

//    @ApiModelProperty(name = "联赛logo信息", notes = "联赛logo信息")
    private String touLogoUrl;

//    @ApiModelProperty(name = "联赛官网信息", notes = "联赛官网信息")
    private String leagueUrl;

//    @ApiModelProperty(name = "是否为子联赛", notes = "0 否 1 是")
    private Integer simpleFlage;

//    @ApiModelProperty(name = "联赛轮次", notes = "联赛轮次")
    private Integer tournamentRoundNumber;

//    @ApiModelProperty(name = "赛季seasonNameCode", notes = "赛季seasonNameCode")
    private Long seasonNameCode;

//    @ApiModelProperty(name = "赛季开始时间", notes = "赛季开始时间")
    private Long startDate;

//    @ApiModelProperty(name = "赛季结束时间", notes = "赛季结束时间")
    private Long endDate;



    /**
     * 0:系统更新  1:人工更新
     */
    private Integer neutralGroundStatus = 0;
    /*** 区域id ***/
    private Long regionId;


    /*** 赛事联赛别名Code ***/
    private Long tournamentMatchNameCode;

    /*** 彩票号.(爬虫爬取) ***/
    private String lotteryNumber;
}
