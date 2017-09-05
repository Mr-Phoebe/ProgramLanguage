package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerSocketFrame extends JFrame {
    private JTextField tf_send;
    private JTextArea ta_info;
    private OutputStreamWriter out; // 创建流对象
    private PrintWriter writer; // 声明PrintWriter类对象
    private BufferedReader reader; // 声明BufferedReader对象
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    
    public void getserver() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                ta_info.append("等待客户机的连接......\n"); // 输出信息
                socket = server.accept(); // 实例化Socket对象
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream(), "UTF-8")); // 实例化BufferedReader对象
                out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
                writer = new PrintWriter(out, true);
                getClientInfo(); // 调用getClientInfo()方法
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    private void getClientInfo() {
        try {
            while (true) { // 如果套接字是连接状态
                String line = reader.readLine();
                if (line != null)
                    ta_info.append("接收到客户机发送的信息：" + line + "\n"); // 获得客户端信息
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
        frame.getserver(); // 调用方法
    }
    
    public ServerSocketFrame() {
        super();
        setTitle("防止传递汉字乱码服务器端");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 260);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        
        final JLabel label = new JLabel();
        label.setText("服务器发送的信息：");
        panel.add(label);
        
        tf_send = new JTextField();
        tf_send.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                writer.println(tf_send.getText()); // 将文本框中信息写入流
                ta_info.append("服务器发送的信息是：" + tf_send.getText() + "\n"); // 将文本框中信息显示在文本域中
                tf_send.setText(" "); // 将文本框清空
            }
        });
        tf_send.setPreferredSize(new Dimension(220, 25));
        panel.add(tf_send);
    }
}
