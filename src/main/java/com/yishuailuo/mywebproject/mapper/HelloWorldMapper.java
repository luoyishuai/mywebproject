package com.yishuailuo.mywebproject.mapper;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    List<HelloWorld> getList();

    @Insert("insert into hello_world(`name`, `desc`) values(#{name},#{nameDesc})")
    @Options(useGeneratedKeys = true)
    Integer add(HelloWorld helloWorld);

    @Delete("delete from hello_world where id = #{id}")
    Integer delete(HelloWorld helloWorld);

}
