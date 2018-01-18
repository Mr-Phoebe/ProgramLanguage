package com.mingrisoft;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        String[] titles = { "《Java从入门到精通（第2版）》", "《Java编程词典》", "《视频学Java》" };// 创建书名数组
        for (int i = 0; i < 5; i++) {
            new Book(titles[new Random().nextInt(3)]);// 利用书名数组创建Book对象
        }
        System.out.println("总计销售了" + Book.getCounter() + "本图书！");// 输出创建对象的个数
    }

}
