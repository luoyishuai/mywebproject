package com.yishuailuo.mywebproject.mapper;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by luoyishuai on 17/7/17.
 */
public interface HelloWorldMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "nameDesc", column = "desc")
    })
    @Select("SELECT * FROM hello_world WHERE name=#{name}")
    HelloWorld get(@Param(value = "name") String name);
}
