package com.mingrisoft;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 3049633059823371192L;
    private String name; // 表示员工的姓名
    private int age; // 表示员工的年龄
    private Address address;// 表示员工的地址

    public Employee(String name, int age, Address address) {// 利用构造方法初始化各个域
        this.name = name;
        this.age = age;
        this.address = address;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {// 重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：" + name + ", ");
        sb.append("年龄：" + age + "\n");
        sb.append("地址：" + address);
        return sb.toString();
    }

}
