package com.mingrisoft;

import java.util.Scanner;

public class CelsiusConverter {
    public double getFahrenheit(double celsius) {
        double fahrenheit = 1.8 * celsius + 32;// 计算华氏温度
        return fahrenheit;// 返回华氏温度
    }

    public static void main(String[] args) {
        System.out.println("请输入要转换的温度（单位：摄氏度）");
        Scanner in = new Scanner(System.in);// 获得控制台输入
        double celsius = in.nextDouble();// 获得用户输入的摄氏温度
        CelsiusConverter converter = new CelsiusConverter(); // 创建类的对象
        double fahrenheit = converter.getFahrenheit(celsius); // 转换温度为华氏度
        System.out.println("转换完成的温度（单位：华氏度）：" + fahrenheit);// 输出转换结果
    }
}
