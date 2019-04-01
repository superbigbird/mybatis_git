package com.java.mybatis.test;

/**
 * description：
 * author：丁鹏
 * date：11:15
 */
public interface SqlSession {

    /**
     * 不带参数的查询
     * @param url
     * @return
     */
    Object selectOne(String url);

    /**
     * 查询带参数的
     * @param url
     * @param param
     * @return
     */
    Object selectOne(String url,Object param);

    /**
     * 不带参数的修改
     * @param url
     * @return
     */
    int update(String url);

    /**
     * 带参数的修改
     * @param url
     * @param param
     * @return
     */
    int update(String url,Object param);

}
