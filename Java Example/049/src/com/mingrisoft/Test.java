package com.mingrisoft;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();// 创建对象
        Person person2 = new Person("明日科技", "男", 11);// 创建对象
        System.out.println("员工1的信息");
        System.out.println("员工姓名：" + person1.getName()); // 输出姓名
        System.out.println("员工性别：" + person1.getGender()); // 输出性别
        System.out.println("员工年龄：" + person1.getAge()); // 输出年龄
        System.out.println("员工2的信息");
        System.out.println("员工姓名：" + person2.getName()); // 输出姓名
        System.out.println("员工性别：" + person2.getGender()); // 输出性别
        System.out.println("员工年龄：" + person2.getAge()); // 输出年龄
    }

}
