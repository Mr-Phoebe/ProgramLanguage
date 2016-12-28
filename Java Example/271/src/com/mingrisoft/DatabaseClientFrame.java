package com.mingrisoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DatabaseClientFrame extends JFrame {
    
    private JTextArea ta_result;
    private JTextField tf_age;
    private JTextField tf_name;
    private PrintWriter writer; // 声明PrintWriter类对象
    private BufferedReader reader; // 声明BufferedReader对象
    private Socket socket; // 声明Socket对象
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        DatabaseClientFrame frame = new DatabaseClientFrame();
        frame.setVisible(true);
        frame.connect();
    }
    
    private void connect() { // 连接套接字方法
        ta_result.append("尝试连接......\n"); // 文本域中信息信息
        try { // 捕捉异常
            socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
            while (true) {
                writer = new PrintWriter(socket.getOutputStream(), true);// 实例化PrintWriter对象
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // 实例化BufferedReader对象
                ta_result.append("完成连接。\n"); // 文本域中提示信息
                getServerInfo();// 调用方法读取服务器信息
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    private void getServerInfo() {
        try {
            while (true) { // 如果套接字是连接状态
                if (reader != null) {
                    String line = reader.readLine();// 读取服务器信息
                    if (line != null) {
                        ta_result.append("接收到服务器发送的信息： " + line + "\n"); // 获得服务器信息
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close(); // 关闭套接字
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Create the frame
     */
    public DatabaseClientFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("客户端程序");
        setBounds(100, 100, 277, 263);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JLabel label = new JLabel();
        label.setText("名  称：");
        label.setBounds(10, 12, 66, 18);
        getContentPane().add(label);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("年  龄：");
        label_1.setBounds(10, 38, 66, 18);
        getContentPane().add(label_1);
        
        tf_name = new JTextField();
        tf_name.setBounds(56, 10, 194, 22);
        getContentPane().add(tf_name);
        
        tf_age = new JTextField();
        tf_age.setBounds(56, 36, 194, 22);
        getContentPane().add(tf_age);
        
        final JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "显示服务器端的反馈信息",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, null, null));
        panel.setBounds(10, 91, 240, 124);
        getContentPane().add(panel);
        
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 21, 220, 93);
        panel.add(scrollPane);
        
        ta_result = new JTextArea();
        scrollPane.setViewportView(ta_result);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String name = tf_name.getText().trim();// 获得姓名
                String age = tf_age.getText().trim();// 获得年龄
                if (name == null || name.equals("") || age == null || age.equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名和年龄不能为空。");
                    return;
                }
                try {
                    Integer.parseInt(age);// 如果年龄不是数字就会发生异常
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "年龄必须为数字。");
                    return;
                }
                String info = name + ":data:" + age;// 使用字符串":data:"连接姓名和年龄
                writer.println(info);// 向服务器发送信息
            }
        });
        button.setText("保    存");
        button.setBounds(41, 62, 72, 23);
        getContentPane().add(button);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.setText("退    出");
        button_1.setBounds(148, 62, 72, 23);
        getContentPane().add(button_1);
        //
    }
    
}
