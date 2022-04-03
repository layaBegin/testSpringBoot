package com.panda.sport.manager.dbext.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.dbext.entity
 * @Description :  TODO
 * @Date: 2019-10-05 15:38
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ThirdMatchInfoExt extends Model<ThirdMatchInfoExt> {
    private static final long serialVersionUID = 1L;

    /**
     * 保存多语言信息  key 语言类型    value 文本信息
     **/
    private Map<String , String> leagueName;

    private Boolean standard;

    private Long homeTeamId;

    private Map<String, String> homeTeamNames;

    private Long awayTeamId;

    private Map<String, String> awayTeamNames;

    private Long tournamentNameCode;

    private String tournamentManagerId;

    private Long homeNameCode;

    private Long awayNameCode;

    private String homeTeamLogUrl;

    private String homeTeamLogUrlThumb;

    private String awayTeamLogUrl;

    private String awayTeamLogUrlThumb;

    private String awayTeamManageId;

    private String homeTeamManageId;

    /**
     * id。id
     */
    private Long id;
    /**
     * 运动种类id。 对应sport.id
     */
    private Long sportId;
    /**
     * 运动区域 id。 对应  sport_region.id
     */
    private Long regionId;
    /**
     * 联赛 id。  对应 sport_tournament.id
     */
    private Long tournamentId;
    /**
     * 比赛是否被激活。1：激活；0：未激活。 激活的比赛可以进行下注。
     */
    private Integer active;
    /**
     * 是否支持滚球。取值为 1  或  0 。1=支持；0=不支持
     */
    private Integer liveOddSupport;
    /**
     * 赛前盘下注状态。赛前盘：1 可下注；0不可下注；用于数据源控制下注状态
     */
    private Integer preMatchBetStatus;
    /**
     * 滚球下注状态。滚球中使用：1 可下注；0不可下注；用于数据源控制下注状态
     */
    private Integer liveOddsBetStatus;
    /**
     * 距离开赛时间。 单位：秒
     */
    private Integer secondsMatchStart;
    /**
     * 主客队是否相反。与标准球队相比，主客队是否相反。0:否；1：是
     */
    private Integer homeAwayOpposite;
    /**
     * 标准赛事的id。关联后的赛事ID.  例如： A B 2个记录，融合结束后在 标准赛事表中生成一个新纪录。则当前记录的该字段使用新纪录的 concern_event,id  作为该字段值
     */
    private Long referenceId;
    /**
     * 比赛开始时间。 UTC时间
     */
    private Long beginTime;
    /**
     * 是否为中立场。取值为 0  和1  。  1:是中立场，0:非中立场。操盘人员可手动处理
     */
    private Integer neutralGround;
    /**
     * 当前比赛是否被预定。是否预定
     */
    private Integer booked;
    /**
     * 数据来源编码。取值： SR BC分别代表：SportRadar、FeedConstruc。详情见data_source
     */
    private String dataSourceCode;
    /**
     * 先开球的球队。 取值： home away。home:主场队；away:客场队。
     */
    private String whoKickOff;
    /**
     * 比赛场地的国际化编码。
     */
    private Long matchPositionNameCode;
    /**
     * 比赛场地名称,仅限中文。用于查看mysql 时 使用。
     */
    private String matchPositionName;
    /**
     * 第三方赛事原始id。比如： SportRadar 发送数据时，这场比赛的ID。
     */
    private String thirdMatchSourceId;
    /**
     * 比赛阶段。比赛阶段取值：not_started， 1p, paused, 2p,ended, awaiting_ot, 1p_ot 2p_ot。分别代表：上半场，下半场，加时赛上半场，加时赛下半场。
     */
    private String matchPeriod;
    /**
     * 备注。
     */
    private String remark;
    /**
     * 创建时间。
     */
    private Long createTime;
    /**
     * 修改时间。
     */
    private Long modifyTime;

    /**
     * 比赛阶段id。取自基础表 ：match_status.id
     */
    private Long matchPeriodId;

    /**
     * 风控服务商编码。sr bc pa 等。详见 数据源表 data_source中的code字段
     */
    private String riskManagerCode;

    /**
     * 开盘使用的数据供应商编码。指的是当前赛事使用哪个数据供应商的数据。使用该数据，则使用该风控
     */
    private String matchDataProviderCode;

    /**
     * 比赛开盘标识。0：未开盘；1：开盘；2：关盘；3：封盘；开盘后用户可下注
     */
    private Integer operateMatchStatus;


//    @ApiModelProperty(name = "局数(赛制)", notes = "局数(赛制).数字,例如:5,7,代表最多打5局7局")
    private Integer roundType;

//    @ApiModelProperty(name = "场地类型",notes ="1 室外泥地球场  2 室外硬地球场  3 室内硬地球场 4 室外草地球场" )
    private Integer siteType;

//    @ApiModelProperty(name = "赛事状态", notes = "赛事状态")
    private Integer matchStatus;

    /**
     * 第三方赛事下所属球队多语言信息列表，默认为顺序为  主，客，其他
     */
    //@ApiModelProperty(name = "teamName", notes = "球队多语言信息列表")
    //private List<TeamName> teamName;
//    @ApiModelProperty(name = "三方关联ID", notes = "三方关联ID")
    private Long associationId;

//    @ApiModelProperty(name = "三方赛事ID集,分隔", notes = "三方赛事ID集,分隔")
    private String thirdIds;
}
