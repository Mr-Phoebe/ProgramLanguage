package com.mingrisoft;

public class Book {
    private static int counter = 0;// 定义一个计数器

    public Book(String title) {
        System.out.println("售出图书：" + title);// 输出书名
        counter++;// 计数器加一
    }

    public static int getCounter() {// 获得计数器的结果
        return counter;
    }
}
