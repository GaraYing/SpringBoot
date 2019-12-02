package com.gara.sbmybatis.core;

import com.gara.sbmybatis.exception.ServiceException;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T, PK> implements Service<T, PK> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    protected Mapper<T> mapper;

    @Autowired
    protected MyMapper<T, PK> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    @SuppressWarnings(value = "unchecked")
    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T model) {
        mapper.insertSelective(model);
    }
    @Override
    public void save(List<T> models) {
        mapper.insertList(models);
    }
    @Override
    public void deleteById(PK id) {
        mapper.deleteByPrimaryKey(id);
    }
    @Override
    public void deleteByIds(Collection<PK> ids) {
        //mapper.deleteByIds(ids);
        mapper.deleteByIdList(new ArrayList<>(ids));
    }
    @Override
    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }
    @Override
    public T findById(PK id) {
        return mapper.selectByPrimaryKey(id);
    }
    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    @Override
    public List<T> findByIds(Collection<PK> ids) {
        //return mapper.selectByIds(ids);
        return mapper.selectByIdList(new ArrayList<>(ids));
    }
    @Override
    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }
    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }
    @Override
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public List<T> getList(Map<String, Object> params) {
        Condition condition = null;
        try {
            T model = modelClass.newInstance();
            condition = new Condition(model.getClass());
            condition.createCriteria().andEqualTo(params);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return mapper.selectByCondition(condition);
    }

    @Override
    public List<T> getList(String columnName, Object value) {
        HashMap<String, Object> param = new HashMap<>();
        param.put(columnName, value);
        return this.getList(param);
    }
}
