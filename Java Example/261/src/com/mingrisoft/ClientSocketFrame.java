package com.mingrisoft;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClientSocketFrame extends JFrame { // 创建类继承JFrame类
    private JLabel label;
    private JPanel panel;
    private PrintWriter writer; // 声明PrintWriter类对象
    private BufferedReader reader; // 声明BufferedReader对象
    private Socket socket; // 声明Socket对象
    private JTextArea ta_info = new JTextArea(); // 创建JtextArea对象
    private JTextField tf_send = new JTextField(); // 创建JtextField对象
    
    public ClientSocketFrame() { // 构造方法
        super(); // 调用父类的构造方法
        setTitle("客户端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 361, 257);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
        getContentPane().add(getPanel(), BorderLayout.NORTH);
    }
    
    private void connect() { // 连接套接字方法
        ta_info.append("尝试连接......\n"); // 文本域中信息信息
        try { // 捕捉异常
            socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
            while (true) {
                writer = new PrintWriter(socket.getOutputStream(), true);
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // 实例化BufferedReader对象
                ta_info.append("完成连接。\n"); // 文本域中提示信息
                getClientInfo();
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    public static void main(String[] args) { // 主方法
        ClientSocketFrame clien = new ClientSocketFrame(); // 创建本例对象
        clien.setVisible(true); // 将窗体显示
        clien.connect(); // 调用连接方法
    }
    
    private void getClientInfo() {
        try {
            while (true) { // 如果套接字是连接状态
                if (reader != null) {
                    String line = reader.readLine();
                    if (line != null)
                        ta_info.append("接收到服务器发送的信息：" + line + "\n"); // 获得客户端信息
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    
    /**
     * @return
     */
    protected JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.add(getLabel());
            tf_send.setPreferredSize(new Dimension(200, 25));
            panel.add(tf_send);
            tf_send.addActionListener(new ActionListener() { // 绑定事件
                        public void actionPerformed(ActionEvent e) {
                            writer.println(tf_send.getText()); // 将文本框中信息写入流
                            ta_info.append("客户端发送的信息是：" + tf_send.getText()
                                    + "\n"); // 将文本框中信息显示在文本域中
                            tf_send.setText(""); // 将文本框清空
                        }
                    });
        }
        return panel;
    }
    
    /**
     * @return
     */
    protected JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
            label.setText("客户端发送的信息：");
        }
        return label;
    }
}
