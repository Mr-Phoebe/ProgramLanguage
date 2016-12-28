package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InternetContentFrame extends JFrame {
    
    private JTextArea ta_content;
    private JTextField tf_address;
    /**
     * Launch the application
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InternetContentFrame frame = new InternetContentFrame();
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
    public InternetContentFrame() {
        super();
        setTitle("解析网页中的内容");
        setBounds(100, 100, 484, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        final JLabel label = new JLabel();
        label.setText("输入网址：");
        panel.add(label);

        tf_address = new JTextField();
        tf_address.setPreferredSize(new Dimension(260,25));
        panel.add(tf_address);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String address = tf_address.getText().trim();// 获得输入的网址
                Collection urlCollection = getURLCollection(address);// 调用方法，获得网页内容的集合对象
                Iterator it = urlCollection.iterator();  // 获得集合的迭代器对象
                while(it.hasNext()){
                    ta_content.append((String)it.next()+"\n");       // 在文本域中显示解析的内容
                }
            }
        });
        button.setText("解析网页");
        panel.add(button);

        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        ta_content = new JTextArea();
        ta_content.setFont(new Font("", Font.BOLD, 14));
        scrollPane.setViewportView(ta_content);
        //
    }
    public Collection<String> getURLCollection(String urlString){
        URL url = null;                             // 声明URL
        URLConnection conn = null;                  // 声明URLConnection
        Collection<String> urlCollection = new ArrayList<String>(); // 创建集合对象
        try{
            url = new URL(urlString);               // 创建URL对象
            conn = url.openConnection();            // 获得连接对象
            conn.connect();                         // 打开到url引用资源的通信链接
            InputStream is = conn.getInputStream(); // 获取流对象
            InputStreamReader in = new InputStreamReader(is,"UTF-8"); // 转换为字符流
            BufferedReader br = new BufferedReader(in); // 创建缓冲流对象
            String nextLine = br.readLine();            // 读取信息，解析网页
            while (nextLine !=null){
                urlCollection.add(nextLine);   // 解析网页的全部内容，添加到集合中
                nextLine = br.readLine();      // 读取信息，解析网页
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return urlCollection;
    }

}
