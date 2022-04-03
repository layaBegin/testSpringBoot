package com.panda.sport.manager.dbext.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.panda.sport.manager.constant.Constant;
import com.panda.sport.manager.db.entity.DataSource;
import com.panda.sport.manager.db.mapper.DataSourceMapper;
import com.panda.sport.manager.dbext.service.DataSourceExtService;

import com.panda.sport.manager.enums.DataSourceCommerceEnum;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 该系统从哪些平台接收数据
 *
 * @author dorich
 * @date 2019-08-01 17:29:45
 */
@Slf4j
@Service("dataSourceExtService")
public class DataSourceExtServiceImpl implements DataSourceExtService {

    @Autowired
    DataSourceMapper dataSourceMapper;

    private List<DataSource> dataSources;

    private Map<String, Integer> dataSourceWeight = new HashMap<>();

    private Map<String, DataSource> dataSourceOriginalMap = new HashMap<>();


    private AtomicLong updateTime = new AtomicLong(0L);

    private final Long timeDistance = 24 * 3600 * 1000L;

    @PostConstruct
    public void loadData() {
        initial();
    }

    /**
     * 初始化语言信息
     */
    public synchronized List<DataSource> initial() {
        QueryWrapper<DataSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(DataSource::getStandard);
        queryWrapper.lambda().orderByDesc(DataSource::getCommerce);
        queryWrapper.lambda().orderByDesc(DataSource::getPriority);
        dataSources = dataSourceMapper.selectList(queryWrapper);
        for (int i = 0; i < dataSources.size(); i++) {
            dataSourceWeight.put(dataSources.get(i).getCode(), i);
            dataSourceOriginalMap.put(dataSources.get(i).getCode(), dataSources.get(i));
        }
        updateTime.set(System.currentTimeMillis());
        return dataSources;
    }

    /**
     * 查询所有的数据源信息，并且按照重要性排序，越重要的数据 排位越靠前
     *
     * @return java.util.List<DataSource>
     * @description 查询所有的数据源信息，并且按照重要性排序，越重要的数据 排位越靠前
     * @author dorich
     * @date 2019/8/18
     **/
    @Override
    public Map<String, DataSource> queryAllDataSource() {
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        return dataSourceOriginalMap;
    }


    @Override
    public Map<String, DataSource> queryMerchantDataSource() {
        Map<String, DataSource> dataSourceMap = queryAllDataSource();
        Set<String> keys = dataSourceMap.keySet();
        List<String> ids = new ArrayList<>();
        for (String key : keys) {
            if (0 == dataSourceMap.get(key).getCommerce()) {
                ids.add(key);
            }
        }
        for (String id : ids) {
            dataSourceMap.remove(id);
        }
        return dataSourceMap;
    }

    private List<DataSource> queryDataSourcesOrder() {
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        return dataSources;
    }

    @Override
    public List<DataSource> queryByWeight() {
        return queryDataSourcesOrder();
    }

    /**
     * 获取数据源列表中 优先级最高的 数据源
     *
     * @param dataSourceCodelist
     * @return java.lang.String
     * @description 获取数据源列表中 优先级最高的 数据源
     * @author Alair
     * @date 2019/8/23 10:48
     **/
    @Override
    public String getMaxPriorityDataSourceCode(List<String> dataSourceCodelist) {
        List<DataSource> dataSourceList = queryDataSourcesOrder();
        //  校验
        if (CollectionUtils.isEmpty(dataSourceCodelist) || CollectionUtils.isEmpty(dataSourceList)) {
            //log.debug(PandaLog.op("getMaxPriorityDataSourceCode").msg("数据库数据源查询为空 或 参数数据源列表为空，不予处理").toString());
            return "";
        }
        String maxCode = "";
        int size = dataSourceList.size();
        for (int i = 0; i < size; i++) {
            DataSource dataSource = dataSourceList.get(i);
            //  计算出 优先级最高的 数据源
            if (dataSourceCodelist.contains(dataSource.getCode())) {
                maxCode = dataSource.getCode();
                break;
            }
        }
        return maxCode;
    }

    /**
     * 从列表中获取数据源优先级最高的对象
     * 需要符合前提条件：
     * 1.list不为空
     * 2.list对象中 包含dataSourceCode字段
     * 3.list中数据源不重复
     *
     * @param list
     * @param cls
     * @return T
     * @description 从列表中获取数据源优先级最高的对象
     * @author Alair
     * @date 2019/8/23 11:56
     **/
    @Override
    public <T> T getMaxPriorityObject(List<T> list, Class<T> cls) {
        if (CollectionUtils.isEmpty(list)) {
            //log.debug(PandaLog.op("getMaxProiorityObject").msg("列表为空，无法计算数据源优先级最高对象").toString());
            return null;
        }
        List<T> returnList = getMaxPriorityObjectList(list, cls);
        if (CollectionUtils.isNotEmpty(returnList)) {
            return returnList.get(0);
        }
        return null;
    }

    /**
     * 从列表中获取数据源优先级最高的对象列表
     * 需要符合前提条件：
     * 1.list不为空
     * 2.list对象中 包含dataSourceCode字段
     *
     * @param list
     * @param cls
     * @return java.util.List<T>
     * @description 从列表中获取数据源优先级最高的对象列表
     * @author Alair
     * @date 2019/8/23 11:58
     **/
    @Override
    public <T> List<T> getMaxPriorityObjectList(List<T> list, Class<T> cls) {
        if (CollectionUtils.isEmpty(list)) {
            //log.debug(PandaLog.op("getMaxProiorityObjectList").msg("列表为空，无法计算数据源优先级最高对象").toString());
            return null;
        }
        try {
            Method method = cls.getMethod("getDataSourceCode");
            List<String> dataSourceCodeList = new LinkedList<>();
            for (T t : list) {
                if (null == t) {
                    continue;
                }
                dataSourceCodeList.add((String) method.invoke(t));
            }
            String maxDataSourceCode = getMaxPriorityDataSourceCode(dataSourceCodeList);
            List<T> returnList = new LinkedList<>();
            for (T t : list) {
                if (null == t) {
                    continue;
                }
                if (maxDataSourceCode.equals((String) method.invoke(t))) {
                    returnList.add(t);
                }
            }
            return returnList;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有可用数据源的code编码
     *
     * @return java.util.List<T> 存放 code 编码的list
     * @description
     * @author dorich
     * @date 2019/9/17
     **/
    @Override
    public List<String> getAllDataSourceCodeList() {
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        return dataSources.stream().map(DataSource::getCode).collect(Collectors.toList());
    }

    /**
     * 按照数据源优先级 对列表排序
     *
     * @param list
     * @param cls
     * @return void
     * @description 按照数据源优先级 对列表排序
     * @author Alair
     * @date 2019/9/3 19:06
     **/
    @Override
    public <T> void sortByPriority(List<T> list, Class<T> cls) {
        if (CollectionUtils.isEmpty(list)) {
            //log.debug(PandaLog.op("sortByPriority").msg("列表为空，不需要按优先级排序").toString());
            return;
        }


        try {
            Method method = cls.getMethod("getDataSourceCode");
            if (method == null) {
                return;
            }
            Collections.sort(list, new Comparator<T>() {
                @Override
                public int compare(T t1, T t2) {
                    try {
                        if (method.invoke(t1) == null || method.invoke(t2) == null) {
                            return 0;
                        }
                        if (dataSourceWeight.get((String) method.invoke(t1)) == null || dataSourceWeight.get((String) method.invoke(t2)) == null) {
                            return 0;
                        }
                        return dataSourceWeight.get((String) method.invoke(t1)).compareTo(dataSourceWeight.get((String) method.invoke(t2)));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            });
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean comparator(String firstDataSource, String secondDataSource) {
        //  TODO 这里如果数据库优先级进行调整，可能会有问题
        /*
        if (dataSourceMap == null || dataSourceMap.size() == 0) {
            List<DataSource> dataSourceList = queryByWeight();
            for (int i = 0; i < dataSourceList.size(); i++) {
                dataSourceMap.put(dataSourceList.get(i).getCode(), i);
            }
        }
        **/
        return dataSourceWeight.get(firstDataSource) <= dataSourceWeight.get(secondDataSource);
    }

    /**
     * 是否为标准数据源（第三方数据落表时，默认生成标准数据）
     *
     * @param dataSourceCode
     * @return boolean
     * @description 是否为标准数据源（第三方数据落表时，默认生成标准数据）
     * @author Alair
     * @date 2019/8/24 20:52
     **/
    @Override
    public boolean isStandardDataSourceCode(String dataSourceCode) {
        /*
        QueryWrapper<DataSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(DataSource::getStandard, Constant.DATA_SOURCE_STANDARD);
        List<DataSource> dataSourceList = dataSourceMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(dataSourceList)) {
            return dataSourceList.stream().map(DataSource::getCode).collect(Collectors.toList()).contains(dataSourceCode);
        }
        **/
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        DataSource ds = dataSourceOriginalMap.get(dataSourceCode);
        if (Constant.DATA_SOURCE_STANDARD.equals(ds.getStandard())) {
            return true;
        }
        return false;
    }

    /**
     * 是否为商业数据源（可以生成标准数据）
     *
     * @param dataSourceCode
     * @return boolean
     * @description 是否为商业数据源（可以生成标准数据）
     * @author Alair
     * @date 2019/9/3 19:04
     **/
    @Override
    public boolean isCommerceDataSourceCode(String dataSourceCode) {
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        List<DataSource> dataSourceList = getCommerceDataSourceList();
        if (CollectionUtils.isNotEmpty(dataSourceList)) {
            return dataSourceList.stream().map(DataSource::getCode).collect(Collectors.toList()).contains(dataSourceCode);
        }
        return false;
    }

    /**
     * 当前数据编码所代表的数据源是否为比分网编码
     *
     * @param dataSourceCode
     * @return boolean
     * @description
     * @author dorich
     * @date 2019/11/4 13:56
     **/
    @Override
    public boolean isScorer(String dataSourceCode) {
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        // 找出所有非商业数据源
        List<DataSource> dataSourceList = dataSources.stream().filter(e -> !(e.getCommerce().equals(DataSourceCommerceEnum.COMMERCE.getCode()))).collect(Collectors.toList());
        // 查找比分网的数据源列表
        List<String> scoreList = dataSourceList.stream().filter(e -> (e.getType().intValue() != 0)).map(DataSource::getCode).collect(Collectors.toList());

        return scoreList.contains(dataSourceCode);
    }

    /**
     * 获取商业数据源
     *
     * @param
     * @return java.util.List<DataSource>
     * @description 获取商业数据源
     * @author Alair
     * @date 2019/9/3 23:04
     **/
    @Override
    public List<DataSource> getCommerceDataSourceList() {
        if (System.currentTimeMillis() - updateTime.get() > timeDistance) {
            initial();
        }
        return dataSources.stream().filter(e -> e.getCommerce().equals(DataSourceCommerceEnum.COMMERCE.getCode())).collect(Collectors.toList());
    }

    /**
     * 获取商业数据源的编码
     *
     * @param
     * @return java.util.List<com.panda.sport.manager.db.entity.DataSource>
     * @description
     * @author dorich
     * @date 2019/12/21 15:59
     **/
    @Override
    public String getStandardDataSourceCode() {
        return this.getMaxPriorityDataSourceCode(this.getAllDataSourceCodeList());
    }

    /**
     * 获取商业数据源的编码
     *
     * @param
     * @return java.util.List<com.panda.sport.manager.db.entity.DataSource>
     * @description
     * @author dorich
     * @date 2019/12/21 15:59
     **/
    @Override
    public List<String> getCommerceDataSourceCode() {
        return this.dataSources.stream().filter(e -> e.getCommerce().equals(1)).map(DataSource::getCode).collect(Collectors.toList());
    }

    /**
     * 获取冗余字段  related_data_source_coder_list 的 值
     * 采用公共方法，进行统一处理，保证数据库中该字段值保持稳定
     * 冗余字段没必要保持数据源优先级顺序，页面展示的列表是由前端处理的，与该字段无关，该字段仅用于查询功能
     *
     * @param dataSourceList
     * @return java.lang.String
     * @description 获取冗余字段  related_data_source_coder_list 的 值
     * @author Alair
     * @date 2019/9/4 13:17
     **/
    @Override
    public String getRelatedDataSourceCode(Collection<String> dataSourceList) {
        return "," + dataSourceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(","));
    }

    @Override
    public String getMatchResultRelatedDataSourceCode(Collection<String> dataSourceList) {
        return dataSourceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(","));
    }

    @Override
    public DataSource getItemByCode(String dataSourceCode) {
        if(org.springframework.util.CollectionUtils.isEmpty(dataSources)){
            initial();
        }
        List<DataSource> resList = dataSources.stream().filter(obj -> obj.getCode().equals(dataSourceCode)).collect(Collectors.toList());
        if(org.springframework.util.CollectionUtils.isEmpty(resList)){
            return null;
        }
        return resList.get(0);
    }

}
