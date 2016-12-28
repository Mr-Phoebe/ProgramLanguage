package com.mingrisoft;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ColorChooser extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1251247361403125478L;
    private JPanel contentPane;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    
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
                    ColorChooser frame = new ColorChooser();
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
    public ColorChooser() {
        setTitle("\u989C\u8272\u9009\u62E9\u5BF9\u8BDD\u6846");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 348, 162);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 3, 0, 0));
        
        JLabel label = new JLabel("\u5927\u6D77\u7684\u989C\u8272\uFF1A");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label);
        
        label1 = new JLabel("");
        label1.setOpaque(true);
        label1.setBackground(Color.WHITE);
        contentPane.add(label1);
        
        JButton button1 = new JButton("\u9009\u62E9");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        contentPane.add(button1);
        
        JLabel label_2 = new JLabel("\u6811\u53F6\u7684\u989C\u8272\uFF1A");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label_2);
        
        label2 = new JLabel("");
        label2.setBackground(Color.WHITE);
        label2.setOpaque(true);
        contentPane.add(label2);
        
        JButton button2 = new JButton("\u9009\u62E9");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button2_actionPerformed(e);
            }
        });
        contentPane.add(button2);
        
        JLabel label_4 = new JLabel("\u73AB\u7470\u7684\u989C\u8272\uFF1A");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label_4);
        
        label3 = new JLabel("");
        label3.setBackground(Color.WHITE);
        label3.setOpaque(true);
        contentPane.add(label3);
        
        JButton button3 = new JButton("\u9009\u62E9");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button3_actionPerformed(e);
            }
        });
        contentPane.add(button3);
        
        JLabel label_6 = new JLabel("\u6211\u7684\u80A4\u8272\uFF1A");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label_6);
        
        label4 = new JLabel("");
        label4.setBackground(Color.WHITE);
        label4.setOpaque(true);
        contentPane.add(label4);
        
        JButton button4 = new JButton("\u9009\u62E9");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button4_actionPerformed(e);
            }
        });
        contentPane.add(button4);
    }
    
    protected void do_button1_actionPerformed(ActionEvent e) {
        setColor(label1);// 指定标签的颜色设置
    }
    
    private void setColor(JLabel label) {
        Color color = label.getBackground();// 获取原来的颜色对象
        // 显示颜色选择对话框
        Color newColor = JColorChooser.showDialog(this, "选择颜色", color);
        label.setBackground(newColor);// 把获取的颜色设置为标签的背景色
    }
    
    protected void do_button2_actionPerformed(ActionEvent e) {
        setColor(label2);
    }
    
    protected void do_button3_actionPerformed(ActionEvent e) {
        setColor(label3);
    }
    
    protected void do_button4_actionPerformed(ActionEvent e) {
        setColor(label4);
    }
}
