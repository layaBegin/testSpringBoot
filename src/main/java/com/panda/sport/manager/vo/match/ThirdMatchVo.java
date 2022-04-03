package com.panda.sport.manager.vo.match;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mirro
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.vo
 * @Description:
 * @date 2019/9/5 20:01
 * @ModificationHistory Who    When    What
 */
@Data
//@ApiModel(description = "第三方赛事数据传输模型")
public class ThirdMatchVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保存多语言信息  key 语言类型    value 文本信息
     **/
    //@ApiModelProperty("所属联赛名称")
    private Map<String, String> leagueName;

    //@ApiModelProperty(value = "标准数据的数据来源(true:是；false:否)")
    private Boolean standard;

    //@ApiModelProperty(value = "主场队ID")
    private String homeTeamId;

    //@ApiModelProperty(value = "主场队名称")
    private Map<String, String> homeTeamNames;

    //@ApiModelProperty(value = "客场队ID")
    private String awayTeamId;

    ///@ApiModelProperty(value = "客场队名称")
    private Map<String, String> awayTeamNames;

    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "联赛namecode")
    private Long tournamentNameCode;

    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "联赛管理ID")
    private String tournamentManagerId;

    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "主队namecode")
    private String homeNameCode;

    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "客队namecode")
    private String awayNameCode;

    //@ApiModelProperty(value = "主场队log连接地址")
    private String homeTeamLogoUrl;

    //@ApiModelProperty(value = "主场队log缩略图连接地址")
    private String homeTeamLogoUrlThumb;

    //@ApiModelProperty(value = "客场队log连接地址")
    private String awayTeamLogoUrl;

    //@ApiModelProperty(value = "客场队log缩略图连接地址")
    private String awayTeamLogoUrlThumb;

    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "客队管理ID")
    private String awayTeamManageId;

    @JsonSerialize(using = ToStringSerializer.class)
    //@ApiModelProperty(value = "主队管理ID")
    private String homeTeamManageId;

    /**
     * id。id
     */
    //@ApiModelProperty(name = "id", notes = "id。id")
    private String id;
    /**
     * 运动种类id。 对应sport.id
     */
    //@ApiModelProperty(name = "sportId", notes = "运动种类id。 对应sport.id")
    private Long sportId;
    /**
     * 运动区域 id。 对应  sport_region.id
     */
    //@ApiModelProperty(name = "regionId", notes = "运动区域 id。 对应  sport_region.id")
    private Long regionId;
    /**
     * 联赛 id。  对应 sport_tournament.id
     */
    //@ApiModelProperty(name = "tournamentId", notes = "联赛 id。  对应 sport_tournament.id")
    private String tournamentId;
    /**
     * 比赛是否被激活。1：激活；0：未激活。 激活的比赛可以进行下注。
     */
    //@ApiModelProperty(name = "active", notes = "比赛是否被激活。1：激活；0：未激活。 激活的比赛可以进行下注。")
    private Integer active;
    /**
     * 是否支持滚球。取值为 1  或  0 。1=支持；0=不支持
     */
    //@ApiModelProperty(name = "liveOddSupport", notes = "是否支持滚球。取值为 1  或  0 。1=支持；0=不支持")
    private Integer liveOddSupport;
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
     * 距离开赛时间。 单位：秒
     */
    //@ApiModelProperty(name = "secondsMatchStart", notes = "距离开赛时间。 单位：秒")
    private Integer secondsMatchStart;
    /**
     * 主客队是否相反。与标准球队相比，主客队是否相反。0:否；1：是
     */
    //@ApiModelProperty(name = "homeAwayOpposite", notes = "主客队是否相反。与标准球队相比，主客队是否相反。0:否；1：是")
    private Integer homeAwayOpposite;
    /**
     * 标准赛事的id。关联后的赛事ID.  例如： A B 2个记录，融合结束后在 标准赛事表中生成一个新纪录。则当前记录的该字段使用新纪录的 concern_event,id  作为该字段值
     */
    //@ApiModelProperty(name = "referenceId", notes = "标准赛事的id。关联后的赛事ID.  例如： A B 2个记录，融合结束后在 标准赛事表中生成一个新纪录。则当前记录的该字段使用新纪录的 concern_event,id  作为该字段值")
    private Long referenceId;
    /**
     * 比赛开始时间。 UTC时间
     */
    //@ApiModelProperty(name = "beginTime", notes = "比赛开始时间。 UTC时间")
    private Long beginTime;
    /**
     * 是否为中立场。取值为 0  和1  。  1:是中立场，0:非中立场。操盘人员可手动处理
     */
    //@ApiModelProperty(name = "neutralGround", notes = "是否为中立场。取值为 0  和1  。  1:是中立场，0:非中立场。操盘人员可手动处理")
    private Integer neutralGround;
    /**
     * 当前比赛是否被预定。是否预定
     */
    //@ApiModelProperty(name = "booked", notes = "当前比赛是否被预定。是否预定")
    private Integer booked;
    /**
     * 数据来源编码。取值： SR BC分别代表：SportRadar、FeedConstruc。详情见data_source
     */
    //@ApiModelProperty(name = "dataSourceCode", notes = "数据来源编码。取值： SR BC分别代表：SportRadar、FeedConstruc。详情见data_source")
    private String dataSourceCode;
    /**
     * 先开球的球队。 取值： home away。home:主场队；away:客场队。
     */
    //@ApiModelProperty(name = "whoKickOff", notes = "先开球的球队。 取值： home away。home:主场队；away:客场队。")
    private String whoKickOff;
    /**
     * 比赛场地的国际化编码。
     */
    //@ApiModelProperty(name = "matchPositionNameCode", notes = "比赛场地的国际化编码。")
    private Long matchPositionNameCode;
    /**
     * 比赛场地名称,仅限中文。用于查看mysql 时 使用。
     */
    //@ApiModelProperty(name = "matchPositionName", notes = "比赛场地名称,仅限中文。用于查看mysql 时 使用。")
    private String matchPositionName;
    /**
     * 第三方赛事原始id。比如： SportRadar 发送数据时，这场比赛的ID。
     */
    //@ApiModelProperty(name = "thirdMatchSourceId", notes = "第三方赛事原始id。比如： SportRadar 发送数据时，这场比赛的ID。")
    private String thirdMatchSourceId;
    /**
     * 比赛阶段。比赛阶段取值：not_started， 1p, paused, 2p,ended, awaiting_ot, 1p_ot 2p_ot。分别代表：上半场，下半场，加时赛上半场，加时赛下半场。
     */
    //@ApiModelProperty(name = "matchPeriod", notes = "比赛阶段。比赛阶段取值：not_started， 1p, paused, 2p,ended, awaiting_ot, 1p_ot 2p_ot。分别代表：上半场，下半场，加时赛上半场，加时赛下半场。")
    private String matchPeriod;
    /**
     * 备注。
     */
    //@ApiModelProperty(name = "remark", notes = "备注。")
    private String remark;
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
     * 风控服务商编码。sr bc pa 等。详见 数据源表 data_source中的code字段
     */
    //@ApiModelProperty(name = "riskManagerCode", notes = "数据源表 data_source中的code字段")
    private String riskManagerCode;

    /**
     * 开盘使用的数据供应商编码。指的是当前赛事使用哪个数据供应商的数据。使用该数据，则使用该风控
     */
    //@ApiModelProperty(name = "matchDataProviderCode", notes = "数据源表 data_source中的code字段")
    private String matchDataProviderCode;

    /**
     * 比赛开盘标识。0：未开盘；1：开盘；2：关盘；3：封盘；开盘后用户可下注
     */
    //@ApiModelProperty(name = "operateMatchStatus", notes = " 比赛开盘标识")
    private Integer operateMatchStatus;


    //@ApiModelProperty(name = "局数(赛制)", notes = "局数(赛制).数字,例如:5,7,代表最多打5局7局")
    private Integer roundType;

    //@ApiModelProperty(name = "场地类型", notes = "1 室外泥地球场  2 室外硬地球场  3 室内硬地球场 4 室外草地球场")
    private Integer siteType;

    //@ApiModelProperty(name = "赛事状态", notes = " 赛事状态")
    private Integer matchStatus;

    /**
     * 第三方赛事下所属球队多语言信息列表，默认为顺序为  主，客，其他
     */
    //@ApiModelProperty(name = "teamName", notes = "球队多语言信息列表")
    //private List<TeamName> teamName;

}
