package com.mingrisoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserProxyFrame extends JFrame {
    
    private JTextArea ta_show;
    private JTextField tf_accessAddress;
    private JTextField tf_proxyPort;
    private JTextField tf_proxyAddress;
    private Proxy proxy;// 定义代理
    private URL url;// 定义URL对象
    private URLConnection urlConn;// 定义连接对象
    private Scanner scanner;// 在网络中通过代理读取数据的扫描器
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        UserProxyFrame frame = new UserProxyFrame();
        frame.setVisible(true);
    }
    
    public void accessUrl(String proxyAddress, int proxyPort,
            String accessAddress) throws Exception {
        url = new URL(accessAddress);// 创建URL对象
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress,
                proxyPort));// 创建代理
        urlConn = url.openConnection(proxy);// 通过代理打开连接
        scanner = new Scanner(urlConn.getInputStream(), "UTF8");// 通过流创建扫描器
        ta_show.setText(null);// 清空文本域的内容
        StringBuffer sb = new StringBuffer();// 创建字符串缓存
        while (scanner.hasNextLine()) {// 判断扫描器是否有数据
            String line = scanner.nextLine();// 从扫描器获得一行数据
            sb.append(line + "\n");// 向字符串缓存添加信息
        }
        if (sb != null) {
            ta_show.append(sb.toString());// 在文本域中显示信息
        }
    }
    
    /**
     * Create the frame
     */
    public UserProxyFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("使用Proxy创建代理服务器");
        setBounds(100, 100, 448, 334);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JLabel label = new JLabel();
        label.setText("代理服务器的地址：");
        label.setBounds(10, 10, 129, 18);
        getContentPane().add(label);
        
        tf_proxyAddress = new JTextField();
        tf_proxyAddress.setBounds(145, 8, 277, 22);
        getContentPane().add(tf_proxyAddress);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("代理服务器的端口号：");
        label_1.setBounds(10, 38, 136, 18);
        getContentPane().add(label_1);
        
        tf_proxyPort = new JTextField();
        tf_proxyPort.setBounds(145, 36, 277, 22);
        getContentPane().add(tf_proxyPort);
        
        final JLabel label_2 = new JLabel();
        label_2.setText("输入要访问的网站网址，然后回车");
        label_2.setBounds(10, 65, 231, 18);
        getContentPane().add(label_2);
        
        tf_accessAddress = new JTextField();
        tf_accessAddress.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    String proxyAddress = tf_proxyAddress.getText().trim();// 代理服务器的地址
                    int proxyPort = Integer.parseInt(tf_proxyPort.getText().trim());// 代理服务器的端口
                    String accessAddress = tf_accessAddress.getText().trim();// 需要打开的网站网址
                    accessUrl(proxyAddress, proxyPort, accessAddress);// 调用方法，使用代理访问网站
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "输入的信息有误。");
                }
            }
        });
        tf_accessAddress.setBounds(10, 85, 412, 22);
        getContentPane().add(tf_accessAddress);
        
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 137, 412, 149);
        getContentPane().add(scrollPane);
        
        ta_show = new JTextArea();
        scrollPane.setViewportView(ta_show);
        
        final JLabel label_3 = new JLabel();
        label_3.setText("访问结果");
        label_3.setBounds(10, 113, 193, 18);
        getContentPane().add(label_3);
    }
    
}
