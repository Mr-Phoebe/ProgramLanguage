package com.mingrisoft;

import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.*;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        super();
    }
    
    public void paintComponent(Graphics g) {
        try {
            URL url = getClass().getResource("enter.jpg"); // 指定图片路径
            ImageIcon image = new ImageIcon(url); // 创建ImageIcon对象
            g.drawImage(image.getImage(), 0, 0, this); // 将图片绘制到面板上
         
        } catch (Exception e) {
        }
    }
}
