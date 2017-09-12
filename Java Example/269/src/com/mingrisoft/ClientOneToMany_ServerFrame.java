package com.mingrisoft;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientOneToMany_ServerFrame extends JFrame {
    private JTextArea ta_info;
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    private Vector<Socket> vector = new Vector<Socket>();// 用于存储连接到服务器的客户端套接字对象
    
    public void createSocket() {
        try {
            server = new ServerSocket(1978);
            while (true) {
                ta_info.append("等待新客户连接......\n");
                socket = server.accept();// 创建套接字对象
                vector.add(socket);// 将套接字对象添加到向量对象中
                ta_info.append("客户端连接成功。" + socket + "\n");
                new ServerThread(socket).start();// 创建并启动线程对象
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    class ServerThread extends Thread {
        Socket socket;
        public ServerThread(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));// 创建输入流对象
                while (true) {
                    String info = in.readLine();// 读取信息
                    for (Socket s : vector) {// 遍历所有客户端套接字对象
                        if (s != socket) {// 如果不是发送信息的套接字对象
                            PrintWriter out = new PrintWriter(s
                                    .getOutputStream(), true);// 创建输出流对象
                            out.println(info);// 发送信息
                            out.flush();// 刷新输出缓冲区
                        }
                    }
                }
            } catch (IOException e) {
                ta_info.append(socket + "已经退出。\n");
                vector.remove(socket);// 移除退出的客户端套接字
            }
        }
    }
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        ClientOneToMany_ServerFrame frame = new ClientOneToMany_ServerFrame();
        frame.setVisible(true);
        frame.createSocket();
    }
    
    /**
     * Create the frame
     */
    public ClientOneToMany_ServerFrame() {
        super();
        setTitle("客户端一对多通信——服务器端程序");
        setBounds(100, 100, 385, 266);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
    }
}
