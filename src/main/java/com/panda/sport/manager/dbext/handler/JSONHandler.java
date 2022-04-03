package com.panda.sport.manager.dbext.handler;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.mapper
 * @Description :   处理mybatis json格式数据
 * @Date: 2019-10-02 17:23
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Slf4j
public class JSONHandler<T extends Object> extends BaseTypeHandler<T> {

    private static final ObjectMapper mapper = new ObjectMapper();

    private Class<T> clazz;

    static {
        mapper.configure(JsonParser.Feature.ALLOW_MISSING_VALUES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public JSONHandler(Class<T> clazz) {
        if (clazz == null) {
            throw new NullPointerException("Type argument cannot be null");
        }
        this.clazz = clazz;
    }

    /**
     * object转json string
     * @param object
     * @return
     */
    private String toJSON(T object) {
        try {
            String string = mapper.writeValueAsString(object);
            log.info(">>>> json handler string:{} <<<<",string);
            return string;
        } catch (Exception e) {
            log.error(">>>> covert object to json string failed, error message: <<<<",e.getMessage());
        }
        return null;
    }

    /**
     * json转object
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    private T toObject(String json, Class<T> clazz) throws IOException {
        if (json != null && json != "") {
            return mapper.readValue(json,clazz);
        }
        return null;
    }

    /*public static void main(String[] args) {
            //mapper.readValue("[{\"en\": \"英文啊啊啊111\", \"jc\": \"简称啊啊啊111\", \"zh\": \"中文繁体啊啊啊111\", \"zs\": \"中文简体啊啊啊111\"}, {\"en\": \"英文啊啊啊222\", \"jc\": \"简称啊啊啊222\", \"zh\": \"中文繁体啊啊啊222\", \"zs\": \"中文简体啊啊啊222\"}, {\"en\": \"英文啊啊啊333\", \"jc\": \"简称啊啊啊333\", \"zh\": \"中文繁体啊啊啊333\", \"zs\": \"中文简体啊啊啊333\"}]" , TeamName.class);
        List<TeamName> list = JsonUtils.jsonToObjectList("[{\"en\": \"英文啊啊啊111\", \"jc\": \"简称啊啊啊111\", \"zh\": \"中文繁体啊啊啊111\", \"zs\": \"中文简体啊啊啊111\"}, {\"en\": \"英文啊啊啊222\", \"jc\": \"简称啊啊啊222\", \"zh\": \"中文繁体啊啊啊222\", \"zs\": \"中文简体啊啊啊222\"}, {\"en\": \"英文啊啊啊333\", \"jc\": \"简称啊啊啊333\", \"zh\": \"中文繁体啊啊啊333\", \"zs\": \"中文简体啊啊啊333\"}]" , TeamName.class);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }*/

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        try {
            preparedStatement.setString(i,toJSON(t));
        } catch (Exception e) {
            log.error(">>>> preparedStatement set string failed, error message:{} <<<<",e.getMessage());
        }
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        try {
            //System.out.println(resultSet.getString(s));
            //System.out.println(clazz);
            return toObject(resultSet.getString(s), clazz);
        } catch (IOException e) {
            //log.error(">>>> convert json string to object failed, error message:{} <<<<",e.getMessage());
        }
        return null;
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        try {
            return toObject(resultSet.getString(i), clazz);
        } catch (IOException e) {
            log.error(">>>> convert json string to object failed, error message:{} <<<<",e.getMessage());
        }
        return null;
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        try {
            return toObject(callableStatement.getString(i), clazz);
        } catch (IOException e) {
            log.error(">>>> convert json string to object failed, error message:{} <<<<",e.getMessage());
        }
        return null;
    }

    @Override
    public T getResult(ResultSet rs, int columnIndex) throws SQLException {
        return super.getResult(rs, columnIndex);
    }

    @Override
    public T getResult(ResultSet rs, String columnName) throws SQLException {
        return super.getResult(rs, columnName);
    }

    @Override
    public T getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return super.getResult(cs, columnIndex);
    }

}
