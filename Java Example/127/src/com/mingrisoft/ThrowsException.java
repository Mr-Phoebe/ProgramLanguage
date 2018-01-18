package com.mingrisoft;
public class ThrowsException {
    public static void throwsException() throws ClassNotFoundException {// 抛出异常
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public static void main(String[] args) {
        try {// 捕获异常
            ThrowsException.throwsException();// 调用抛出异常的方法
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}