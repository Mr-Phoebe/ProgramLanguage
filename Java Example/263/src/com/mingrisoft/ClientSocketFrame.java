package com.mingrisoft;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClientSocketFrame extends JFrame { // 创建类继承JFrame类
    private JButton button;
    private JTextField tf_name;
    private JLabel label_1;
    private JLabel label;
    private JPanel panel;
    private ObjectInputStream in = null;// 创建流对象
    private ObjectOutputStream out = null;// 创建流对象
    private Socket socket;// 声明Socket对象
    private JTextArea ta_info = new JTextArea();// 创建JtextArea对象
    private JTextField tf_id = new JTextField();// 创建JtextField对象
    private Container cc;// 声明Container对象
    
    public ClientSocketFrame() { // 构造方法
        super(); // 调用父类的构造方法
        setTitle("客户端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 257);
        cc = this.getContentPane(); // 实例化对象
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
        getContentPane().add(getPanel(), BorderLayout.NORTH);
    }
    
    private void connect() { // 连接套接字方法
        ta_info.append("尝试连接......\n"); // 文本域中信息信息
        try { // 捕捉异常
            socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
            while (true){
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
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
                Student stud = (Student)in.readObject();
                if (stud!=null)
                ta_info.append("接收到服务器发送的  编号为：" + stud.getId() + "  名称为：" +stud.getName() + "\n"); // 获得服务器信息
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
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
    /**
     * @return
     */
    protected JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.add(getLabel());
            tf_id.setPreferredSize(new Dimension(70, 25));
            panel.add(tf_id);
            panel.add(getLabel_1());
            panel.add(getTf_name());
            panel.add(getButton());
        }
        return panel;
    }
    
    /**
     * @return
     */
    protected JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
            label.setText("编号：");
        }
        return label;
    }
    /**
     * @return
     */
    protected JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel();
            label_1.setText("名称：");
        }
        return label_1;
    }
    /**
     * @return
     */
    protected JTextField getTf_name() {
        if (tf_name == null) {
            tf_name = new JTextField();
            tf_name.setPreferredSize(new Dimension(100, 25));
        }
        return tf_name;
    }
    /**
     * @return
     */
    protected JButton getButton() {
        if (button == null) {
            button = new JButton();
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
                    ta_info.append("客户端发送的  编号是：" + tf_id.getText() + "  名称是："+tf_name.getText()+"\n"); // 将文本框中信息显示在文本域中
                    tf_id.setText(null); // 将文本框清空
                    tf_name.setText(null);
                }
            });
            button.setText("发  送");
        }
        return button;
    }
}
