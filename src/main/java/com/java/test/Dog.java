package com.java.test;

/**
 * description：
 * author：丁鹏
 * date：09:56
 */
public class Dog {
    //实例成员：实例成员变量、实例方法
    //静态成员:静态成员变量、静态方法
    //饿汉式
    private static final Dog dog = new Dog();

    private Dog(){
        System.out.println("Dog....被创建了");
    }


    public static Dog getInstance(){
        return dog;
    }
}
