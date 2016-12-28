package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BreakPointSuperveneFrame extends JFrame {
    private JTextField tf_totalLength;
    private JTextField tf_residuaryLength;
    private JTextField tf_readToPos;
    private JTextField tf_address;
    private JTextField tf_endPos;
    private JTextField tf_startPos;
    private String urlAddress = "";// 用于存储网络资源的地址
    private long totalLength = 0;// 存储网络资源的大小，以字节为单位
    private long readToPos = 0;// 存储上次读取到的位置
    private long residuaryLength = 0;// 存储未读内容的大小
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BreakPointSuperveneFrame frame = new BreakPointSuperveneFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame
     */
    public BreakPointSuperveneFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("下载网络资源的断点续传");
        setBounds(100, 100, 514, 238);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tf_startPos = new JTextField();
        tf_startPos.setBounds(80, 165, 113, 22);
        getContentPane().add(tf_startPos);
        
        final JLabel label = new JLabel();
        label.setText("起始位置：");
        label.setBounds(10, 167, 74, 18);
        getContentPane().add(label);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("结束位置：");
        label_1.setBounds(199, 167, 74, 18);
        getContentPane().add(label_1);
        
        tf_endPos = new JTextField();
        tf_endPos.setBounds(267, 165, 117, 22);
        getContentPane().add(tf_endPos);
        
        final JLabel label_2 = new JLabel();
        label_2.setText("网络资源的地址：");
        label_2.setBounds(10, 52, 113, 18);
        getContentPane().add(label_2);
        
        tf_address = new JTextField();
        tf_address.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    urlAddress = tf_address.getText().trim();
                    URL url = new URL(urlAddress);// 获得网络资源的URL
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();// 获得连接对象
                    connection.connect();// 连接网络资源
                    totalLength = connection.getContentLength();// 获得网络资源的长度
                    connection.disconnect();// 断开连接
                    tf_totalLength.setText(String.valueOf(totalLength));// 显示总长度
                    tf_readToPos.setText("0");// 显示上次读取到的位置
                    residuaryLength = totalLength;// 未读内容为文件总长度
                    tf_residuaryLength.setText(String.valueOf(residuaryLength));// 显示未读内容
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                
            }
        });
        tf_address.setBounds(119, 50, 365, 22);
        getContentPane().add(tf_address);
        
        final JLabel label_3 = new JLabel();
        label_3.setForeground(new Color(0, 0, 255));
        label_3.setFont(new Font("", Font.BOLD, 14));
        label_3.setText("输入网络资源的地址并回车，可以获得网络资源的大小。");
        label_3.setBounds(10, 10, 384, 22);
        getContentPane().add(label_3);
        
        final JLabel label_4 = new JLabel();
        label_4.setForeground(new Color(128, 0, 0));
        label_4.setText("网络资源的大小为");
        label_4.setBounds(10, 76, 113, 38);
        getContentPane().add(label_4);
        
        final JLabel label_5 = new JLabel();
        label_5.setText("上次读取到");
        label_5.setBounds(10, 123, 74, 18);
        getContentPane().add(label_5);
        
        tf_readToPos = new JTextField();
        tf_readToPos.setBounds(80, 121, 113, 22);
        tf_readToPos.setEnabled(false);
        getContentPane().add(tf_readToPos);
        
        final JLabel label_6 = new JLabel();
        label_6.setText("字节处，还剩");
        label_6.setBounds(202, 123, 87, 18);
        getContentPane().add(label_6);
        
        tf_residuaryLength = new JTextField();
        tf_residuaryLength.setBounds(285, 120, 117, 22);
        tf_residuaryLength.setEnabled(false);
        getContentPane().add(tf_residuaryLength);
        
        final JLabel label_7 = new JLabel();
        label_7.setText("字节未读。");
        label_7.setBounds(404, 123, 80, 18);
        getContentPane().add(label_7);
        
        final JLabel label_4_1 = new JLabel();
        label_4_1.setForeground(new Color(128, 0, 0));
        label_4_1.setText("个字节。");
        label_4_1.setBounds(404, 76, 80, 38);
        getContentPane().add(label_4_1);
        
        tf_totalLength = new JTextField();
        tf_totalLength.setBounds(119, 84, 283, 22);
        tf_totalLength.setEnabled(false);
        getContentPane().add(tf_totalLength);
        
        final JButton button = new JButton();
        button.setBounds(395, 162, 89, 28);
        getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (totalLength == 0) {
                    JOptionPane.showMessageDialog(null,
                            "没有网络资源。\n\n请输入正确的网址，然后回车。");
                    return;
                }
                long startPos = 0;// 起始位置
                long endPos = 0;// 结束位置
                try {
                    startPos = Long.parseLong(tf_startPos.getText().trim());// 起始位置
                    endPos = Long.parseLong(tf_endPos.getText().trim());// 结束位置
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "输入的起始位置或结束位置不正确。");
                    return;
                }
                readToPos = endPos;// 记录读取到的位置
                residuaryLength = totalLength - readToPos;// 记录未读内容的大小
                tf_readToPos.setText(String.valueOf(readToPos));// 显示读取到的位置
                tf_residuaryLength.setText(String.valueOf(residuaryLength));// 显示未读字节数
                tf_startPos.setText(String.valueOf(readToPos));// 设置下一个读取点的开始位置
                tf_endPos.setText(String.valueOf(totalLength));// 设置下一个读取点的结束位置
                tf_endPos.requestFocus();// 使结束位置文本框获得焦点
                tf_endPos.selectAll();// 选择结束位置文本框中的全部内容，方便输入结束位置值
                download(startPos, endPos);// 调用方法进行下载
            }
        });
        button.setText("开始下载");
    }
    
    public void download(long startPosition, long endPosition) {
        try {
            URL url = new URL(urlAddress);// 获得网络资源的URL
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();// 获得连接对象
            connection.setRequestProperty("User-Agent", "NetFox");// 设置请求属性
            String rangeProperty = "bytes=" + startPosition + "-";// 定义请求范围属性
            if (endPosition > 0) {
                rangeProperty += endPosition;// 调整请求范围属性
            }
            connection.setRequestProperty("RANGE", rangeProperty);// 设置请求范围属性
            connection.connect();// 连接网络资源
            InputStream in = connection.getInputStream();// 获得输入流对象
            String file = url.getFile();// 获得文件对象
            String name = file.substring(file.lastIndexOf('/') + 1);// 获得文件名
            FileOutputStream out = new FileOutputStream("c:/" + name, true);// 创建输出流对象,保存下载的资源
            byte[] buff = new byte[2048];// 创建字节数组
            int len = 0;// 定义存储读取内容长度的变量
            len = in.read(buff);// 读取内容
            while (len != -1) {
                out.write(buff, 0, len);// 写入磁盘
                len = in.read(buff);// 读取内容
            }
            out.close();// 关闭流
            in.close();// 关闭流
            connection.disconnect();// 断开连接
            if (readToPos > 0 && readToPos == totalLength) {
                JOptionPane.showMessageDialog(null, "完成网络资源的下载。\n单击“确定”按钮退出程序。");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
