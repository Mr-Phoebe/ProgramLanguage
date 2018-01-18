package com.mingrisoft;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.JScrollPane;

public class ClientSocketFrame extends JFrame { // 创建类继承JFrame类
    private PrintWriter writer; // 声明PrintWriter类对象
    private Socket socket; // 声明Socket对象
    private JTextArea ta_info = new JTextArea(); // 创建JtextArea对象
    private JTextField tf_send = new JTextField(); // 创建JtextField对象
    private Container cc; // 声明Container对象
    
    public ClientSocketFrame() { // 构造方法
        super(); // 调用父类的构造方法
        setTitle("客户端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 351, 257);
        cc = this.getContentPane(); // 实例化对象
        cc.add(tf_send, "South"); // 将文本框放在窗体的下部
        tf_send.addActionListener(new ActionListener() { // 绑定事件
                    public void actionPerformed(ActionEvent e) {
                        writer.println(tf_send.getText()); // 将文本框中信息写入流
                        ta_info.append("客户端发送的信息是：" + tf_send.getText() + "\n"); // 将文本框中信息显示在文本域中
                        tf_send.setText(""); // 将文本框清空
                    }
                });
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
    }
    
    private void connect() { // 连接套接字方法
        ta_info.append("尝试连接......\n"); // 文本域中信息信息
        try { // 捕捉异常
            socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
            writer = new PrintWriter(socket.getOutputStream(), true);// 创建输出流对象
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
