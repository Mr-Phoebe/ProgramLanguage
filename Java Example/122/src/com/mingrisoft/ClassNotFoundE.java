package com.mingrisoft;
public class ClassNotFoundE {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载MySQL驱动程序
        } catch (ClassNotFoundException e) {// 捕获异常
            e.printStackTrace();// 打印堆栈信息
        }
    }
}
