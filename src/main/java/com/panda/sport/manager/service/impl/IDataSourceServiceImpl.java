package com.panda.sport.manager.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.panda.sport.manager.db.entity.DataSource;
import com.panda.sport.manager.db.mapper.DataSourceMapper;
import com.panda.sport.manager.enums.DataSourceCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 该系统从哪些平台接收数据
 *
 * @author dorich
 * @date 2019-08-01 17:29:45
 */
@Slf4j
@Service("iDataSourceService")
public class IDataSourceServiceImpl /*implements IDataSourceService*/ {


//    @Autowired
//    RedisTemplate redisTemplate;

    @Autowired
    DataSourceMapper dataSourceMapper;

    private List<DataSource> dataSources;

    public List<DataSource> initial() {
        QueryWrapper<DataSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(DataSource::getStandard);
        queryWrapper.lambda().orderByDesc(DataSource::getCommerce);
        queryWrapper.lambda().orderByDesc(DataSource::getPriority);
        dataSources = dataSourceMapper.selectList(queryWrapper);
        dataSources.forEach(dataSource -> {
            if (dataSource.getCode().toString().equals(DataSourceCodeEnum.QT.code)) {
                dataSource.setFullName("QiuTan");
                dataSource.setShortName("QT");
            }
            if (dataSource.getCode().toString().equals(DataSourceCodeEnum.SBA.code)) {
                dataSource.setFullName("ShaBa");
                dataSource.setShortName("SBA");
            }
        });


        return dataSources;
    }

    /**
     * 查询所有的数据源信息，并且按照重要性排序，越重要的数据 排位越靠前
     *
     * @return java.util.List<DataSource>
     * @description 查询所有的数据源信息，并且按照重要性排序，越重要的数据 排位越靠前
     * @author dorich
     * @date 2019/8/18
     **//*
    @Override
    public Map queryAllDataSource() {
        Set<String> keys = redisTemplate.keys(RedisKeyRecord.getDataSourceKey() + ":*");
        List<DataSource> dataSources = redisTemplate.opsForValue().multiGet(keys);
        if (CollectionUtils.isEmpty(dataSources)) {
            dataSources = queryDataSourcesOrder();
            Map<String, DataSource> map = new HashMap<>();
            for (DataSource dataSource : dataSources) {
                map.put(RedisKeyRecord.getDataSourceKey(dataSource.getId()), dataSource);
            }
            redisTemplate.opsForValue().multiSet(map);
        }
        Map<String, DataSource> dataSource = new HashMap<>();
        for (DataSource d : dataSources) {
            dataSource.put(d.getCode(), d);
        }
        return dataSource;
    }

    private List<DataSource> queryDataSourcesOrder() {
        if (null != dataSources) {
            return dataSources;
        }
        dataSources = initial();
        return dataSources;
    }

    @Override
    public List<DataSource> queryByWeight() {
        return queryDataSourcesOrder();
    }*/
}
