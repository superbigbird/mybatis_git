package com.java.mybatis.test;

/**
 * description：
 * author：丁鹏
 * date：11:19
 */
public class SqlSessionImpl implements SqlSession{

    public  SqlSessionImpl(){

    }

    @Override
    public Object selectOne(String url) {
        //System.out.println("selectOne.....不带参数");
        System.out.println("selectOne....新的不带参数的");
        return null;
    }

    @Override
    public Object selectOne(String url, Object param) {
        System.out.println("selectOne......带参数");
        return null;
    }

    @Override
    public int update(String url) {
        System.out.println("update.....无参");
        return 0;
    }

    @Override
    public int update(String url, Object param) {
        System.out.println("update.....有参");
        return 0;
    }
}
