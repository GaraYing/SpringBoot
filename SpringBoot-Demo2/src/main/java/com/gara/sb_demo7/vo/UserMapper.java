package com.gara.sb_demo7.vo;

import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER (NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);


    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);


    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

}
