package com.mingrisoft;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SingleThreadDownloadFrame extends JFrame {
    
    private JTextField tf_address;
    /**
     * Launch the application
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SingleThreadDownloadFrame frame = new SingleThreadDownloadFrame();
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
    public SingleThreadDownloadFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("网络资源的单线程下载");
        setBounds(100, 100, 500, 237);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setText("网络资源的网址：");
        label.setBounds(10, 88, 118, 18);
        getContentPane().add(label);

        tf_address = new JTextField();
        tf_address.setBounds(117, 86, 357, 22);
        getContentPane().add(tf_address);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String address = tf_address.getText().trim();// 获得网址
                download(address);  // 下载文件
            }
        });
        button.setText("单击开始下载");
        button.setBounds(41, 144, 145, 28);
        getContentPane().add(button);

        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                tf_address.setText(null);// 清除文本框内容
                tf_address.requestFocus();// 文本框获得焦点
            }
        });
        button_1.setText("清    空");
        button_1.setBounds(204, 144, 106, 28);
        getContentPane().add(button_1);

        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button_2.setText("退    出");
        button_2.setBounds(328, 144, 106, 28);
        getContentPane().add(button_2);

        final JLabel label_1 = new JLabel();
        label_1.setForeground(new Color(0, 0, 255));
        label_1.setFont(new Font("", Font.BOLD, 24));
        label_1.setText("网络资源的单线程下载");
        label_1.setBounds(117, 21, 301, 48);
        getContentPane().add(label_1);
    }
    public void download(String urlAddr){         // 从指定网址下载文件
        try {
            URL url = new URL(urlAddr);    // 创建URL对象
            URLConnection urlConn = url.openConnection();  // 获得连接对象
            urlConn.connect();                           // 打开到url引用资源的通信链接
            InputStream in = urlConn.getInputStream() ;      // 获得输入流对象
            String filePath = url.getFile();                  // 获得完整路径
            int pos = filePath.lastIndexOf("/");              // 获得路径中最后一个斜杠的位置
            String fileName = filePath.substring(pos+1);      // 截取文件名
            FileOutputStream out = new FileOutputStream("C:/"+fileName);  // 创建输出流对象
            byte[] bytes = new byte[1024];                 // 声明存放下载内容的字节数组
            int len = in.read(bytes);                       // 从输入流中读取内容
            while (len != -1){
                out.write(bytes,0,len);                     // 将读取的内容写到输出流
                len = in.read(bytes);                      // 继续从输入流中读取内容
            }
            out.close();          // 关闭输出流
            in.close();           // 关闭输入流
            JOptionPane.showMessageDialog(null, "下载完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
