package com.mingrisoft;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileNotFoundE {
    public static void main(String[] args) {
        FileInputStream fis = null;// 创建一个文件输入流对象
        try {
            File file = new File("d:\\kira.txt");// 创建一个文件对象
            fis = new FileInputStream(file);// 初始化文件输入流对象
        } catch (FileNotFoundException e) {// 捕获异常
            e.printStackTrace();
        } finally {
            try {
                fis.close();// 释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
