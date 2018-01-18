package com.mingrisoft;

public class Book {
    private String title; // 定义书名
    private String author; // 定义作者
    private double price; // 定义价格

    public Book(String title, String author, double price) {// 利用构造方法初始化域
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() { // 获得书名
        return title;
    }

    public String getAuthor() { // 获得作者
        return author;
    }

    public double getPrice() { // 获得价格
        return price;
    }
}
