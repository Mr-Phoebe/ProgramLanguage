
package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlFormSize extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2085588912441845548L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControlFormSize frame = new ControlFormSize();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public ControlFormSize() {
        setTitle("设置窗体大小");// 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 默认关闭方式
        setSize(400, 300);// 设置窗体大小
        contentPane = new JPanel();// 创建内容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// 设置内容面板
        JLabel label = new JLabel("宽度：400，高度：300");// 创建标签控件
        contentPane.add(label, BorderLayout.CENTER);// 添加标签控件到窗体
    }
    
}
