package com.mingrisoft;

import java.util.Date;

public class ClassTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("第1种方法：Object.getClass()");
        Class c1 = new Date().getClass();// 使用getClass()方式获得Class对象
        System.out.println(c1.getName());// 输出对象名称
        System.out.println("第2种方法：.class语法");
        Class c2 = boolean.class;// 使用.class语法获得Class对象
        System.out.println(c2.getName());// 输出对象名称
        System.out.println("第3种方法：Class.forName()");
        Class c3 = Class.forName("java.lang.String");// 使用Class.forName()获得Class对象
        System.out.println(c3.getName());// 输出对象名称
        System.out.println("第4种方法：包装类的TYPE域");
        Class c4 = Double.TYPE;// 使用包装类获得Class对象
        System.out.println(c4.getName());// 输出对象名称
    }
}
