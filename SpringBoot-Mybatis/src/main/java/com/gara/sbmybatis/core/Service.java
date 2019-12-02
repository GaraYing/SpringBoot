package com.gara.sbmybatis.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T, PK> {
    void save(T model);//持久化

    void save(List<T> models);//批量持久化

    void deleteById(PK id);//通过主鍵刪除

    void deleteByIds(Collection<PK> ids);//批量刪除 eg：ids -> “1,2,3,4”

    void update(T model);//更新

    T findById(PK id);//通过ID查找

    T findBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束

    List<T> findByIds(Collection<PK> ids);//通过多个ID查找//eg：ids -> “1,2,3,4”

    List<T> findByCondition(Condition condition);//根据条件查找

    List<T> getList(Map<String, Object> params); //单表查询条件, 返回列表数据

    /**
     * 根据单个查询条件返回所有符合条件的数据
     *
     * @param columnName 列名
     * @param value      查询值
     */
    List<T> getList(String columnName, Object value);

    List<T> findAll();//获取所有

    T selectOne(T t);
}
