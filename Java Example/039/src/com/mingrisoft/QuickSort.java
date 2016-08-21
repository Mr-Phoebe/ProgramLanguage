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
import javax.swing.UIManager;
import javax.swing.JTextField;

public class QuickSort extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2985623477805805108L;
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
                    QuickSort frame = new QuickSort();
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
    public QuickSort() {
        setTitle("使用快速排序法对数组排序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 311, 383);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JButton button = new JButton("生成随机数组");
        button.setBounds(105, 40, 88, 30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        textField = new JTextField();
        textField.setBounds(5, 5, 287, 30);
        contentPane.add(textField);
        contentPane.add(button);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(5, 75, 287, 228);
        contentPane.add(scrollPane_1);
        
        textArea2 = new JTextArea();
        scrollPane_1.setViewportView(textArea2);
        
        JButton button_1 = new JButton("排序");
        button_1.setBounds(120, 310, 52, 30);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        contentPane.add(button_1);
    }
    
    private int[] array = new int[10];
    private JTextField textField;
    private JTextArea textArea2;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Random random = new Random();// 创建随机数对象
        String text = "";
        for (int i = 0; i < array.length; i++) {// 初始化数组元素
            array[i] = random.nextInt(90);// 生成50以内的随机数
            text += (array[i] + "  ");// 把数组元素显示的文本域控件中
        }
        textField.setText(text);
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        textArea2.setText("");// 清空文本域
        quickSort(array, 0, array.length - 1);// 调用快速排序算法
    }
    
    private void quickSort(int sortarray[], int lowIndex, int highIndex) {
        int lo = lowIndex;// 记录最小索引
        int hi = highIndex;// 记录最大索引
        int mid;// 记录分界点元素
        if (highIndex > lowIndex) {
            mid = sortarray[(lowIndex + highIndex) / 2];// 确定中间分界点元素值
            while (lo <= hi) {
                while ((lo < highIndex) && (sortarray[lo] < mid))
                    ++lo;// 确定不大于分界元素值的最小索引
                while ((hi > lowIndex) && (sortarray[hi] > mid))
                    --hi;// 确定大于分界元素值的最大索引
                if (lo <= hi) {// 如果最小与最大索引没有重叠
                    swap(sortarray, lo, hi);// 交换两个索引的元素
                    ++lo;// 递增最小索引
                    --hi;// 递减最大索引
                }
            }
            if (lowIndex < hi)// 递归排序没有未分解元素
                quickSort(sortarray, lowIndex, hi);
            if (lo < highIndex)// 递归排序没有未分解元素
                quickSort(sortarray, lo, highIndex);
        }
    }
    
    private void swap(int swapArray[], int i, int j) {
        int temp = swapArray[i];// 交换数组元素
        swapArray[i] = swapArray[j];
        swapArray[j] = temp;
        for (int k = 0; k < array.length; k++) {// 把数组元素显示到文本域
            textArea2.append(array[k] + "  ");
        }
        textArea2.append("\n");// 追加换行符
    }
    
}
