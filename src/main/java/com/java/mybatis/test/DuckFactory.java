package com.java.mybatis.test;

/**
 * description：
 * author：丁鹏
 * date：11:47
 */
public class DuckFactory {
    private static final CommonDuck duck1 = new Duck();
    private static final CommonDuck duck2 = new DuckA();

    public  CommonDuck getInstance(){
        return duck2;
    }

}
