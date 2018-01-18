package com.mingrisoft;

import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerSocketFrame extends JFrame {
    private JTextArea ta_info;// 声明文本域,用于显示连接信息和接收到的信息
    private BufferedReader reader; // 声明BufferedReader对象
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    
    public void getServer() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                ta_info.append("等待客户机的连接......\n"); // 输出信息
                socket = server.accept(); // 实例化Socket对象
                ta_info.append("连接成功。\n"); // 输出信息
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // 实例化BufferedReader对象
                getClientInfo(); // 调用getClientInfo()方法
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    private void getClientInfo() {
        try {
            while (true) { // 如果套接字是连接状态
                ta_info.append("接收到客户机发送的信息：" + reader.readLine() + "\n"); // 获得客户端信息
            }
        } catch (Exception e) {
            ta_info.append("客户端已退出。\n"); // 输出异常信息
        } finally {
            try {
                if (reader != null) {
                    reader.close();// 关闭流
                }
                if (socket != null) {
                    socket.close(); // 关闭套接字
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }
    
    public static void main(String[] args) { // 主方法
        ServerSocketFrame frame = new ServerSocketFrame(); // 创建本类对象
        frame.setVisible(true);
        frame.getServer(); // 调用方法
    }
    
    public ServerSocketFrame() {
        super();
        setTitle("服务器端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 336, 257);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
    }
}
