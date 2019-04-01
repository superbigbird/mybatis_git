package com.java.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：10:14
 */
public class BookDaoImpl {
    private SqlSession session = null;

    @Before
    public void init() throws IOException {
        //SqlSession(核心类)--->SqlSessionFactory---->SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //将mybatis.xml主配置文件以流的形式进行读取
        InputStream ins = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = ssfb.build(ins);
        //通过SqlSessionFactory得到SqlSession对象
        session = sqlSessionFactory.openSession();
    }

    /**
     * 模糊查询
     */
    @Test
    public void mohuSelect(){
        //使用Map集合来封装参数信息
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("keyword",1);
        List<Map<String,Object>> bookList = session.selectList("com.java.dao.impl.BookDaoImpl.mohuSelect",paramMap);
        bookList.forEach(temp-> System.out.println(temp));
    }

    @Test
    public void test(){
        String str = "Java";
        System.out.println(str);
    }

    @After
    public void destroy(){
        session.commit();
    }
}
