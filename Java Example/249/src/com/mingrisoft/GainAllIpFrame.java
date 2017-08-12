package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author 张振坤
 * 获得内网的所有IP地址
 */
@SuppressWarnings("serial")
public class GainAllIpFrame extends JFrame {
    private JTextArea ta_allIp;
    static public Hashtable<String, String> pingMap; // 用于存储所ping的IP是否为内网IP的集合
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        GainAllIpFrame frame = new GainAllIpFrame();
        frame.setVisible(true);
    }
    
    public void gainAllIp() throws Exception {// 获得所有IP，并显示在文本域中的方法
        InetAddress host = InetAddress.getLocalHost();// 获得本机的InetAddress对象
        String hostAddress = host.getHostAddress();// 获得本机的IP地址
        int pos = hostAddress.lastIndexOf(".");// 获得IP地址中最后一个点的位置
        String wd = hostAddress.substring(0, pos + 1);// 对本机的IP进行截取，获得网段
        for (int i = 1; i <= 255; i++) { // 对局域网的IP地址进行遍历
            String ip = wd + i;// 生成IP地址
            PingIpThread thread = new PingIpThread(ip);// 创建线程对象
            thread.start();// 启动线程对象
        }
        Set<String> set = pingMap.keySet();// 获得集合中键的Set视图
        Iterator<String> it = set.iterator();// 获得迭代器对象
        while (it.hasNext()) { // 迭代器中有元素，则执行循环体
            String key = it.next(); // 获得下一个键的名称
            String value = pingMap.get(key);// 获得指定键的值
            if (value.equals("true")) {
                ta_allIp.append(key + "\n");// 追加显示IP地址
            }
        }
    }
    
    /**
     * Create the frame
     */
    public GainAllIpFrame() {
        super();
        addWindowListener(new WindowAdapter() {
            public void windowOpened(final WindowEvent e) {
                try {
                    gainAllIp();
                    ta_allIp.setText(null);
                } catch (Exception e1) {
                    ta_allIp.setText(null);
                }
            }
        });
        setTitle("获得内网的所有IP地址");
        setBounds(400, 200, 270, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_allIp = new JTextArea();
        scrollPane.setViewportView(ta_allIp);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        
        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    ta_allIp.setText(null);
                    gainAllIp();
                } catch (Exception e1) {
                    ta_allIp.setText(null);
                    JOptionPane.showMessageDialog(null, "应用程序异常，请再试一次。");
                }
            }
        });
        button_2.setText("显示所有IP");
        panel.add(button_2);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button.setText("退    出");
        panel.add(button);
        
        final JButton button_1 = new JButton();
        button_1.setText("New JButton");
        panel.add(button_1);
        pingMap = new Hashtable<String, String>();
    }
    
    class PingIpThread extends Thread {// 判断给定IP是否为内网IP的线程对象
        public String ip; // 表示IP地址的成员变量
        public PingIpThread(String ip) {// 参数为需要判断的IP地址
            this.ip = ip;
        }
        public void run() {
            try {
                // 获得所ping的IP进程，-w 280是等待每次回复的超时时间，-n 1是要发送的回显请求数
                Process process = Runtime.getRuntime().exec(
                        "ping " + ip + " -w 280 -n 1");
                InputStream is = process.getInputStream();// 获得进程的输入流对象
                InputStreamReader isr = new InputStreamReader(is);// 创建InputStreamReader对象
                BufferedReader in = new BufferedReader(isr);// 创建缓冲字符流对象
                String line = in.readLine();// 读取信息
                while (line != null) {
                    if (line != null && !line.equals("")) {
                        if (line.substring(0, 2).equals("来自")
                                || (line.length() > 10 && line.substring(0, 10)
                                        .equals("Reply from"))) {// 判断是ping通过的IP地址
                            pingMap.put(ip, "true");// 向集合中添加IP
                        }
                    }
                    line = in.readLine();// 再读取信息
                }
            } catch (IOException e) {
            }
        }
    }
}
