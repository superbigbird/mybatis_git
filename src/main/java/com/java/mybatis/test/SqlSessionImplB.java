package com.java.mybatis.test;

/**
 * description：
 * author：丁鹏
 * date：11:32
 */
public class SqlSessionImplB  implements  SqlSession{
    @Override
    public Object selectOne(String url) {
        System.out.println("selectOne....新查询无参方法");
        //需要读取xml文件
        //解析xml--->找到对应的sql语句(update、delete、insert、select)
        //1、连上数据库
        //2、创建statement
        //反射
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
