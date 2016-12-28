package com.mingrisoft.thread;

public class JoinThread {
    
    public static void main(String[] args) {
        Thread thread = new Thread(new EmergencyThread());
        thread.start();
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正常情况：" + i + "号车出发！");
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}