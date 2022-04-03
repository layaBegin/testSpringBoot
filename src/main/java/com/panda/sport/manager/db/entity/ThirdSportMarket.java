package com.panda.sport.manager.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 该表存放 第三方提供的盘口
 * </p>
 *
 * @author CodeGenerator
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("third_sport_market")
public class ThirdSportMarket extends Model<ThirdSportMarket> {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库id, 自增
     */
    private Long id;

    /**
     * 所属联赛ID   
     */
    private Long tournamentId;

    /**
     * 比赛ID:third_match_info.id
     */
    private Long matchId;

    /**
     * 第三方玩法id   standard_sport_market_category.id
     */
    private Long marketCategoryId;

    /**
     * 第三提供的id。SR: 报文中有id字段。
     */
    private String thirdMarketSourceId;

    /**
     * 如果当前盘口与标准盘口中的B记录玩法相同且盘口显示内容相同, 则该记录的当前字段值为B.ID
     */
    private Long referenceId;

    /**
     * 盘口类型. 属于赛前盘或者滚球盘. 1: 赛前盘; 0: 滚球盘. 
     */
    private Integer marketType;

    /**
     * 取值:  SR BC分别代表: SportRadar、FeedConstruc. 详情见data_source
     */
    private String dataSourceCode;

    /**
     * 盘口状态0-5. 0:active, 1:suspended, 2:deactivated, 3:settled, 4:cancelled, 5:handedOver
     */
    private Integer status;

    /**
     * 盘口阶段id. 对应 对应 system_item_dict.value
     */
    private String scopeId;

    /**
     * 盘口名称编码. 用于多语言
     */
    private Long nameCode;

    /**
     * 玩法的中文名称. 仅用用于数据库操作人员使用. 
     */
    private String oddsTypeName;

    /**
     * 接收到第三方数据后, 可以通过该字段快速定位到当前的盘口. 通过玩法和具体内容确认盘口的唯一性.  SR提供的盘口数据id 生成算法: Type_Typeid_Subtypeid_Specialoddsvalue
     */
    private String thirdOddsType;

    /**
     * 该盘口具体显示的值. 例如: 大小球中, 大小界限是:  3.5
     */
    private String oddsValue;

    /**
     * 排序类型
     */
    private String orderType;

    /**
     * 盘口名称. 
     */
    private String oddsName;

    /**
     * 盘口级别，数字越小优先级越高
     */
    private Integer oddsMetric;

    /**
     * 附加字段1
     */
    private String addition1;

    /**
     * 附加字段2
     */
    private String addition2;

    /**
     * 附加字段3
     */
    private String addition3;

    /**
     * 附加字段4
     */
    private String addition4;

    /**
     * 附加字段5
     */
    private String addition5;

    private String remark;

    private Long createTime;

    private Long modifyTime;

    private String extraInfo;

    /**
     * 三方盘口源状态
     */
    private Integer thirdMarketSourceStatus;

    /**
     *  并列-胜出数
     */
    private Integer numberOfWinners;

    /**
     * TX坑位
     */
    private Integer offerLineId;


    public ThirdSportMarket() {this.modifyTime = System.currentTimeMillis();}

}
