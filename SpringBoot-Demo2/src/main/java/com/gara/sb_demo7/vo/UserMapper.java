package com.gara.sb_demo7.vo;

import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     *
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:28
     * @param [name]
     * @return
     * @else
     *
     */
    @Select("SELECT * FROM USER WHERE name = #{name}")
    User findByName(@Param("name") String name);

    /**
     *
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:28
     * @param [name, age]
     * @return
     * @else
     *
     */
    @Insert("INSERT INTO USER (NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     *
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:29
     * @param [map]
     * @return
     * @else
     *
     */
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     *
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:29
     * @param [user]
     * @return
     * @else
     *
     */
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    /**
     *
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:29
     * @param [user]
     * @return
     * @else
     *
     */
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    /**
     *
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:29
     * @param [id]
     * @return
     * @else
     *
     */
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    /**
     *
     * 多表关联查询
     * @author Gary
     * @date 2018/3/28 14:29
     * @param []
     * @return
     * @else
     *
     */
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();


}
