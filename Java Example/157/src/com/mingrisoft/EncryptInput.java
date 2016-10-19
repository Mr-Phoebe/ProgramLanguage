package com.mingrisoft;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class EncryptInput {

    @SuppressWarnings("unused")
    public static void fileLock(String file) {
        FileOutputStream fous = null; // 创建FileOutputStream对象
        FileLock lock = null; // 创建FileLock对象
        try {
            fous = new FileOutputStream(file); // 实例化FileOutputStream对象
            lock = fous.getChannel().tryLock(); // 获取文件锁定
            Thread.sleep(60 * 1000); // 线程锁定1分钟
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = "D://count.txt"; // 创建文件对象
        fileLock(file); // 调用文件锁定方法
    }
}
