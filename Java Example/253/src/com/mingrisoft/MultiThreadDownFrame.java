package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MultiThreadDownFrame extends JFrame {
    private JTextField tf_address;
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MultiThreadDownFrame frame = new MultiThreadDownFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public MultiThreadDownFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("网络资源的多线程下载");
        setBounds(100, 100, 482, 189);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JButton button = new JButton();
        button.setBounds(10, 95, 106, 28);
        getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    String address = tf_address.getText();// 获得网络资源地址
                    download(address, "c:\\01.flv", 2);// 调用download()方法,将下载的网络资源保存到磁盘
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button.setText("下    载");
        
        final JLabel label = new JLabel();
        label.setText("网络资源的地址：");
        label.setBounds(10, 44, 106, 18);
        getContentPane().add(label);
        
        tf_address = new JTextField();
        tf_address.setBounds(114, 42, 341, 22);
        getContentPane().add(tf_address);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                tf_address.setText(null);
            }
        });
        button_1.setText("清    空");
        button_1.setBounds(179, 95, 106, 28);
        getContentPane().add(button_1);
        
        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button_2.setText("退    出");
        button_2.setBounds(349, 95, 106, 28);
        getContentPane().add(button_2);
    }
    
    public void download(String url, String dest, int threadNum)
            throws Exception {
        URL downURL = new URL(url);// 创建网络资源的URL
        HttpURLConnection conn = (HttpURLConnection) downURL.openConnection();// 打开网络边接
        long fileLength = -1;// 用于存储文件长度的变量
        int stateFlagCode = conn.getResponseCode();// 获得连接状态标记代码
        if (stateFlagCode == 200) {// 网络连接正常
            fileLength = conn.getContentLength();// 获得文件的长度
            conn.disconnect();// 取消网络连接
        }
        if (fileLength > 0) {
            long byteCounts = fileLength / threadNum + 1;// 计算每个线程的字节数
            File file = new File(dest);// 创建目标文件的File对象
            int i = 0;
            while (i < threadNum) {
                long startPosition = byteCounts * i;// 定义开始位置
                long endPosition = byteCounts * (i + 1);// 定义结束位置
                if (i == threadNum - 1) {
                    DownMultiThread fileThread = new DownMultiThread(url, file,
                            startPosition, 0);// 创建DownMultiThread线程的实例
                    new Thread(fileThread).start();// 启动线程对象
                } else {
                    DownMultiThread fileThread = new DownMultiThread(url, file,
                            startPosition, endPosition);// 创建DownMultiThread线程的实例
                    new Thread(fileThread).start();// 启动线程对象
                }
                i++;
            }
            JOptionPane.showMessageDialog(null, "完成网络资源的下载。");
        }
    }
}
