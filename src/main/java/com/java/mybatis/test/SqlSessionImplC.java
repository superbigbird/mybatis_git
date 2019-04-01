package com.java.mybatis.test;

/**
 * description：
 * author：丁鹏
 * date：11:37
 */
public class SqlSessionImplC implements SqlSession{
    @Override
    public Object selectOne(String url) {
        System.out.println("SqlSessionImplC.......");
        return null;
    }

    @Override
    public Object selectOne(String url, Object param) {
        return null;
    }

    @Override
    public int update(String url) {
        return 0;
    }

    @Override
    public int update(String url, Object param) {
        return 0;
    }
}
