package com.mingrisoft;

public class Test {
    public static void main(String[] args) {
        Book book = new Book("《Java从入门到精通（第2版）》", "明日科技", 59.8);// 创建对象
        System.out.println("书名：" + book.getTitle()); // 输出书名
        System.out.println("作者：" + book.getAuthor()); // 输出作者
        System.out.println("价格：" + book.getPrice() + "元"); // 输出价格
    }

}
