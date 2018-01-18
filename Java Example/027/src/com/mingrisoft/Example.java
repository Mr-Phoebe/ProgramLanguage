package com.mingrisoft;
import java.math.BigDecimal;
public class Example {
    public static void main(String args[]) {
        BigDecimal sum = new BigDecimal(0.0); // 和
        BigDecimal factorial = new BigDecimal(1.0); // 阶乘项的计算结果
        int i = 1; // 循环增量
        while (i <= 20) {
            sum = sum.add(factorial); // 累加各项阶乘的和
            ++i; // i加1
            factorial = factorial.multiply(new BigDecimal(1.0 / i)); // 计算阶乘项
        }
        System.out.println("1+1／2!+1／3!···1／20!的计算结果等于：\n" + sum); // 输出计算结果
    }
}
