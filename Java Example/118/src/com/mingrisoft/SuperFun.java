package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

public class SuperFun extends JFrame {
    
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
                    SuperFun frame = new SuperFun();
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
    public SuperFun() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setTitle("大乐透号码生成器");
        
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
                StringBuilder sb = new StringBuilder();// 创建字符串生成器对象
                for (int i = 0; i < times; i++) {
                    List<String> startList = getStartNumber();// 获得前段号码的集合
                    List<String> endList = getEndNumber();// 获得后段号码的集合
                    for (int m = 0; m < startList.size(); m++) {
                        sb.append(startList.get(m));// 在字符串生成器中添加前段号码
                    }
                    sb.append("    ");
                    for (int n = 0; n < endList.size(); n++) {
                        sb.append(endList.get(n));// 在字符串生成器中添加后段号码
                    }
                    sb.append("\n");
                }
                textArea.setText(sb.toString());// 在文本域中显示号码
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
    
    /**
     * 随机生成前段5个号码的方法
     * 
     * @return
     */
    public List<String> getStartNumber() {
        List<String> list = new ArrayList<String>(); // 创建前段号码集合
        String luckyNumber = "";
        for (int i = 1; i < 36; i++) { // 初始化前段号码集合
            if (i < 10) {
                list.add("0" + i + "  ");// 添加0~9的号码
            } else {
                list.add("" + i + "  ");// 添加大于9的号码
            }
        }
        int roundIndex = 0;
        List<String> luckylist = new ArrayList<String>(); // 保存前段号码的List集合
        for (int j = 0; j < 5; j++) {
            int amount = list.size(); // 获取前段号码的个数
            Random r = new Random(); // 创建并实例化Random的对象
            roundIndex = r.nextInt(amount); // 获取一个0到amount-1的随机数
            luckyNumber = list.get(roundIndex); // 获取幸运数字
            luckylist.add(luckyNumber); // 添加luckylist中
            list.remove(roundIndex); // 移除刚刚产生的号码
        }
        Collections.sort(luckylist); // 对前段号码进行排序
        return luckylist;
    }
    
    /**
     * 随机生成后段2个号码的方法
     * 
     * @return
     */
    public List<String> getEndNumber() {
        List<String> list = new ArrayList<String>(); // 创建后段号码集合
        String luckyNumber = "";
        for (int i = 1; i < 13; i++) { // 初始化后段号码集合
            if (i < 10) {
                list.add("0" + i + "  ");// 添加0~9的号码
            } else {
                list.add("" + i + "  ");// 添加大于9的号码
            }
        }
        int roundIndex = 0;
        List<String> luckylist = new ArrayList<String>(); // 保存后段号码的List集合
        for (int j = 0; j < 2; j++) {
            int amount = list.size(); // 获取后段号码的个数
            Random r = new Random(); // 创建并实例化Random的对象
            roundIndex = r.nextInt(amount); // 获取一个0到amount-1的随机数
            luckyNumber = list.get(roundIndex); // 获取幸运数字
            luckylist.add(luckyNumber); // 添加luckylist中
            list.remove(roundIndex); // 移除刚刚产生的号码
        }
        Collections.sort(luckylist); // 对后段号码进行排序
        return luckylist;
    }
}