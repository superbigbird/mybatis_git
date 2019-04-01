package com.java.test;

/**
 * description：
 * author：丁鹏
 * date：10:18
 */
public class Chicken {
    //懒汉式：非线程安全的
    private static Chicken chicken = null;

    private Chicken(){
        System.out.println("一只小鸡被创建了....");
    }

    public static Chicken getIntance(){
        if(chicken==null){
            chicken = new Chicken();
        }
        return chicken;
    }

}
