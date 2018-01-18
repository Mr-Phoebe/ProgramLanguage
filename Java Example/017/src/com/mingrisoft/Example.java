package com.mingrisoft;
import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);// 创建扫描器
        System.out.println("请输入一个整数");
        long number = scan.nextLong();// 获取输入的整数
        System.out.println("你输入的数字是："+number);
        System.out.println("该数字乘以2的运算结果为："+(number<<1));
        System.out.println("该数字乘以4的运算结果为："+(number<<2));
        System.out.println("该数字乘以8的运算结果为："+(number<<3));
        System.out.println("该数字乘以16的运算结果为："+(number<<4));
    }
}
