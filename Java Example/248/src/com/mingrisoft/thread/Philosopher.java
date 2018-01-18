package com.mingrisoft.thread;

import java.util.Random;

import javax.swing.JTextArea;

public class Philosopher implements Runnable {
    
    private int id;
    private ChopstickArray chopstickArray;
    private boolean state;
    private JTextArea thinkingTextArea;
    private JTextArea eatingTextArea;
    private JTextArea waitingTextArea;
    
    public Philosopher(int id, ChopstickArray chopstickArray, JTextArea thinkingTextArea, JTextArea eatingTextArea, JTextArea waitingTextArea) {
        this.id = id;
        this.chopstickArray = chopstickArray;
        this.thinkingTextArea = thinkingTextArea;
        this.eatingTextArea = eatingTextArea;
        this.waitingTextArea = waitingTextArea;
    }
    
    public synchronized void thinking() {
        if (state) {
            chopstickArray.get(id).setAvailable(true);
            chopstickArray.getLast(id).setAvailable(true);
            String text = thinkingTextArea.getText();
            thinkingTextArea.setText(text + this + " 在思考\n");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state = false;
    }
    
public synchronized void eating() {
    if (!state) {// state是一个布尔值，true表示哲学家刚才的状态是吃饭，false表示思考
        if (chopstickArray.get(id).isAvailable()) {// 如果哲学家右手边的筷子可用
            if (chopstickArray.getLast(id).isAvailable()) {// 如果哲学家左手边的筷子可用
                chopstickArray.get(id).setAvailable(false);// 设置右手筷子不可用
                chopstickArray.getLast(id).setAvailable(false);// 设置左手筷子不可用
                String text = eatingTextArea.getText();
                eatingTextArea.setText(text + this + " 在吃饭\n");// 显示哲学家在吃饭
                try {
                    Thread.sleep(100);// 吃饭时间设置成0.1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {// 如果哲学家左手边的筷子不可用，就在相应的文本域中显示等待信息
                String text = waitingTextArea.getText();
                waitingTextArea.setText(text + this + " 在等待 " + chopstickArray.getLast(id) + "\n");
                try {
                    wait(new Random().nextInt(100));// 等待小于0.1秒时间后检查筷子是否可用
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {// 如果哲学家右手边的筷子不可用，就在相应的文本域中显示等待信息
            String text = waitingTextArea.getText();
            waitingTextArea.setText(text + this + " 在等待 " + chopstickArray.get(id) + "\n");
            try {
                wait(new Random().nextInt(100));// 等待小于0.1秒时间后检查筷子是否可用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    state = true;// 设置state的值为true表示哲学家的状态是吃饭
}
    
    @Override
    public void run() {
        
        for (int i = 0; i < 10; i++) {
            thinking();
            eating();
        }
    }
    
    @Override
    public String toString() {
        return " 哲学家 " + id;
    }
    
}
