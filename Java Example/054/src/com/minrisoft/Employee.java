package com.minrisoft;

public class Employee {
    private String name;// 表示员工的名字
    private int age; // 表示员工的年龄

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {// 重写toString()方法
        return "姓名：" + name + ", 年龄：" + age;
    }

}
