package com.mingrisoft;
import java.util.Scanner;
public class ParityCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 创建输入流扫描器
        System.out.println("请输入一个整数：");
        long number = scan.nextLong();// 获取用户输入的整数
        String check = (number % 2 == 0) ? "这个数字是:偶数" : "这个数字是：奇数";
        System.out.println(check);
    }
}
