package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AlwaysActiveWindows extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2637188442724889987L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AlwaysActiveWindows frame = new AlwaysActiveWindows();
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
    public AlwaysActiveWindows() {
        setTitle("始终在桌面最顶层显示的窗体");// 设置窗体标题
        setAlwaysOnTop(true);// 设置窗体显示在最顶端。本实例的核心代码
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 319, 206);// 设置窗体位置
        contentPane = new JPanel();// 创建内容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// 设置内容面板
        JLabel label = new JLabel("我就在上面不下去了，咋滴。");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);// 添加标签控件
    }
    
}
