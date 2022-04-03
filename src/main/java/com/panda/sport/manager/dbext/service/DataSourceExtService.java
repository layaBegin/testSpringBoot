package com.panda.sport.manager.dbext.service;

import com.panda.sport.manager.db.entity.DataSource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 该系统从哪些平台接收数据
 *
 * @author dorich
 * @date 2019-08-01 17:29:45
 */
public interface DataSourceExtService {
    /**
     * 查询所有的数据源信息，并且按照重要性排序，越重要的数据 排位越靠前
     * @description
     * @param
     * @author  dorich
     * @date   2019/8/19
     * @return java.util.Map
     **/
    Map<String, DataSource> queryAllDataSource();

    /**
     * 查询商业数据源，返回商业数据源信息
     * @description
     * @param
     * @author  dorich
     * @date   2019/8/29
     * @return java.util.Map
     **/
    Map<String, DataSource> queryMerchantDataSource();

    /**
     * 查询所有数据源信息，按照优先级排序，优先级越高的越靠前
     * @description 查询所有数据源信息，按照优先级排序，优先级越高的越靠前
     * @param
     * @return java.util.List<DataSource>
     * @author Alair
     * @date 2019/8/23 10:45
     **/
    List<DataSource> queryByWeight();

    /**
     * 获取数据源列表中 优先级最高的 数据源
     * @description 获取数据源列表中 优先级最高的 数据源
     * @param dataSourceCodelist
     * @return java.lang.String
     * @author Alair
     * @date 2019/8/23 10:48
     **/
    String getMaxPriorityDataSourceCode(List<String> dataSourceCodelist);

    /**
     * 从列表中获取数据源优先级最高的对象
     *      需要符合前提条件：
     *          1.list不为空
     *          2.list对象中 包含dataSourceCode字段
     *          3.list中数据源不重复
     * @description 从列表中获取数据源优先级最高的对象
     * @param list
     * @param cls
     * @return T
     * @author Alair
     * @date 2019/8/23 11:56
     **/
    <T> T getMaxPriorityObject(List<T> list, Class<T> cls);

    /**
     * 从列表中获取数据源优先级最高的对象列表
     *      需要符合前提条件：
     *                 1.list不为空
     *                 2.list对象中 包含dataSourceCode字段
     * @description 从列表中获取数据源优先级最高的对象列表
     * @param list
     * @param cls
     * @return java.util.List<T>
     * @author Alair
     * @date 2019/8/23 11:58
     **/
    <T> List<T> getMaxPriorityObjectList(List<T> list, Class<T> cls);

    /**
     * 获取所有可用数据源的code编码
     * @description
     * @param
     * @author  dorich
     * @date   2019/9/17
     * @return java.util.List<T> 存放 code 编码的list
     **/
    List<String> getAllDataSourceCodeList();

    /**
     * 按照数据源优先级 对列表排序
     * @description 按照数据源优先级 对列表排序
     * @param list
     * @param cls
     * @return void
     * @author Alair
     * @date 2019/9/3 19:06
     **/
    <T> void sortByPriority(List<T> list, Class<T> cls);

    /**
     * 比较两个数据源优先级大小
     *      return firstDataSource >= secondDataSource;
     * @description 比较两个数据源优先级大小
     * @param firstDataSource
     * @param secondDataSource
     * @return boolean
     * @author Alair
     * @date 2019/9/4 21:01
     **/
    boolean comparator(String firstDataSource, String secondDataSource);

    /**
     * 是否为标准数据源（第三方数据落表时，默认生成标准数据）
     * @description 是否为标准数据源（第三方数据落表时，默认生成标准数据）
     * @param dataSourceCode
     * @return boolean
     * @author Alair
     * @date 2019/8/24 20:52
     **/
    boolean isStandardDataSourceCode(String dataSourceCode);

    /**
     * 是否为商业数据源（可以生成标准数据）
     * @description 是否为商业数据源（可以生成标准数据）
     * @param dataSourceCode
     * @return boolean
     * @author Alair
     * @date 2019/9/3 19:04
     **/
    boolean isCommerceDataSourceCode(String dataSourceCode);

    /**
     * 当前数据编码所代表的数据源是否为比分网编码
     * @description TODO
     * @param dataSourceCode
     * @return boolean
     * @author dorich
     * @date 2019/11/4 13:56
     **/
    boolean isScorer(String dataSourceCode);

    /**
     * 获取商业数据源
     * @description 获取商业数据源
     * @param
     * @return java.util.List<DataSource>
     * @author Alair
     * @date 2019/9/3 23:04
     **/
    List<DataSource> getCommerceDataSourceList();

    /**
     * 获取标准数据源的编码
     * @description TODO
     * @param
     * @return java.util.List<com.panda.sport.manager.db.entity.DataSource>
     * @author dorich
     * @date 2019/12/21 15:59
     **/
    String getStandardDataSourceCode();
    /**
     * 获取商业数据源的编码
     * @description TODO
     * @param
     * @return java.util.List<com.panda.sport.manager.db.entity.DataSource>
     * @author dorich
     * @date 2019/12/21 15:59
     **/
    List<String> getCommerceDataSourceCode();
    /**
     * 获取冗余字段  related_data_source_coder_list 的 值
     *      采用公共方法，进行统一处理，保证数据库中该字段值保持稳定
     *      冗余字段没必要保持数据源优先级顺序，页面展示的列表是由前端处理的，与该字段无关，该字段仅用于查询功能
     * @description 获取冗余字段  related_data_source_coder_list 的 值
     * @param dataSourceList
     * @return java.lang.String
     * @author Alair
     * @date 2019/9/4 13:17
     **/
    String getRelatedDataSourceCode(Collection<String> dataSourceList);

    String getMatchResultRelatedDataSourceCode(Collection<String> dataSourceList);

    /**
     * 根据数据源编码获取数据源信息
     * @param dataSourceCode   数据来源
     * */
    DataSource getItemByCode(String dataSourceCode);
}

