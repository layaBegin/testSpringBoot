package com.panda.sport.manager.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author CodeGenerator
 * @since 2021-06-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("standard_match_info")
public class StandardMatchInfo extends Model<StandardMatchInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * id. id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 体育种类id. 运动种类id 对应sport.id
     */
    private Long sportId;

    /**
     * 标准联赛 id. 对应联赛 id  对应  standard_sport_tournament.id
     */
    private Long standardTournamentId;

    /**
     * 第三方比赛id. 第三方比赛在 表 third_match_info 中的id
     */
    private Long thirdMatchId;

    /**
     * 比赛进行时间. 单位:秒.例如:3分钟11秒,则该值是 191
     */
    private Integer secondsMatchStart;

    /**
     * seconds_match_start被修改时刻的时间戳.单位:毫秒
     */
    private Long secondsMatchModifyTime;

    /**
     * 赛事是否开放赛前盘. 取值为 1  或  0.  1=开放; 0=不开放
     */
    private Integer preMatchBusiness;

    /**
     * 赛事是否开放滚球. 取值为 1  或  0.  1=开放; 0=不开放
     */
    private Integer liveOddBusiness;

    /**
     * 是否接受到滚球赔率：0(否),1(是)
     */
    private Integer oddsLive;

    /**
     * 比赛开盘标识. 0: 开盘; 1: 封盘; 2:关盘; 11:锁盘;
     */
    private Integer operateMatchStatus;

    /**
     * 比赛开始时间. 比赛开始时间 UTC时间
     */
    private Long beginTime;

    /**
     * 0:系统更新  1:人工更新
     */
    private Integer beginTimeStatus;

    /**
     * 比赛是否被激活. 1: 激活; 0: 未激活.  激活的比赛可以进行下注. 
     */
    private Integer active;

    /**
     * 赛事状态.  比如:未开赛, 滚球, 取消, 延迟等.  取system_item_dic中的value字段
     */
    private Integer matchStatus;

    /**
     * 是否为中立场. 取值为 0  和1  .   1:是中立场, 0:非中立场. 操盘人员可手动处理
     */
    private Integer neutralGround;

    /**
     * 0:系统更新  1:人工更新
     */
    private Integer neutralGroundStatus;

    /**
     * 标准赛事编码. 用于管理的赛事id
     */
    private String matchManageId;

    /**
     * 比赛场地名称,仅限中文. 用于查看mysql 时 使用. 
     */
    private String matchPositionName;

    /**
     * 比赛场地的国际化编码
     */
    private Long matchPositionNameCode;

    /**
     * 风控服务商编码.   详见 数据源表 data_source中的code字段
     */
    private String riskManagerCode;

    /**
     * 数据来源编码. 取值见: data_source.code
     */
    private String dataSourceCode;

    /**
     * 关联数据源编码列表.  数据样例: SR,BC,188; SR,188; BC,188
     */
    private String relatedDataSourceCoderList;

    /**
     * 关联数据源数量
     */
    private Integer relatedDataSourceCoderNum;

    /**
     * 数据供应商编码. 取值见: data_source.code
     */
    private String matchDataProviderCode;

    /**
     * 第三方赛事原始id. 
     */
    private String thirdMatchSourceId;

    /**
     * 赛事双方的对阵信息.格式:主场队名称 VS 客场队名称
     */
    private String homeAwayInfo;

    /**
     * Reverse:相反,Positive
     */
    private String reverseStatus;

    /**
     * 父赛事id
     */
    private Long parentId;

    /**
     * 比赛暂停. 0:未暂停;1:暂停.
     */
    private Integer whetherStop;

    /**
     * 赛事可下注状态. 0: betstart; 1: betstop
     */
    private Integer betStatus;

    /**
     * 赛事包含的所有球队多语言信息,json串,冗余字段,用于赛程页面查询
     */
    private String teamName;

    /**
     * 赛事包含的所有球队id信息,json串,冗余字段,用于赛程页面查询
     */
    private String teamManageId;

    /**
     * 比赛阶段id.   取system_item_dic中的value字段
     */
    private Long matchPeriodId;

    /**
     * 赛事类型（默认1）1：普通赛事、2：电竞赛事
     */
    private Integer matchType;

    /**
     * 赛季id
     */
    private String seasonId;

    /**
     * 轮次类型：Group，Cup，Qualification
     */
    private String tournamentRoundType;

    /**
     * 当类型是group时存在值，原始示例：number="1"
     */
    private Integer tournamentRoundNumber;

    /**
     * 当类型是group时存在值，原始示例：group="A"
     */
    private String tournamentRoundGroup;

    /**
     * 如果存在值就传，原始示例：name="semifinal"
     */
    private String tournamentRoundName;

    /**
     * 如果存在值就传，原始示例：phase="playoffs"
     */
    private String tournamentRoundPhase;

    /**
     * 局数(赛制).数字,例如:5,7,代表最多打5局7局
     */
    private Integer roundType;

    /**
     * 移出 Out,移入 In
     */
    private String soldFlag;

    /**
     * 彩票号.(爬虫爬取)
     */
    private String lotteryNumber;

    /**
     * 比赛时长
     */
    private Integer matchLength;

    /**
     * 场地类型 0：室外泥地球场、1：室外硬地球场、2：室内硬地球场、3：室外草地球场
     */
    private Integer siteType;

    /**
     * 是否高热度赛事：0否1是
     */
    private Boolean hotMatchStatus;

    /**
     * 比赛是否结束. 0:未结束(不属于历史赛事); 1:结束.2:临时状态
     */
    private Integer matchOver;
    
    /**
     * 事件自动审核开启标识:1开启0关闭
     */
    private Integer autoAuditFlag;
    
    /**
     * 是否编辑比分标识：1已编辑0未编辑
     */
    private Integer scoreOpflag;

    /**
     * 账务时间.UTC时间,精确到毫秒.
     */
    private Long financialTime;

    /**
     * 备注.
     */
    private String remark;

    /**
     * 创建时间. 
     */
    private Long createTime;

    /**
     * 修改时间. 
     */
    private Long modifyTime;

    /**
     * 联赛别名称编码. 联赛名称编码. 用于多语言
     */
    private Long tournamentNameCode;




}
