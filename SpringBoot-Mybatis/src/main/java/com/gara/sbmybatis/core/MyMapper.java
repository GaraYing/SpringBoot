package com.gara.sbmybatis.core;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;


/**
 * MySqlMapper 自增序列的批量插入操作
 * 
 * 
 * @param <T>
 */
//@RegisterMapper
public interface MyMapper<T,PK> extends
        Mapper<T>/*,MySqlMapper<T>*/
        , ConditionMapper<T>
        , InsertListMapper<T>
        , IdListMapper<T, PK> {

}
