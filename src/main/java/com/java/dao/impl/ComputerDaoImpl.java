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
 * date：11:41
 */
public class ComputerDaoImpl {

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
     * 动态查询
     */
    @Test
    public void dynamicSelect1(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("brand","神舟");
        /*paramMap.put("price",6000);*/
        List<Map<String,Object>> resultMap = session.selectList("com.java.dao.impl.ComputerDaoImpl.dynamicSelect1", paramMap);
        resultMap.forEach(temp-> System.out.println(temp));
    }

    /**
     * 动态查询
     */
    @Test
    public void dynamicSelect2(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("brand","神舟");
        /*paramMap.put("price",6000);*/
        List<Map<String,Object>> resultMap = session.selectList("com.java.dao.impl.ComputerDaoImpl.dynamicSelect2", paramMap);
        resultMap.forEach(temp-> System.out.println(temp));
    }

    /**
     * 动态查询
     */
    @Test
    public void dynamicUpdate1(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("brand","神舟本");
        paramMap.put("price",3999F);
        paramMap.put("id",3L);
        /*paramMap.put("price",6000);*/
        int flag = session.update("com.java.dao.impl.ComputerDaoImpl.dynamicUpdate1", paramMap);
        System.out.println("flag="+flag);
    }

    /**
     * 动态查询
     */
    @Test
    public void dynamicUpdate2(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("brand","神舟");
        paramMap.put("price",6999F);
        paramMap.put("id",3L);
        /*paramMap.put("price",6000);*/
        int flag = session.update("com.java.dao.impl.ComputerDaoImpl.dynamicUpdate2", paramMap);
        System.out.println("flag="+flag);
    }

    /**
     * 动态查询-研究choose、when、otherwise
     */
    @Test
    public void selectByIfElse(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("status","1");
        List<Map<String,Object>> resultMap = session.selectList("com.java.dao.impl.ComputerDaoImpl.selectByIfElse", paramMap);
        resultMap.forEach(temp-> System.out.println(temp));
    }

    @After
    public void destroy(){
        session.commit();
    }
}
