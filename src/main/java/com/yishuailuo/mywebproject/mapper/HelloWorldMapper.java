package com.yishuailuo.mywebproject.mapper;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import org.apache.ibatis.annotations.*;

/**
 * Created by luoyishuai on 17/7/17.
 */
public interface HelloWorldMapper {

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "nameDesc", column = "desc"),
    })
    @Select("SELECT * FROM hello_world WHERE `name`=#{name}")
    HelloWorld getByName(@Param(value = "name") String name);

    @ResultMap("helloWorldResultMap")
    @Select("SELECT * FROM hello_world WHERE id=#{id}")
    HelloWorld get(HelloWorld helloWorld);

    @Insert("insert into hello_world(`name`, `desc`) values(#{name},#{nameDesc})")
    @Options(useGeneratedKeys = true)
    Integer add(HelloWorld helloWorld);

    @Delete("delete from hello_world where id = #{id}")
    Integer delete(HelloWorld helloWorld);

}
