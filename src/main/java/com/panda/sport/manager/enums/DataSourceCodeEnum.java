package com.panda.sport.manager.enums;

//import org.apache.commons.lang3.StringUtils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : nonhung
 * @project Name : panda-data-manager
 * @package Name : com.panda.sport.manager.enums
 * @description : 商业数据源
 * @date: 2019-12-30 15:39
 * @modificationHistory Who When What -------- --------- --------------------------
 */
public enum DataSourceCodeEnum {
    SR("SR", "1"),
    BC("BC", "2"),
    BG("BG", "3"),
    TX("TX", "4"),
    PI("PI", "12"),
    AO("AO", "13"),
    One88("188", "20"),
    QT("QT", "21"),
    SBO("SBO", "22"),
    SBA("SBA", "23"),
    TS("TS", "24"),
    PA("PA", "99"),
    RB("RB", "10"),
    V2("V2", "99"),
    PD("PD", "88");

    public String code;
    public String id;

    DataSourceCodeEnum(String code, String id) {
        this.code = code;
        this.id = id;
    }

    /**
     * 通过code获取对应的id信息
     *
     * @param code
     * @return java.lang.String
     * @description 通过code获取对应的id信息
     **/
    public static String getIdByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        DataSourceCodeEnum[] values = DataSourceCodeEnum.values();
        for (DataSourceCodeEnum e : values) {
            if (e.code.equals(code)) {
                return e.id;
            }
        }
        return "";
    }

    public String getCode() {
        return this.code;
    }


    /**
     * @description: 获取商业数据源code
     * @param:
     * @return:
     * @author nonhung
     * @date: 2021/8/12 21:21
     */
    public static List<String> getCommersCode(){
        List<String> list = new ArrayList<String>();
        list.add(DataSourceCodeEnum.SR.getCode());
        list.add(DataSourceCodeEnum.BG.getCode());
        list.add(DataSourceCodeEnum.RB.getCode());
        list.add(DataSourceCodeEnum.TX.getCode());
        list.add(DataSourceCodeEnum.BC.getCode());
        list.add(DataSourceCodeEnum.PD.getCode());
        return list;
    }
}
