package com.panda.sport.manager.vo;

import lombok.Data;

import java.util.List;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.query
 * @Description :  TODO
 * @Date: 2019-09-03 22:42
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Data
public class MatchRule {

    /**
     *
     * 数据源查询列表
     */
    private List<String> queryList;

    /**
     *
     * 标准联赛关联的第三方联赛个数
     */
    private Integer queryStandardCount;

    public MatchRule(List<String> queryList, Integer queryStandardCount) {
        this.queryList = queryList;
        this.queryStandardCount = queryStandardCount;
    }
}
