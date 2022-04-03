package com.panda.sport.manager.enums;

/**
 * @author :  gasol
 * @Project Name :  association
 * @Package Name :  com.panda.sport.data.association.service
 * @Description :  数据源商业来源枚举类
 * @Date: 2019-09-02 17:02
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
public enum DataSourceCommerceEnum {

    /**
     * 商业来源
     */
    COMMERCE(1, "商业数据源"),

    /**
     * 非商业
     */
    NON_COMMERCE(0, "非商业数据源");

    private Integer code;

    private String val;

    DataSourceCommerceEnum(Integer code, String val) {
        this.code = code;
        this.val = val;
    }

    public Integer getCode() {
        return code;
    }

    public String getVal() {
        return val;
    }
}
