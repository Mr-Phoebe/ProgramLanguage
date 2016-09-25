package com.mingrisoft;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class MathUtil {
    public static void main(String[] args) {
        BigDecimal number1 = new BigDecimal(1.2345); // 声明高精度浮点数number1
        BigDecimal number2 = new BigDecimal(5.4321); // 声明高精度浮点数number2
        BigDecimal addition = number1.add(number2); // 计算number1加number2
        BigDecimal subtraction = number1.subtract(number2); // 计算number1减number2
        BigDecimal multiplication = number1.multiply(number2); // 计算number1乘number2
        // 以四舍五入的方式获得高精度除法运算的结果
        BigDecimal division = number1.divide(number2, RoundingMode.HALF_UP);
        System.out.println("高精度浮点数number1：" + number1);
        System.out.println("高精度浮点数number2：" + number2);
        System.out.println("高精度浮点数加法：" + addition);
        System.out.println("高精度浮点数减法：" + subtraction);
        System.out.println("高精度浮点数乘法：" + multiplication);
        System.out.println("高精度浮点数除法：" + division);
    }
}