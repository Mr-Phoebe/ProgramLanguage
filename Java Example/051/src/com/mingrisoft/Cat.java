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
    public boolean equals(Object obj) {// 利用属性来判断猫咪是否相同
        if (this == obj) {// 如果两个猫咪是同一个对象则相同
            return true;
        }
        if (obj == null) {// 如果两个猫咪有一个为null则不同
            return false;
        }
        if (getClass() != obj.getClass()) {// 如果两个猫咪的类型不同则不同
            return false;
        }
        Cat cat = (Cat) obj;
        return name.equals(cat.name) && (age == cat.age)
                && (weight == cat.weight) && (color.equals(cat.color));// 比较猫咪的属性
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
