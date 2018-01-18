package com.mingrisoft;

import java.util.Date;
import java.util.Locale;

public class Example {
    public static void main(String[] args) {
        Date today = new Date();
        // 格式化后的字符串为月份的英文缩写
        String a = String.format(Locale.US, "%tb", today);
        System.out.println("格式化后的字符串为月份的英文缩写: " + a);
        // 格式化后的字符串为月份的英文全写
        String b = String.format(Locale.US, "%tB", today);
        System.out.println("格式化后的字符串为月份的英文缩写: " + b);
        // 格式化后的字符串为星期（如：星期一）
        String c = String.format("%ta", today);
        System.out.println("月格式化后的字符串为星期: " + c);
        // 格式化后的字符串为星期（如：星期一）
        String d = String.format("%tA", today);
        System.out.println("格式化后的字符串为星期: " + d);
        // 格式化后的字符串为4位的年份值
        String e = String.format("%tY", today);
        System.out.println("格式化后的字符串为4位的年份值: " + e);
        // 格式化后的字符串为2位的年份值
        String f = String.format("%ty", today);
        System.out.println("格式化后的字符串为2位的年份值: " + f);
        // 格式化后的字符串为2位的月份值
        String g = String.format("%tm", today);
        System.out.println("格式化后的字符串为2位的月份值: " + g);
        // 格式化后的字符串为2位的日期值
        String h = String.format("%td", today);
        System.out.println("格式化后的字符串为2位的日期值: " + h);
        // 格式化后的字符串为1位的日期值
        String i = String.format("%te", today);
        System.out.println("格式化后的字符串为1位的日期值: " + i);
    }
}
