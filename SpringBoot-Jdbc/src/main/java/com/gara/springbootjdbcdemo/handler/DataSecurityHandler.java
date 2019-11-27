package com.gara.springbootjdbcdemo.handler;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @createTime: 2019-07-27 11:05
 * @Version: 1.0.4
 **/
public class DataSecurityHandler extends BaseTypeHandler {


    public static final LoadingCache<String, String> ENCRYPT_CACHE = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
        public String load(String parameterValue) {
            return AES.encrypt(parameterValue);
        }
    });

    public static final LoadingCache<String, String> DECRYPT_CACHE = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
        public String load(String parameterValue) {
            return AES.decrypt(parameterValue);
        }
    });

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        String parameterValue = (String) parameter;
        String resultValue = ENCRYPT_CACHE.getUnchecked(StringUtils.trimToEmpty(parameterValue));
        preparedStatement.setString(i, resultValue);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return DECRYPT_CACHE.getUnchecked(StringUtils.trimToEmpty(resultSet.getString(s)));
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return DECRYPT_CACHE.getUnchecked(StringUtils.trimToEmpty(resultSet.getString(i)));
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return DECRYPT_CACHE.getUnchecked(StringUtils.trimToEmpty(callableStatement.getString(i)));
    }
}
