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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientOneToOne_ClientFrame extends JFrame {
    private JTextField tf_newUser;
    private JList user_list;
    private JTextArea ta_info;
    private JTextField tf_send;
    PrintWriter out;// 声明输出流对象
    private boolean loginFlag = false;// 为true时表示已经登录，为false时表示未登录
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientOneToOne_ClientFrame frame = new ClientOneToOne_ClientFrame();
                    frame.setVisible(true);
                    frame.createClientSocket();// 调用方法创建套接字对象
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
                DefaultComboBoxModel model = (DefaultComboBoxModel) user_list
                                .getModel();// 获得列表框的模型
                while (true) {
                    String info = in.readLine().trim();// 读取信息
                    
                    if (!info.startsWith("MSG:")) {
                        boolean itemFlag = false;// 标记是否为列表框添加列表项，为true不添加，为false添加
                        for (int i = 0; i < model.getSize(); i++) {
                            if (info.equals((String) model.getElementAt(i))) {
                                itemFlag = true;
                            }
                        }
                        if (!itemFlag) {
                            model.addElement(info);// 添加列表项
                        } else {
                            itemFlag = false;
                        }
                    } else {
                        ta_info.append(info + "\n");// 在文本域中显示信息
                        if (info.equals("88")) {
                            break;// 结束线程
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void send() {
        if (!loginFlag) {
            JOptionPane.showMessageDialog(null, "请先登录。");
            return;
        }
        String sendUserName = tf_newUser.getText().trim();
        String info = tf_send.getText();// 获得输入的信息
        if (info.equals("")) {
            return;// 如果没输入信息则返回，即不发送
        }
        String receiveUserName = (String) user_list.getSelectedValue();// 获得接收信息的用户
        String msg = sendUserName + "：发送给：" + receiveUserName + "：的信息是： "
                + info;// 定义发送的信息
        if (info.equals("88")) {
            System.exit(0);// 如果没输入信息是88，则退出
        }
        out.println(msg);// 发送信息
        out.flush();// 刷新输出缓冲区
        tf_send.setText(null);// 清空文本框
    }
    
    /**
     * Create the frame
     */
    public ClientOneToOne_ClientFrame() {
        super();
        setTitle("客户端一对一通信——客户端程序");
        setBounds(100, 100, 385, 288);
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
        
        final JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(100);
        getContentPane().add(splitPane, BorderLayout.CENTER);
        
        final JScrollPane scrollPane = new JScrollPane();
        splitPane.setRightComponent(scrollPane);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        
        final JScrollPane scrollPane_1 = new JScrollPane();
        splitPane.setLeftComponent(scrollPane_1);
        
        user_list = new JList();
        user_list.setModel(new DefaultComboBoxModel(new String[] { "" }));
        scrollPane_1.setViewportView(user_list);
        
        final JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.NORTH);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("输入用户名称：");
        panel_1.add(label_1);
        
        tf_newUser = new JTextField();
        tf_newUser.setPreferredSize(new Dimension(180, 25));
        panel_1.add(tf_newUser);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (loginFlag) {
                    JOptionPane.showMessageDialog(null, "在同一窗口只能登录一次。");
                    return;
                }
                String userName = tf_newUser.getText().trim();// 获得登录用户名
                out.println("用户：" + userName);// 发送登录用户的名称
                out.flush();// 刷新输出缓冲区
                tf_newUser.setEnabled(false);
                loginFlag = true;
            }
        });
        button_1.setText("登  录");
        panel_1.add(button_1);
    }
}
