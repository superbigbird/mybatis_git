package com.java.test;

import org.junit.Test;

import java.util.*;

/**
 * description：
 * author：丁鹏
 * date：09:55
 */
public class Test1 {


    @Test
    public void test1(){
        Dog dog1 = Dog.getInstance();
        Dog dog2 = Dog.getInstance();
        System.out.println(dog1);
        System.out.println(dog2);
    }

    @Test
    public void test2(){
        Chicken chicken1 = Chicken.getIntance();
        Chicken chicken2 = Chicken.getIntance();
        Chicken chicken3 = Chicken.getIntance();
        System.out.println(chicken1);
        System.out.println(chicken2);
        System.out.println(chicken3);
    }

    public void test3(){
        //List：ArrayList、LinkedList
        //(1)
        List<String> aList =new LinkedList<String>();
        aList.add("china");
        aList.add("america");
        //(2)
        ArrayList<String> bList =new ArrayList<String>();
        bList.add("aaa");
        bList.add("ccc");
    }

}
