package com.mingrisoft;

public class Person {
    private String name; // 定义姓名
    private String gender; // 定义性别
    private int age; // 定义年龄

    public Person() {// 定义没有参数的构造方法
        System.out.println("使用无参构造方法创建对象");
    }

    public Person(String name, String gender, int age) {// 利用构造方法初始化域
        this.name = name;
        this.gender = gender;
        this.age = age;
        System.out.println("使用有参构造方法创建对象");
    }

    public String getName() { // 获得姓名
        return name;
    }

    public String getGender() { // 获得性别
        return gender;
    }

    public int getAge() { // 获得年龄
        return age;
    }

}
