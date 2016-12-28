package com.mingrisoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProxySelectorFrame extends JFrame {
    
    private JTextArea ta_info;
    private JTextField tf_accessAddress;
    private JTextField tf_proxyAddress;
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        ProxySelectorFrame frame = new ProxySelectorFrame();
        frame.setVisible(true);
    }
    
    public void setProxyInfo(String proxyAddress) {
        Properties propperties = System.getProperties();// 获得系统属性对象
        propperties.setProperty("http.proxyHost", proxyAddress);// 设置HTTP服务使用的代理服务器地址
        propperties.setProperty("http.proxyPort", "80");// 设置HTTP服务使用的代理服务器端口
        propperties.setProperty("https.proxyHost", proxyAddress);// 设置安全HTTP服务使用的代理服务器地址
        propperties.setProperty("https.proxyPort", "443");// 设置安全HTTP服务使用的代理服务器端口
        propperties.setProperty("ftp.proxyHost", proxyAddress);// 设置FTP访问的代理服务器主机
        propperties.setProperty("ftp.proxyPort", "21");// 设置FTP访问的代理服务器端口
        propperties.setProperty("socks.ProxyHost", proxyAddress);// 设置socks代理服务器的地址
        propperties.setProperty("socks.ProxyPort", "1080");// 设置socks代理服务器的端口
    }
    
    public void removeProxyInfo() {
        Properties propperties = System.getProperties();// 获得系统属性对象
        propperties.remove("http.proxyHost");// 清除HTTP服务使用的代理服务器地址
        propperties.remove("http.proxyPort");// 清除HTTP服务使用的代理服务器端口
        propperties.remove("https.proxyHost");// 清除安全HTTP服务使用的代理服务器地址
        propperties.remove("https.proxyPort");// 清除安全HTTP服务使用的代理服务器端口
        propperties.remove("ftp.proxyHost");// 清除FTP访问的代理服务器主机
        propperties.remove("ftp.proxyPort");// 清除FTP访问的代理服务器端口
        propperties.remove("socksProxyHost");// 清除socks代理服务器的地址
        propperties.remove("socksProxyPort");// 清除socks代理服务器的端口
    }
    
    /**
     * 使用HTTP访问
     * @param accessAddress 需要访问的地址
     * @throws Exception 抛出异常
     */
    public void useHttpAccess(String accessAddress) throws Exception{
        URL url = new URL(accessAddress);// 创建URL对象
        URLConnection urlConn = url.openConnection(); // 自动调用系统设置的HTTP代理服务器，并打开连接
        Scanner scanner = new Scanner(urlConn.getInputStream(),"utf8");// 通过流创建扫描对象
        StringBuffer sb = new StringBuffer();// 创建字符器缓存
        while (scanner.hasNextLine()) {// 如果扫描器中有信息
            sb.append(scanner.nextLine()+"\n");// 读取代理服务器上的网页内容，并添加到字符串缓存中
        }
        if (sb!=null) {
            ta_info.append(sb.toString());// 显示网页内容
        }
    }
    
    /**
     * Create the frame
     */
    public ProxySelectorFrame() {
        super();
        setTitle("使用ProxySelector选择代理服务器");
        getContentPane().setLayout(null);
        setBounds(100, 100, 419, 309);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JLabel label = new JLabel();
        label.setText("请输入代理服务器地址：");
        label.setBounds(21, 21, 151, 18);
        getContentPane().add(label);
        
        tf_proxyAddress = new JTextField();
        tf_proxyAddress.setBounds(167, 19, 218, 22);
        getContentPane().add(tf_proxyAddress);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("输入要访问的网站网址，然后回车");
        label_1.setBounds(21, 45, 218, 18);
        getContentPane().add(label_1);
        
        tf_accessAddress = new JTextField();
        tf_accessAddress.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    String proxyAddress = tf_proxyAddress.getText().trim();// 代理服务器地址
                    setProxyInfo(proxyAddress);// 设置本地代理
                    String accessAddress = tf_accessAddress.getText().trim();// 获得需要访问的网址
                    useHttpAccess(accessAddress);// 调用方法，进行http访问
                    removeProxyInfo();// 清除本地代理
                } catch (Exception ex) {
                    
                }
            }
        });
        tf_accessAddress.setBounds(21, 69, 364, 22);
        getContentPane().add(tf_accessAddress);
        
        final JLabel label_2 = new JLabel();
        label_2.setText("访问结果");
        label_2.setBounds(21, 97, 75, 18);
        getContentPane().add(label_2);
        
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 121, 358, 140);
        getContentPane().add(scrollPane);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        //
    }
    

}
