package com.mingrisoft;

public class Test {
    public static void main(String[] args) {
        System.out.println("创建皇帝1对象：");
        Emperor emperor1 = Emperor.getInstance();// 创建皇帝对象
        emperor1.getName();// 输出皇帝的名字
        System.out.println("创建皇帝2对象：");
        Emperor emperor2 = Emperor.getInstance();// 创建皇帝对象
        emperor2.getName();// 输出皇帝的名字
        System.out.println("创建皇帝3对象：");
        Emperor emperor3 = Emperor.getInstance();// 创建皇帝对象
        emperor3.getName();// 输出皇帝的名字
    }

}
