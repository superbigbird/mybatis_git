package com.java.dao.impl;

import com.java.pojo.Husband;
import com.java.pojo.User;
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
public class One2OneImpl {

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
     * 一对一
     */
    @Test
    public void getInfo(){
        Husband husband = session.selectOne("com.java.dao.impl.One2OneImpl.getInfo", "王二麻子");
        System.out.println(husband);
    }
    /**
     * 一对多
     */
    @Test
    public void getOrder(){
        User user = session.selectOne("com.java.dao.impl.One2OneImpl.getOrder");
        System.out.println(user);
    }

    /**
     * 一对多
     */
    @Test
    public void getOrderList(){
        List<User> userList = session.selectList("com.java.dao.impl.One2OneImpl.getOrderList");
        userList.forEach(temp-> System.out.println(temp));
    }



    @After
    public void destroy(){
        session.commit();
    }
}
