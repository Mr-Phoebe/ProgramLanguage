package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class CheckBoxArray extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5338362310060106193L;
    private JPanel contentPane;
    private JPanel panel;
    
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
                    CheckBoxArray frame = new CheckBoxArray();
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
    public CheckBoxArray() {
        setTitle("通过复选框控件数组实现添加多个复选框控件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 409, 331);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel(
                "你的爱好有哪些：");
        contentPane.add(label, BorderLayout.NORTH);
        contentPane.add(getPanel(), BorderLayout.CENTER);
    }
    
    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();// 创建面板对象
            panel.setLayout(new GridLayout(0, 4));// 设置网格布局管理器
            // 创建控件文本数组
            String[] labels = { "足球", "篮球", "魔术", "乒乓球", "看电影", "魔兽世界", "CS战队",
                    "羽毛球", "游泳", "旅游", "爬山", "唱歌", "写博客", "动物世界", "拍照", "弹吉他",
                    "读报纸", "飙车", "逛街", "逛商场", "麻将", "看书", "上网看资料", "新闻", "军事",
                    "八卦", "养生", "饮茶" };
            JCheckBox[] boxs = new JCheckBox[labels.length];// 创建控件数组
            for (int i = 0; i < boxs.length; i++) {// 遍历控件数组
                boxs[i] = new JCheckBox(labels[i]);// 初始化数组中的复选框组件
                panel.add(boxs[i]);// 把数组元素（即每个复选框）添加到面板中
            }
        }
        return panel;
    }
}
