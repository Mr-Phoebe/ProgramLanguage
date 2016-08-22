package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class InsertSort extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6620166811183406036L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertSort frame = new InsertSort();
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
    public InsertSort() {
        setTitle("使用直接插入法对数组排序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 335, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textArea1 = new JTextArea();
        textArea1.setBounds(6, 6, 86, 250);
        contentPane.add(textArea1);
        
        JButton button = new JButton("随机生成数组");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(104, 49, 114, 30);
        contentPane.add(button);
        
        JButton button_1 = new JButton("排序");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(104, 161, 114, 30);
        contentPane.add(button_1);
        
        textArea2 = new JTextArea();
        textArea2.setBounds(230, 6, 86, 250);
        contentPane.add(textArea2);
    }
    
    private int[] array = new int[10];
    private JTextArea textArea1;
    private JTextArea textArea2;
    
protected void do_button_actionPerformed(ActionEvent e) {
    Random random = new Random();// 创建随机数对象
    textArea1.setText("");
    for (int i = 0; i < array.length; i++) {// 初始化数组元素
        array[i] = random.nextInt(90);// 生成50以内的随机数
        textArea1.append(array[i] + "\n");// 把数组元素显示的文本域控件中
    }
}
    
protected void do_button_1_actionPerformed(ActionEvent e) {
    int tmp;// 定义临时变量
    int j;
    for (int i = 1; i < array.length; i++) {
        tmp = array[i];// 保存临时变量
        for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
            array[j + 1] = array[j];// 数组元素交换
        }
        array[j + 1] = tmp;// 在排序位置插入数据
    }
    textArea2.setText("");
    for (int i = 0; i < array.length; i++) {// 初始化数组元素
        textArea2.append(array[i] + "\n");// 把数组元素显示的文本域控件中
    }
}
}
