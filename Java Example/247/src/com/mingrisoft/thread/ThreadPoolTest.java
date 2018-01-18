package com.mingrisoft.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();// 创建Runtime对象
        run.gc();// 运行垃圾回收器，这样可以减少误差
        long freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
        long currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
        for (int i = 0; i < 10000; i++) {// 独立运行1000个线程
            new Thread(new TempThread()).start();
        }
        System.out.println("独立运行1000个线程所占用的内存：" + (freeMemory - run.freeMemory()) + "字节");// 查看内存的变化
        System.out.println("独立创建1000个线程所消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 查看时间的变化
        
        run.gc();// 运行垃圾回收器
        freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
        currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 创建线程池
        for (int i = 0; i < 1000; i++) {// 使用线程池运行1000个线程
            executorService.submit(new TempThread());
        }
        System.out.println("使用连接池运行1000个线程所占用的内存：" + (freeMemory - run.freeMemory()) + "字节");// 查看内存的变化
        System.out.println("使用连接池创建1000个线程所消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 查看时间的变化
    }
}
