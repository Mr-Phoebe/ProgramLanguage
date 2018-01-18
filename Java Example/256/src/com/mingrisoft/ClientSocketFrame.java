package com.mingrisoft;

import java.awt.BorderLayout;
import java.net.*;
import javax.swing.*;
import javax.swing.JScrollPane;

public class ClientSocketFrame extends JFrame { // 创建类继承JFrame类
    private Socket socket; // 声明Socket对象
    private JTextArea ta_info = new JTextArea(); // 创建JtextArea对象
    
    public ClientSocketFrame() { // 构造方法
        super(); // 调用父类的构造方法
        setTitle("建立客户端套接字");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 254, 166);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
    }
    
    private void connect() { // 连接套接字方法
        ta_info.append("尝试连接......\n"); // 文本域中信息信息
        try { // 捕捉异常
            socket = new Socket("127.0.0.1", 1978); // 实例化Socket对象
            ta_info.append("完成连接。\n"); // 文本域中提示信息
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    public static void main(String[] args) { // 主方法
        ClientSocketFrame clien = new ClientSocketFrame(); // 创建本例对象
        clien.setVisible(true); // 将窗体显示
        clien.connect(); // 调用连接方法
    }
}
