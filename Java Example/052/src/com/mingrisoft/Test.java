package com.mingrisoft;

import java.awt.Color;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Java", 12, 21, Color.BLACK); // 创建猫咪1号
        Cat cat2 = new Cat("C++", 12, 21, Color.WHITE); // 创建猫咪2号
        Cat cat3 = new Cat("Java", 12, 21, Color.BLACK); // 创建猫咪3号
        System.out.println("猫咪1号的哈希码：" + cat1.hashCode());// 输出猫咪1号的哈希码
        System.out.println("猫咪2号的哈希码：" + cat2.hashCode());// 输出猫咪2号的哈希码
        System.out.println("猫咪3号的哈希码：" + cat3.hashCode());// 输出猫咪3号的哈希码
        System.out.println("猫咪1号是否与猫咪2号相同：" + cat1.equals(cat2));// 比较是否相同
        System.out.println("猫咪1号是否与猫咪3号相同：" + cat1.equals(cat3));// 比较是否相同
    }

}
