package com.mingrisoft;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();// 创建列表保存对象
        Employee employee = new Employee("李XX", 25);// 创建Employee类的对象
        long currentTime = System.currentTimeMillis();// 获得当前系统时间
        for (int i = 0; i < 100000; i++) {
            employees.add(employee.clone());// 使用克隆方式获得对象
        }
        System.out.println("克隆花费时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");
        currentTime = System.currentTimeMillis();// 获得当前时间

        for (int i = 0; i < 100000; i++) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();// 创建字节数组输出流
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(baos);// 创建对象输出流
                out.writeObject(employee);// 将对象写入到输出流中
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();// 释放资源
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 获得字节数组输出流内容
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(bais);// 创建对象输入流
                employees.add((Employee) in.readObject());// 读取对象
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();// 释放资源
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("序列化花费时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");
    }
}
