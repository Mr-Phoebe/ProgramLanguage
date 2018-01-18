package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientOneToMany_ClientFrame extends JFrame {
    private JTextArea ta_info;
    private JTextField tf_send;
    PrintWriter out;// 声明输出流对象
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientOneToMany_ClientFrame frame = new ClientOneToMany_ClientFrame();
                    frame.setVisible(true);
                    frame.createClientSocket();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void createClientSocket() {
        try {
            Socket socket = new Socket("192.168.1.122", 1978);// 创建套接字对象
            out = new PrintWriter(socket.getOutputStream(), true);// 创建输出流对象
            new ClientThread(socket).start();// 创建并启动线程对象
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    class ClientThread extends Thread {
        Socket socket;
        
        public ClientThread(Socket socket) {
            this.socket = socket;
        }
        
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));// 创建输入流对象
                while (true) {
                    String info = in.readLine();// 读取信息
                    ta_info.append(info + "\n");// 在文本域中显示信息
                    if (info.equals("88")) {
                        break;// 结束线程
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void send() {
        String info = tf_send.getText();// 获得输入的信息
        if (info.equals("")) {
            return;// 如果没输入信息则返回，即不发送
        }
        if (info.equals("88")) {
            System.exit(0);// 如果没输入信息是88，则退出
        }
        out.println(info);// 发送信息
        out.flush();// 刷新输出缓冲区
        tf_send.setText(null);// 清空文本框
    }
    /**
     * Create the frame
     */
    public ClientOneToMany_ClientFrame() {
        super();
        setTitle("客户端一对多通信——客户端程序");
        setBounds(100, 100, 385, 266);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        
        final JLabel label = new JLabel();
        label.setText("输入聊天内容：");
        panel.add(label);
        
        tf_send = new JTextField();
        tf_send.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                send();// 调用方法发送信息
            }
        });
        tf_send.setPreferredSize(new Dimension(180, 25));
        panel.add(tf_send);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                send();// 调用方法发送信息
            }
        });
        button.setText("发  送");
        panel.add(button);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        //
    }
    
}
