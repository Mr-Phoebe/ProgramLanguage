package com.mingrisoft;

import java.awt.BorderLayout;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerSocketFrame extends JFrame {
    private JTextArea ta_info;
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    
    public ServerSocketFrame() {
        super();
        setTitle("关闭Socket缓冲");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 278, 185);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
    }
    
    public void getserver() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                ta_info.append("等待客户机的连接......\n"); // 输出信息
                ta_info.append("如果连接成功就会关闭Socket缓冲......\n"); // 输出信息
                socket = server.accept(); // 实例化Socket对象
                socket.setTcpNoDelay(true);// 关闭Socket缓冲，提高数据传输速度
                ta_info.append("已经关闭Socket缓冲......\n"); // 输出信息
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    public static void main(String[] args) { // 主方法
        ServerSocketFrame frame = new ServerSocketFrame(); // 创建本类对象
        frame.setVisible(true);
        frame.getserver(); // 调用方法
    }

}
