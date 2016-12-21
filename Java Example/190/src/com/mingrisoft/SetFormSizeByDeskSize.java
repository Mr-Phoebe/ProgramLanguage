package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SetFormSizeByDeskSize extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8256394807443698879L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetFormSizeByDeskSize frame = new SetFormSizeByDeskSize();
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
    public SetFormSizeByDeskSize() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setTitle("\u6839\u636E\u684C\u9762\u5927\u5C0F\u8C03\u6574\u7A97\u4F53\u5927\u5C0F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        Toolkit toolkit = getToolkit();// 获得窗体工具包
        Dimension screenSize = toolkit.getScreenSize();// 获取屏幕大小
        int width = (int) (screenSize.width * 0.8);// 计算窗体新宽度
        int height = (int) (screenSize.height * 0.8);// 计算窗体新宽度
        setSize(width, height);// 设置窗体大小
    }
}
