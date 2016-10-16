package com.mingrisoft;

import java.io.*;

public class ComminuteUtil {
    // 实现文件分割方法
    public void fenGe(File commFile, File untieFile, int filesize) {
        FileInputStream fis = null;
        int size = 1024 * 1024; // 用来指定分割文件要以MB为单位
        try {
            if (!untieFile.isDirectory()) { // 如果要保存分割文件地址不是路径
                untieFile.mkdirs(); // 创建该路径
            }
            size = size * filesize;
            int length = (int) commFile.length(); // 获取文件大小
            int num = length / size; // 获取文件大小除以MB的得数
            int yu = length % size; // 获取文件大小与MB相除的余数
            String newfengeFile = commFile.getAbsolutePath(); // 获取保存文件的完成路径信息
            int fileNew = newfengeFile.lastIndexOf(".");
            String strNew = newfengeFile.substring(fileNew, newfengeFile.length()); // 截取字符串
            fis = new FileInputStream(commFile); // 创建FileInputStream类对象
            File[] fl = new File[num + 1]; // 创建文件数组
            int begin = 0;
            for (int i = 0; i < num; i++) { // 循环遍历数组
                fl[i] = new File(untieFile.getAbsolutePath() + "\\" + (i + 1) + strNew + ".tem"); // 指定分割后小文件的文件名
                if (!fl[i].isFile()) {
                    fl[i].createNewFile(); // 创建该文件
                }
                FileOutputStream fos = new FileOutputStream(fl[i]);
                byte[] bl = new byte[size];
                fis.read(bl); // 读取分割后的小文件
                fos.write(bl); // 写文件
                begin = begin + size * 1024 * 1024;
                fos.close(); // 关闭流
            }
            if (yu != 0) { // 文件大小与指定文件分割大小相除的余数不为0
                fl[num] = new File(untieFile.getAbsolutePath() + "\\" + (num + 1) + strNew + ".tem"); // 指定文件分割后数组中最后一个文件名
                if (!fl[num].isFile()) {
                    fl[num].createNewFile(); // 新建文件
                }
                FileOutputStream fyu = new FileOutputStream(fl[num]);
                byte[] byt = new byte[yu];
                fis.read(byt);
                fyu.write(byt);
                fyu.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
