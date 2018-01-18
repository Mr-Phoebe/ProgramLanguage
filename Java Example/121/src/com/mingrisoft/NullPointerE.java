package com.mingrisoft;
public class NullPointerE {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        String string = null;// 将字符串设置为null
        System.out.println(string.toLowerCase());// 将字符串转换成小写
    }
}
