package com.java.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pojo.Person;
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
 * date：11:32
 */
public class PersonDaoImpl {

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
     * 根据条件查询person表信息(一条)
     */
    @Test
    public void getPersonById() throws IOException {
        //开始执行与方法对应的sql语句
        //namespace值+id值
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("uName","王二麻子");
        paramMap.put("phone","15912345678");
        Map<String,Object> resultMap = session.selectOne("com.java.dao.impl.PersonDaoImpl.getPersonById",paramMap);
        resultMap.forEach((k,v)-> System.out.print(k+"="+v+"\t"));
    }

    /**
     * 通过Mybatis获取多条记录
     */
    @Test
    public void getPersons() throws IOException
    {
        List<Map<String,Object>> personList = session.selectList("com.java.dao.impl.PersonDaoImpl.getPersons");
        personList.forEach(temp-> System.out.println(temp));
    }

    @Test
    public void insertPerson(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("uName","小翠儿");
        paramMap.put("gender","0");
        paramMap.put("zhiYe","2");
        paramMap.put("address","长春");
        paramMap.put("phone","15912345622");
        int result = session.insert("com.java.dao.impl.PersonDaoImpl.insertPerson", paramMap);
        System.out.println(result);
    }

    /**
     * 根据id删除
     */
    @Test
    public void deletePesonById(){
        int flag = session.delete("com.java.dao.impl.PersonDaoImpl.deletePesonById", 1L);
        System.out.println("flag="+flag);
    }

    //----------------------------------研究mybatis中返回值类型与参数类型---------------------------------------------------

    /**
     * 查询所有数据，使用List<POJO>来封装结果，并且使用pageHelper分页
     */
    @Test
    public void findAllByPOJO(){
        //开始分页
        PageHelper.startPage(2,2);
        List<Person> personList = session.selectList("com.java.dao.impl.PersonDaoImpl.findAllByPOJO");
        //使用PageInfo来包装查询的结果
        PageInfo<Person> pageInfo = new PageInfo<Person>(personList);
        pageInfo.getList().forEach(temp-> System.out.println(temp));
    }

    @Test
    public void insertPersonByPoJO(){
        Person person = new Person(null,"凤姐","0","1","长沙","15912345333");
        int result = session.insert("com.java.dao.impl.PersonDaoImpl.insertPerson", person);
        System.out.println(result);
    }

    @Test
    public void insertManyUsersByCallable(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("num",100);
        session.insert("com.java.dao.impl.PersonDaoImpl.insertManyUsersByCallable",paramMap);
    }

    @Test
    public void getInfoByUName(){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("p1","张三");
        session.selectOne("com.java.dao.impl.PersonDaoImpl.getInfoByUName",paramMap);
        System.out.println(paramMap);
    }

    @After
    public void destroy(){
        session.commit();
    }

}
