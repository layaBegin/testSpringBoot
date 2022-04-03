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
 * 该系统从哪些平台接收数据
 * </p>
 *
 * @author CodeGenerator
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("data_source")
public class DataSource extends Model<DataSource> {

    private static final long serialVersionUID = 1L;

    /**
     * 数据表id, 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 该数据源的编码.比如 SportRadar的编码是 SR
     */
    private String code;

    /**
     * 数据源全称.比如 SportRadar
     */
    private String fullName;

    /**
     * 数据源简称.比如 SR , 球探
     */
    private String shortName;

    /**
     * 数据的优先级. 值越大, 重要程度越高.
     */
    private Integer priority;

    /**
     * 是否是商业来源的数据. 1: 商业来源;0:非商业
     */
    private Integer commerce;

    /**
     * 是否为标准数据源. 1: 是; 0: 否
     */
    private Integer standard;

    /**
     * 数据源类型.0:竞品数据源;1:比分网
     */
    private Integer type;

    private String remark;

    private Long createTime;

    private Long modifyTime;

    //@ApiModelProperty(value = "是否支持事件(0:否,1:是)")
    private Integer eventSupport;


    public DataSource() {this.modifyTime = this.modifyTime = System.currentTimeMillis();}

}
