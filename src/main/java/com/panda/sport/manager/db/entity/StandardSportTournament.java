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
 * 标准体育联赛表
 * </p>
 *
 * @author CodeGenerator
 * @since 2021-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("standard_sport_tournament")
public class StandardSportTournament extends Model<StandardSportTournament> {

    private static final long serialVersionUID = 1L;

    /**
     * 表ID, 自增. id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运动种类ID. 联赛所属体育种类id, 对应 sport.id
     */
    private Long sportId;

    /**
     * 第三方联赛id. 第三方联赛在 表 third_sport_tournament 中的id
     */
    private Long thirdTournamentId;

    /**
     * 所属标准区域 id.  对应  standard_sport_region.id
     */
    private Long regionId;

    /**
     * 数据来源类型. 0:系统设置;1:人工设置
     */
    private Integer regionType;

    /**
     * 联赛分级. 1: 一级联赛; 2:二级联赛; 3: 三级联赛; 以此类推; 0: 未分级
     */
    private Integer tournamentLevel;

    /**
     * 后台管理使用的联赛id. 
     */
    private String tournamentManagerId;

    /**
     * 第三方联赛原始id.第三方提供的联赛的id
     */
    private String thirdTournamentSourceId;

    /**
     * 联赛名称编码. 联赛名称编码. 用于多语言
     */
    private Long nameCode;

    /**
     * 赛季国际化Code
     */
    private Long seasonNameCode;

    /**
     * 数据来源编码.取值: SR BC分别代表:SportRadar、FeedConstruc.详情见data_source
     */
    private String dataSourceCode;

    /**
     * 赛季
     */
    private String season;

    /**
     * 当前赛季id
     */
    private String currentSeasonId;

    /**
     * 当为子联赛时取父联赛的id
     */
    private String fatherTournamentId;

    /**
     * 0：否 1：是 默认0，标识是否是子联赛
     */
    private Integer simpleFlage;

    /**
     * 当前轮类型：Group，Cup，Qualification
     */
    private String currentRoundType;

    /**
     * 当类型Group时存在值，原始示例：number="1"
     */
    private Integer currentRoundNumber;

    /**
     * 如果存在值就传，原始示例：name="semifinal"
     */
    private String currentRoundName;

    /**
     * 联赛官网
     */
    private String leagueUrl;

    /**
     * 是否有对应的三方联赛（默认1）0：没有、1：有
     */
    private Integer hasRelation;

    /**
     * 是否热门联赛 0:false  1:true
     */
    private Integer hotStatus;

    /**
     * 联赛 logo. 图标的url地址
     */
    private String logoUrl;

    /**
     * 联赛 logo. 缩略图的url地址
     */
    private String logoUrlThumb;

    /**
     * 关联数据源数量
     */
    private Integer relatedDataSourceCoderNum;

    /**
     * 关联数据源编码列表. 数据样例:SR,BC,188; SR,188; BC,188 (冗余字段,用于查询)
     */
    private String relatedDataSourceCoderList;

    /**
     * 简介. 
     */
    private String introduction;

    /**
     * 备注. 
     */
    private String remark;

    /**
     * 编辑多语言锁状态
     */
    private Integer isLock;

    /**
     * 创建时间. 
     */
    private Long createTime;

    /**
     * 联赛的使用状态
     */
    private Integer operatorStatus;

    /**
     * 修改时间. 
     */
    private Long modifyTime;

    /**
     * 英文名称(冗余字段,用于排序)
     */
    private String nameSpell;

    /**
     * 联赛归属(东京奥运会,其他)
     */
    private String tournamentType;
    /**
     * 中文简体(冗余字段,用于查询,修改是需要维护)
     */
    private String name;


    public StandardSportTournament() {this.modifyTime = System.currentTimeMillis();}

}
