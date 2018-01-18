package com.mingrisoft;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleWriter {

    public static void main(String[] args) {
        System.out.println("请输入要保存的字符串：");// 提示用户输入字符串
        Scanner scanner = new Scanner(System.in);// 获得控制台输入流
        String text = scanner.nextLine();// 获得用户输入
        FileWriter writer = null;
        try {
            writer = new FileWriter("d://test.txt");// 获得文件写入流
            writer.write(text);// 写入字符串
            writer.flush();// 刷新缓存
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
