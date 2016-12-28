package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerSocketFrame extends JFrame {
    
    private JTextField tf_name;
    private JTextField tf_id;
    private JTextArea ta_info;
    private ObjectOutputStream out = null; // 创建流对象
    private ObjectInputStream in = null; // 创建流对象
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    
    public void getserver() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                ta_info.append("等待客户机的连接......\n"); // 输出信息
                socket = server.accept(); // 实例化Socket对象
                ta_info.append("客户机连接成功\n"); // 输出信息
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
                getClientInfo(); // 调用getClientInfo()方法
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    private void getClientInfo() {
        try {
            while (true) { // 如果套接字是连接状态
                Student stud = (Student)in.readObject();
                if (stud!=null)
                ta_info.append("接收到客户机发送的  编号为：" + stud.getId() + "  名称为：" +stud.getName() + "\n"); // 获得客户端信息
            }
        } catch (Exception e) {
            ta_info.append("客户端已退出。\n"); // 输出异常信息
        } finally {
            try {
                if (in != null) {
                    in.close();// 关闭流
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
        setTitle("服务器端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 260);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);

        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        final JLabel label = new JLabel();
        label.setText("编号：");
        panel.add(label);

        tf_id = new JTextField();
        tf_id.setPreferredSize(new Dimension(70,25));
        panel.add(tf_id);

        final JLabel label_1 = new JLabel();
        label_1.setText("名称：");
        panel.add(label_1);

        tf_name = new JTextField();
        tf_name.setPreferredSize(new Dimension(100,25));
        panel.add(tf_name);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                Student stud = new Student();
                stud.setId(tf_id.getText());
                stud.setName(tf_name.getText());
                try {
                    out.writeObject(stud);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } 
                ta_info.append("服务器发送的  编号是：" + tf_id.getText() + "  名称是："+tf_name.getText()+"\n"); // 将文本框中信息显示在文本域中
                tf_id.setText(null); // 将文本框清空
                tf_name.setText(null);
            }
        });
        button.setText("发  送");
        panel.add(button);
    }
}
