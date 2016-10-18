package com.mingrisoft;

import java.io.*;
import java.util.*;

public class SortUtil {
    // 获取磁盘所有文件方法
    public List<String> getList(String path) {
        LinkedList<File> list = new LinkedList<File>();
        ArrayList<String> listPath = new ArrayList<String>();
        File dir = new File(path);
        File file[] = dir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory())
                list.add(file[i]);
            else {
                listPath.add(file[i].getAbsolutePath());
            }
        }
        File tmp;
        while (!list.isEmpty()) {
            tmp = list.removeFirst(); // 移除并返回集合中第一项
            if (tmp.isDirectory()) {
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory())
                        list.add(file[i]);
                    else {
                        listPath.add(file[i].getAbsolutePath());
                    }

                }
            } else {

            }
        }
        return listPath;
    }

    // 创建文件夹方法

    public void createFolder(String strPath) {
        try {
            File myFilePath = new File(strPath); // 根据文件地址创建File对象
            if (!myFilePath.exists()) { // 如果指定的File对象不存在
                myFilePath.mkdir(); // 创建目录
            }
        } catch (Exception e) {
            System.out.println("新建文件夹操作出错");
            e.printStackTrace();
        }
    }

    // 复制文件方法
    public void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
