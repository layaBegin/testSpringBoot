package com.panda.sport.manager.service;


import com.panda.sport.manager.db.entity.DataSource;

import java.util.List;
import java.util.Map;

/**
 * 该系统从哪些平台接收数据
 *
 * @author dorich
 * @date 2019-08-01 17:29:45
 */
public interface IDataSourceService {
    /**
     * 查询所有的数据源信息，并且按照重要性排序，越重要的数据 排位越靠前
     * @description
     * @param
     * @author  dorich
     * @date   2019/8/19
     * @return java.util.Map
     **/
    Map queryAllDataSource();

    /**
     * 查询所有数据源信息，按照优先级排序，优先级越高的越靠前
     * @description 查询所有数据源信息，按照优先级排序，优先级越高的越靠前
     * @param
     * @return java.util.List<DataSource>
     * @author Alair
     * @date 2019/8/23 10:45
     **/
    List<DataSource> queryByWeight();
}

