package com.mingrisoft;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientOneToOne_ServerFrame extends JFrame {
    private JTextArea ta_info;
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    private Hashtable<String, Socket> map = new Hashtable<String, Socket>();// 用于存储连接到服务器的用户和客户端套接字对象
    
    public void createSocket() {
        try {
            server = new ServerSocket(1978);
            while (true) {
                ta_info.append("等待新客户连接......\n");
                socket = server.accept();// 创建套接字对象
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
                    String key = "";
                    if (info.startsWith("用户：")) {// 添加登录用户到客户端列表
                        key = info.substring(3, info.length());// 获得用户名并作为键使用
                        map.put(key, socket);// 添加键值对
                        Set<String> set = map.keySet();// 获得集合中所有键的Set视图
                        Iterator<String> keyIt = set.iterator();// 获得所有键的迭代器
                        while (keyIt.hasNext()) {
                            String receiveKey = keyIt.next();// 获得表示接收信息的键
                            Socket s = map.get(receiveKey);// 获得与该键对应的套接字对象
                            PrintWriter out = new PrintWriter(s
                                    .getOutputStream(), true);// 创建输出流对象
                            Iterator<String> keyIt1 = set.iterator();// 获得所有键的迭代器
                            while (keyIt1.hasNext()) {
                                String receiveKey1 = keyIt1.next();// 获得键，用于向客户端添加用户列表
                                out.println(receiveKey1);// 发送信息
                                out.flush();// 刷新输出缓冲区
                            }
                        }
                        
                    } else {// 转发接收的消息
                        key = info.substring(info.indexOf("：发送给：") + 5, info
                                .indexOf("：的信息是："));// 获得接收方的key值,即接收方的用户名
                        String sendUser = info.substring(0, info
                                .indexOf("：发送给："));// 获得发送方的key值,即发送方的用户名
                        Set<String> set = map.keySet();// 获得集合中所有键的Set视图
                        Iterator<String> keyIt = set.iterator();// 获得所有键的迭代器
                        while (keyIt.hasNext()) {
                            String receiveKey = keyIt.next();// 获得表示接收信息的键
                            if (key.equals(receiveKey)
                                    && !sendUser.equals(receiveKey)) {// 如果是发送方，但不是用户本身
                                Socket s = map.get(receiveKey);// 获得与该键对应的套接字对象
                                PrintWriter out = new PrintWriter(s
                                        .getOutputStream(), true);// 创建输出流对象
                                
                                out.println("MSG:"+info);// 发送信息
                                out.flush();// 刷新输出缓冲区
                            }
                        }
                    }
                }
            } catch (IOException e) {
                ta_info.append(socket + "已经退出。\n");
            }
        }
    }
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        ClientOneToOne_ServerFrame frame = new ClientOneToOne_ServerFrame();
        frame.setVisible(true);
        frame.createSocket();
    }
    
    /**
     * Create the frame
     */
    public ClientOneToOne_ServerFrame() {
        super();
        setTitle("客户端一对一通信——服务器端程序");
        setBounds(100, 100, 385, 266);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
    }
}
