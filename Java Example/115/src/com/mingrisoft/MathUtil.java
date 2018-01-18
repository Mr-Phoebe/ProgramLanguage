package com.mingrisoft;

import java.math.BigInteger;
public class MathUtil {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("12345"); // 声明高精度整数number1
        BigInteger number2 = new BigInteger("54321"); // 声明高精度整数number2
        BigInteger addition = number1.add(number2); // 计算number1加number2
        BigInteger subtraction = number1.subtract(number2); // 计算number1减number2
        BigInteger multiplication = number1.multiply(number2); // 计算number1乘number2
        BigInteger division = number1.divide(number2); // 计算number1除number2
        System.out.println("高精度整数number1：" + number1);
        System.out.println("高精度整数number2：" + number2);
        System.out.println("高精度整数加法：" + addition);
        System.out.println("高精度整数减法：" + subtraction);
        System.out.println("高精度整数乘法：" + multiplication);
        System.out.println("高精度整数除法：" + division);
    }
}