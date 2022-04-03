package com.panda.sport.manager.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * SR BC提供的比赛数据信息表
 * </p>
 *
 * @author CodeGenerator
 * @since 2021-02-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("third_match_info")
public class ThirdMatchInfo extends Model<ThirdMatchInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * id. id
     */
   // @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运动种类id. 对应 sport.id
     */
    private Long sportId;

    /**
     * 运动区域 id. 对应  sport_region.id
     */
    private Long regionId;

    /**
     * 联赛 id.  对应 sport_tournament.id
     */
    private Long tournamentId;

    /**
     * 父赛事id
     */
    private Long parentId;

    /**
     * 比赛暂停. 0:未暂停;1:暂停.
     */
    private Integer whetherStop;

    /**
     * 比赛是否被激活. 1: 激活; 0: 未激活.  激活的比赛可以进行下注. 
     */
    private Integer active;

    /**
     * 比赛是否可见. 1:可见; 0:不可见
     */
    private Integer visible;

    /**
     * 赛事包含的所有球队多语言信息,json串,冗余字段,用于赛程页面查询
     */
    private String teamName;

    /**
     * 数据源是否支持滚球. 取值为 1  或  0.  1=支持; 0=不支持
     */
    private Integer liveOddSupport;

    /**
     * 赛前盘下注状态. 赛前盘: 1 可下注; 0不可下注; 用于数据源控制下注状态
     */
    private Integer preMatchBetStatus;

    /**
     * 赛事双方的对阵信息.格式:主场队名称 VS 客场队名称
     */
    private String homeAwayInfo;

    /**
     * 赛事可下注状态. 0: betstart; 1: betstop
     */
    private Integer betStatus;

    /**
     * 滚球下注状态. 滚球中使用: 1 可下注; 0不可下注; 用于数据源控制下注状态
     */
    private Integer liveOddsBetStatus;

    /**
     * 距离开赛时间.  单位: 秒
     */
    private Integer secondsMatchStart;

    /**
     * seconds_match_start被修改时刻的时间戳.单位:毫秒
     */
    private Long secondsMatchModifyTime;

    /**
     * 主客队是否相反.与标准球队相比,主客队是否相反.0:否; 1:是
     */
    private Integer homeAwayOpposite;

    /**
     * 标准赛事的id. 关联后的赛事ID.  例如:  A B 2个记录, 融合结束后在 标准赛事表中生成一个新纪录. 则当前记录的该字段使用新纪录的 concern_event,id  作为该字段值
     */
    private Long referenceId;

    /**
     * 比赛开始时间. UTC时间
     */
    private Long beginTime;

    /**
     * 是否为中立场. 取值为 0  和1  .   1:是中立场, 0:非中立场. 操盘人员可手动处理
     */
    private Integer neutralGround;

    /**
     * 当前比赛是否被预定.是否预定,0: 否; 1: 是
     */
    private Integer booked;

    /**
     * 数据来源编码.取值: SR BC分别代表:SportRadar、FeedConstruc.详情见data_source
     */
    private String dataSourceCode;

    /**
     * 完赛状态，0 否，1是，2中间态用于临时处理锁定数据用
     */
    private Integer matchOver;

    /**
     * 局数(赛制).数字,例如:5,7,代表最多打5局7局
     */
    private Integer roundType;

    /**
     * 彩票号.(爬虫爬取)
     */
    private String lotteryNumber;

    /**
     * 是否有动画或视频（0:否，1:是）
     */
    private Integer lmtMode;

    /**
     * 小编操作动画状态： OPEN:开   CLOSE:关闭 （废弃）
     */
    private String sellStatus;

    /**
     * 场地类型 0：室外泥地球场、1：室外硬地球场、2：室内硬地球场、3：室外草地球场
     */
    private Integer siteType;

    /**
     * 赛事状态. 0:not_started;1:live;2:suspended;3:ended;4:closed;5:cancelled;6:abandoned;7:delayed;8:unknown;9:post
     */
    private Integer matchStatus;

    /**
     * 比赛类型
     */
    private Integer matchType;

    /**
     * 比赛时长
     */
    private Integer matchLength;

    /**
     * 比赛场地的国际化编码. 
     */
    private Long matchPositionNameCode;

    /**
     * 比赛场地名称,仅限中文.用于查看mysql 时 使用. 
     */
    private String matchPositionName;

    /**
     * 第三方赛事原始id.比如: SportRadar 发送数据时,这场比赛的ID. 
     */
    private String thirdMatchSourceId;

    /**
     * 比赛阶段id.  
     */
    private String matchPeriod;

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
     * 赛季id
     */
    private String seasonId;

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
     * 主队阵型(TS)
     */
    private String homeFormation;

    /**
     * 客队阵型(TS)
     */
    private String awayFormation;


    public ThirdMatchInfo() {this.modifyTime = System.currentTimeMillis();}

}
