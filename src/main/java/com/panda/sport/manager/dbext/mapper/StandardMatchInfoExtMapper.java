package com.panda.sport.manager.dbext.mapper;
/**
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.dbext.mapper
 * @Description :  TODO
 * @author :  Alair
 * @Date: 2019-10-05 17:25
 * @ModificationHistory Who    When    What --------  ---------  --------------------------
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panda.sport.manager.db.entity.DataSource;
import com.panda.sport.manager.db.entity.StandardMatchInfo;
import com.panda.sport.manager.dbext.entity.MatchQueryExt;
import com.panda.sport.manager.dbext.entity.StandardMatchInfoExt;
import com.panda.sport.manager.dbext.entity.ThirdMatchInfoExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: admin
 * @date: 2019/10/5 17:25
 */
public interface StandardMatchInfoExtMapper extends BaseMapper<StandardMatchInfoExt> {

    /**
     * 分页查询前端赛事需展示的数据
     *
     * @param query
     * @param commerceList       商业数据源的 list
     * @param offset
     * @param size
     * @param queryThirdFlag     是否查询第三方数据表
     * @param queryList          需要查询那些数据源的赛事
     * @param queryStandardCount 用于判断标准赛事下边有几个第三方赛事 用于判断 字段 related_data_source_coder_num
     * @param isTody             是否仅查询今天的赛事
     * @return 返回前端展示的 标准赛事的结果集
     */
    List<StandardMatchInfoExt> getMatchVoForPandaPage(@Param("query") MatchQueryExt query,
                                                      @Param("commerceList") List<String> commerceList,
                                                      @Param("offset") Integer offset,
                                                      @Param("size") Integer size,
                                                      @Param("queryThirdFlag") boolean queryThirdFlag,
                                                      @Param("queryList") List<String> queryList,
                                                      @Param("queryStandardCount") Integer queryStandardCount,
                                                      @Param("isTody") boolean isTody);



    /**
     * 查询前端赛事需展示的数据总数
     *
     * @param query
     * @param commerceList
     * @param offset
     * @param size
     * @param queryThirdFlag
     * @param queryList
     * @param queryStandardCount
     * @return 返回查询的标准赛事的总条数
     */
    Integer getMatchVoForPandaPageCount(@Param("query") MatchQueryExt query,
                                        @Param("commerceList") List<String> commerceList,
                                        @Param("offset") Integer offset,
                                        @Param("size") Integer size, @Param("queryThirdFlag") boolean queryThirdFlag,
                                        @Param("queryList") List<String> queryList,
                                        @Param("queryStandardCount") Integer queryStandardCount,
                                        @Param("isTody") boolean isTody);



}
