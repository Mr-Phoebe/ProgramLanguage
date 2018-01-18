package com.mingrisoft;
public class CatchException {
    public static void main(String[] args) {
        try {											// 定义try语句块
            System.out.println("进入try语句块");
            @SuppressWarnings("unused")
            Class<?> clazz = Class.forName("");			// 得到一个空的Class对象
            System.out.println("离开try语句块");
        } catch (ClassNotFoundException e) {				// 定义catch语句块
            System.out.println("进入catch语句块");
            e.printStackTrace();
            System.out.println("离开catch语句块");
        } finally {										// 定义finally语句块
            System.out.println("进入finally语句块");
        }
    }
}

