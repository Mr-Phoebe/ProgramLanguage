package com.mingrisoft.thread;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();// 创建State对象
        Thread thread = new Thread(state);// 利用State对象创建Thread对象
        System.out.println("新建线程：" + thread.getState());// 输出线程状态
        thread.start(); // 调用thread对象的start()方法，启动新线程
        System.out.println("启动线程：" + thread.getState());// 输出线程状态
        Thread.sleep(100); // 当前线程休眠0.1秒，使新线程运行waitForASecond()方法
        System.out.println("计时等待：" + thread.getState());// 输出线程状态
        Thread.sleep(1000); // 当前线程休眠1秒，使新线程运行waitForYears()方法
        System.out.println("等待线程：" + thread.getState());// 输出线程状态
        state.notifyNow(); // 调用state的notifyNow()方法
        System.out.println("唤醒线程：" + thread.getState());// 输出线程状态
        Thread.sleep(1000); // 当前线程休眠1秒，使新线程结束
        System.out.println("终止线程：" + thread.getState());// 输出线程状态
    }
    
}
