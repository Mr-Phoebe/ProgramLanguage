package com.mingrisoft;

import java.io.*;
import java.util.*;

public class CopyUtil {
    // 获取磁盘所有文件方法
    public List<String> getList(String path) {
        LinkedList<File> list = new LinkedList<File>(); // 定义保存目录的集合对象
        ArrayList<String> listPath = new ArrayList<String>(); // 定义文件地址的集合对象
        File dir = new File(path); // 根据文件地址创建File对象
        File file[] = dir.listFiles(); // 获取文件夹下的文件数组
        for (int i = 0; i < file.length; i++) { // 循环遍历数组
            if (file[i].isDirectory()) // 判断文件是否是一个目录
                list.add(file[i]); // 向集合中添加元素
            else {
                listPath.add(file[i].getAbsolutePath()); // 将文件路径添加到集合中
            }
        }
        File tmp;
        while (!list.isEmpty()) { // 如果保存保存文件路径的集合不为空
            tmp = list.removeFirst(); // 移除并返回集合中第一项
            if (tmp.isDirectory()) {
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) { // 循环遍历数组
                    if (file[i].isDirectory()) // 如果文件表示一个目录
                        list.add(file[i]);
                    else { // 如果为一个文件对象
                        listPath.add(file[i].getAbsolutePath());
                    }
                }
            }
        }
        return listPath;
    }

    /**
     * 该方法以复制文件的路径、复制后文件的路径作为参数
     * 
     * @param args
     */
    public void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) { // 循环读取文件
                    bytesum += byteread; // 获取文件大小
                    fs.write(buffer, 0, byteread); // 将文件中写数据
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
