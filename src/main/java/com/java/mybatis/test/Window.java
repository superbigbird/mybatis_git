package com.java.mybatis.test;

import org.apache.ibatis.jdbc.SQL;

/**
 * description：
 * author：丁鹏
 * date：11:23
 */
public class Window {
    public static void main(String[] args) {
        //SqlSession--->SqlSessoinFactory---->SqlSessionImpl
        //SqlSession session = SqlSessionImpl.getInstance();
        //session.selectOne("");
        SqlSession session = SqlSessionFactory.getInstanceByFactory();
        session.selectOne("aaaa");

        //SqlSession session = SqlSessionImplB.getInstance();

        String str = "abc";
        //System.out.println(str.aaa());

        Duck duck1 = new Duck();
        duck1.test1();
        DuckA duckA = new DuckA();

        CommonDuck duck2 = new Duck();
        CommonDuck duck3 = new DuckA();


        /*CommonDuck commonDuck1 = DuckFactory.getInstance();
        CommonDuck commonDuck2 = DuckFactory.getInstance();
        CommonDuck commonDuck3 = DuckFactory.getInstance();
        CommonDuck commonDuck4= DuckFactory.getInstance();
        CommonDuck commonDuck5 = DuckFactory.getInstance();*/
        //Duck--->DuckFactory
        DuckFactory df = new DuckFactory();
        CommonDuck duck = df.getInstance();
        duck.test1();
    }
}
