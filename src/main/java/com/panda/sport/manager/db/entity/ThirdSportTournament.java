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
 * 第三方体育联赛
 * </p>
 *
 * @author CodeGenerator
 * @since 2021-02-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("third_sport_tournament")
public class ThirdSportTournament extends Model<ThirdSportTournament> {

    private static final long serialVersionUID = 1L;

    /**
     * 表ID, 自增. id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运动种类id. 联赛所属体育种类id, 对应 sport.id
     */
    private Long sportId;

    /**
     * 运动区域id. 当前联赛所属体育区域 id.  对应 sport_region.id
     */
    private Long regionId;

    /**
     * 关联联赛id. 例如:  A B2个记录, 融合过程中生成了C记录且C记录对外体现, 则 A B 记录的该字段是C记录的id
     */
    private Long referenceId;

    /**
     * 第三方联赛原始id.第三方提供的联赛的id
     */
    private String thirdTournamentSourceId;

    /**
     * 三方数据源当前赛季ID
     */
    private String thirdSeasonSourceId;

    /**
     * 联赛 logo. 图标的url地址
     */
    private String logoUrl;

    /**
     * 联赛 logo缩略图的url地址. 
     */
    private String logoUrlThumb;

    /**
     * 联赛名称编码.  用于多语言
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
     * 备注. 
     */
    private String remark;

    /**
     * 英文名称(冗余字段,用于排序)
     */
    private String nameSpell;

    /**
     * 中文简体(冗余字段,用于查询,修改是需要维护)
     */
    private String name;

    /**
     * 创建时间. 
     */
    private Long createTime;

    /**
     * 修改时间. 
     */
    private Long modifyTime;


    public ThirdSportTournament() {this.modifyTime = System.currentTimeMillis();}

}
