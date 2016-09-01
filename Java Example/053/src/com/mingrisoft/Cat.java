package com.mingrisoft;

import java.awt.Color;

public class Cat {
    private String name; // 表示猫咪的名字
    private int age; // 表示猫咪的年龄
    private double weight; // 表示猫咪的重量
    private Color color; // 表示猫咪的颜色

    public Cat(String name, int age, double weight, Color color) {// 初始化猫咪的属性
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {// 重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append("名字：" + name + "\n");
        sb.append("年龄：" + age + "\n");
        sb.append("重量：" + weight + "\n");
        sb.append("颜色：" + color + "\n");
        return sb.toString();
    }
}
