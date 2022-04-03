package com.panda.sport.manager.dbext.entity.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.entity.json
 * @Description :  球队多语言信息，参考language_type表定义字段，默认为全部语言类型
 * @Date: 2019-10-04 10:40
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Data
public class TeamName implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 英文名称
     */
    private String en;

    /**
     * 中文简体名称
     */
    private String zs;

    /**
     * 中文繁体名称
     */
    private String zh;

    /**
     * 简称
     */
    private String jc;
}
