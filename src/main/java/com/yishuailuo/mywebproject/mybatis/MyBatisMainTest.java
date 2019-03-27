package com.yishuailuo.mywebproject.mybatis;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import com.yishuailuo.mywebproject.mapper.HelloWorldMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisMainTest {
    
    public static void main(String[] args) throws IOException {
        /**
         * https://blog.csdn.net/u010349169/column/info/mybatis-principle
         *
         */
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // List<HelloWorld> helloWorld = sqlSession.selectList("com.yishuailuo.mywebproject.mapper.HelloWorldMapper.getList");
        // 只有 commit 之后或者 close 之后让 tcm commit，才会放到二级缓存中
        // https://github.com/mybatis/mybatis-3/issues/105
        // MyBatis 二级缓存源码 http://eovie.cn/notes/MyBatis%E4%BA%8C%E7%BA%A7%E7%BC%93%E5%AD%98
        
        HelloWorldMapper helloWorldMapper = sqlSession.getMapper(HelloWorldMapper.class);
        List<HelloWorld> helloWorld = helloWorldMapper.getList();
    
        sqlSession.commit();
        System.out.println(helloWorld.get(0).getNameDesc());
        List<HelloWorld> helloWorld1 = sqlSession.selectList("com.yishuailuo.mywebproject.mapper.HelloWorldMapper.getList");
        System.out.println(helloWorld1.get(0).getNameDesc());
        sqlSession.close();
    }
}
