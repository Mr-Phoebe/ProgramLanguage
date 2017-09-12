package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerSocketFrame extends JFrame {
    private JTextField tf_send;
    private JTextArea ta_info;
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    private Vector<Socket> vector = new Vector<Socket>();// 用于存储连接到服务器的客户端套接字对象
    private int counts = 0;// 用于记录连接的客户人数
    
    public void getServer() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                socket = server.accept(); // 实例化Socket对象
                counts++;
                ta_info.append("第" + counts + "个客户连接成功\n"); // 输出信息
                PrintWriter out = new PrintWriter(socket.getOutputStream(),
                        true);
                out.println(String.valueOf(counts - 1));// 向客户端发送套接字索引
                vector.add(socket);// 存储客户端套接字对象
                new ServerThread(socket).start();// 创建并启动线程序
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    class ServerThread extends Thread {
        Socket socket = null; // 创建Socket对象
        BufferedReader reader; // 声明BufferedReader对象
        
        public ServerThread(Socket socket) { // 构造方法
            this.socket = socket;
        }
        
        public void run() {
            try {
                if (socket != null) {
                    reader = new BufferedReader(new InputStreamReader(socket
                            .getInputStream())); // 实例化BufferedReader对象
                    int index = -1;// 存储退出的客户端索引值
                    try {
                        while (true) { // 如果套接字是连接状态
                            String line = reader.readLine();// 读取客户端信息
                            try {
                                index = Integer.parseInt(line);// 获得退出的客户端索引值
                            } catch (Exception ex) {
                                index = -1;
                            }
                            if (line != null) {
                                ta_info.append("接收到客户机发送的信息：" + line + "\n"); // 获得客户端信息
                            }
                        }
                    } catch (Exception e) {
                        if (index != -1) {
                            vector.set(index, null);// 将退出的客户端套接字设置为null
                            ta_info.append("第" + (index + 1) + "个客户端已经退出。\n"); // 输出异常信息
                        }
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    private void writeInfo(PrintWriter writer, String text) {
        writer.println(text);
    }
    
    public static void main(String[] args) { // 主方法
        ServerSocketFrame frame = new ServerSocketFrame(); // 创建本类对象
        frame.setVisible(true);// 显示窗体
        frame.getServer(); // 调用方法
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
        getContentPane().add(panel, BorderLayout.SOUTH);
        
        final JLabel label = new JLabel();
        label.setText("服务器发送的信息：");
        panel.add(label);
        
        tf_send = new JTextField();
        tf_send.setPreferredSize(new Dimension(150, 25));
        panel.add(tf_send);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                for (int i = 0; i < vector.size(); i++) {
                    Socket socket = vector.get(i);// 获得连接成功的套接字对象
                    PrintWriter writer;
                    try {
                        if (socket != null && !socket.isClosed()) {
                            writer = new PrintWriter(socket.getOutputStream(),
                                    true);// 创建输出流对象
                            writeInfo(writer, tf_send.getText()); // 将文本框中信息写入流
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                ta_info.append("服务器发送的信息是：" + tf_send.getText() + "\n"); // 将文本框中信息显示在文本域中
                tf_send.setText(""); // 将文本框清空
            }
        });
        button.setText("发  送");
        panel.add(button);
        
        final JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.NORTH);
        
        final JLabel label_1 = new JLabel();
        label_1.setForeground(new Color(0, 0, 255));
        label_1.setFont(new Font("", Font.BOLD, 22));
        label_1.setText("一对多通信——服务器端程序");
        panel_1.add(label_1);
    }
}
