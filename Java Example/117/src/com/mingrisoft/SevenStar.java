package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SevenStar extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6787592245621788484L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
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
                    SevenStar frame = new SevenStar();
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
    public SevenStar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setTitle("七星彩号码生成器");
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel label = new JLabel("请输入号码组数：");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        panel.add(textField);
        textField.setColumns(10);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("生成号码");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int times = Integer.parseInt(textField.getText());// 获得用户输入的需要生成的中奖号码个数
                // 省略提示购买数量太多的代码
                StringBuilder sb = new StringBuilder();// 利用StringBuilder类保存彩票中奖号码
                for (int i = 0; i < times; i++) {
                    int number = new Random().nextInt((int) Math.pow(10, 7));// 生成随机数
                    String luckNumber = "" + number;
                    while (luckNumber.length() < 7) {
                        luckNumber = "0" + luckNumber;// 如果随机数长度不够7位用0补齐
                    }
                    sb.append(luckNumber + "\n");
                }
                textArea.setText(sb.toString());// 显示生成的中奖号码
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonPanel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        scrollPane.setViewportView(textArea);
    }
    
}