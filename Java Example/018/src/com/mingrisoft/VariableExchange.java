package com.mingrisoft;
import java.util.Scanner;
public class VariableExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 创建扫描器
        System.out.println("请输入变量A的值");
        long A = scan.nextLong();// 接收第一个变量值
        System.out.println("请输入变量B的值");
        long B = scan.nextLong();// 接收第二个变量值
        System.out.println("A=" + A + "\tB=" + B);
        System.out.println("执行变量互换...");
        A = A ^ B;// 执行变量互换
        B = B ^ A;
        A = A ^ B;
        System.out.println("A=" + A + "\tB=" + B);
    }
}
