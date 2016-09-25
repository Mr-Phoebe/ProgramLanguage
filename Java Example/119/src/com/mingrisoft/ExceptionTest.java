package com.mingrisoft;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("-1.0 / 0 = " + (-1.0 / 0));// 演示负浮点数除0
        System.out.println("+1.0 / 0 = " + (+1.0 / 0));// 演示正浮点数除0
        try{
        	System.out.println("-1 / 0 = " + (-1 / 0));// 演示负整数除0
        }catch(Exception e){
        	System.out.println("抛出异常："+e.getMessage());
        }
        System.out.println("+1 / 0 = " + (+1 / 0));// 演示正整数除0
        System.out.println("输出结束。");
    }
}
