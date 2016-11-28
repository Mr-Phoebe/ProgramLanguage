package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class InsertDeptFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField deptNameTextField;
    private JTextField personTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertDeptFrame frame = new InsertDeptFrame();
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
    public InsertDeptFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 362, 217);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("添加部门信息");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 351, 180);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel dNameLabel = new JLabel("部门名称：");
        dNameLabel.setBounds(52, 30, 74, 15);
        panel.add(dNameLabel);
        
        deptNameTextField = new JTextField();
        deptNameTextField.setBounds(136, 27, 148, 21);
        panel.add(deptNameTextField);
        deptNameTextField.setColumns(10);
        
        JLabel pesonLabel = new JLabel("部门负责人：");
        pesonLabel.setBounds(37, 73, 89, 15);
        panel.add(pesonLabel);
        
        personTextField = new JTextField();
        personTextField.setBounds(136, 70, 148, 21);
        panel.add(personTextField);
        personTextField.setColumns(10);
        
        JButton insertButton = new JButton("添加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(71, 122, 74, 23);
        panel.add(insertButton);
        
        JButton watchButton = new JButton("查看");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_watchButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(176, 122, 74, 23);
        panel.add(watchButton);
    }
    //添加按钮的单击事件

protected void do_insertButton_actionPerformed(ActionEvent arg0) {
    String name = deptNameTextField.getText();      //获取用户添加的部门名称
    String person = personTextField.getText();      //获取用户添加的部门负责人
    Random ran = new Random(System.currentTimeMillis());        //根据当前时间的毫秒数创建随机数流
    StringBuilder idb=new StringBuilder();          //创建字符串缓冲对象
    idb.append(String.format("%019d",Math.abs(ran.nextLong()))+String.format("%03d",(int)(Math.random()*100%9)+1));
    idb=idb.reverse();              //对字符串缓冲对象取反
    String id=idb+ "" + String.format("%010d",Math.abs(ran.nextInt()));     
    Dept dept = new Dept();         //创建于数据表对应的JavaBean对象
    dept.setDid(id);                //设置对象属性
    dept.setdName(name);
    dept.setPriName(person);
    DeptUtil deptUtil = new DeptUtil();     //创建工具类对象
    deptUtil.insertDept(dept);      //调用添加方法
    JOptionPane.showMessageDialog(getContentPane(), 
            "数据添加成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
}
    
    //查看按钮的单击事件
    protected void do_watchButton_actionPerformed(ActionEvent arg0) {
        SelectDeptFrame frame = new SelectDeptFrame();
        frame.setVisible(true);
    }
}
