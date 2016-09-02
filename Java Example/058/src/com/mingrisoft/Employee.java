package com.mingrisoft;

import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
    private static final long serialVersionUID = 5022956767440380940L;
    private String name; // 表示员工的姓名
    private int age; // 表示员工的年龄

    public Employee(String name, int age) {// 利用构造方法初始化各个域
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {// 重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：" + name + ", ");
        sb.append("年龄：" + age + "\n");
        return sb.toString();
    }

    @Override
    protected Employee clone() {// 使用父类的clone()方法实现深克隆
        Employee employee = null;
        try {
            employee = (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
