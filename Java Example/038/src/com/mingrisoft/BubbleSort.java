package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class BubbleSort extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5417254398243107506L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BubbleSort frame = new BubbleSort();
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
    public BubbleSort() {
        setTitle("使用冒泡排序法对数组排序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 306, 364);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 5, 280, 46);
        contentPane.add(scrollPane);
        
        textArea1 = new JTextArea();
        scrollPane.setViewportView(textArea1);
        
        JButton button = new JButton("生成随机数数组");
        button.setBounds(85, 60, 125, 28);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        contentPane.add(button);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(5, 101, 280, 173);
        contentPane.add(scrollPane_1);
        
        textArea2 = new JTextArea();
        scrollPane_1.setViewportView(textArea2);
        
        JButton button_1 = new JButton("排序");
        button_1.setBounds(120, 285, 60, 28);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        contentPane.add(button_1);
    }
    
    private int[] array = new int[10];
    private JTextArea textArea1;
    private JTextArea textArea2;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Random random = new Random();// 创建随机数对象
        textArea1.setText("");// 清空文本域
        for (int i = 0; i < array.length; i++) {// 初始化数组元素
            array[i] = random.nextInt(50);// 生成50以内的随机数
            textArea1.append(array[i] + "  ");// 把数组元素显示的文本域控件中
        }
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        textArea2.setText("");// 清空文本域
        for (int i = 1; i < array.length; i++) {
            // 比较相邻两个元素，较大的数往后冒泡
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];// 把第一个元素值保持到临时变量中
                    array[j] = array[j + 1];// 把第二个元素值保存到第一个元素单元中
                    array[j + 1] = temp;// 把临时变量也就是第一个元素原值保持到第二个元素中
                }
                textArea2.append(array[j] + "  ");// 把排序后的数组元素显示到文本域中
            }
            textArea2.append("【");
            for (int j = array.length - i; j < array.length; j++) {
                textArea2.append(array[j] + "  ");// 把排序后的数组元素显示到文本域中
            }
            textArea2.append("】\n");
        }
    }
}
