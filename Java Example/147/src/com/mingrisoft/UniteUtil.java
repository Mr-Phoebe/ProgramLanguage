package com.mingrisoft;

import java.io.*;
import java.util.*;

public class UniteUtil {
    /**
     * @param file
     *            :要进行合并的文件数组对象
     * @param cunDir
     *            ：合并后文件的保存路径
     * @param hz
     *            ：合并后文件的格式
     */
    public void heBing(File[] file, File cunDir, String hz) {
        try {
            File heBingFile = new File(cunDir.getAbsoluteFile() + "\\UNTIE" + hz); // 指定分割后文件的文件名
            if (!heBingFile.isFile()) {
                heBingFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(heBingFile); // 创建FileOutputStream对象
            for (int i = 0; i < file.length; i++) { // 循环遍历要进行合并的文件数组对象
                FileInputStream fis = new FileInputStream(file[i]);
                int len = (int) file[i].length(); // 获取文件长度
                byte[] bRead = new byte[len];
                fis.read(bRead); // 读取文件
                fos.write(bRead); // 写入文件
                fis.close(); // 将流关闭
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

}
