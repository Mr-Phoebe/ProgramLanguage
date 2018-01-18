package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatServerFrame extends JFrame {
    private JTextArea ta_info;
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    private Hashtable<String, Socket> map = new Hashtable<String, Socket>();// 用于存储连接到服务器的用户和客户端套接字对象
    
    public void createSocket() {
        try {
            server = new ServerSocket(1982);// 创建服务器套接字对象
            while (true) {
                ta_info.append("等待新客户连接......\n");
                socket = server.accept();// 获得套接字对象
                ta_info.append("客户端连接成功。" + socket + "\n");
                new ServerThread(socket).start();// 创建并启动线程对象
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    class ServerThread extends Thread {
        Socket socket;
        public ServerThread(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                ObjectInputStream ins = new ObjectInputStream(socket
                        .getInputStream());
                while (true) {
                    Vector v = null;
                    try {
                        v = (Vector) ins.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (v != null && v.size() > 0) {
                        for (int i = 0; i < v.size(); i++) {
                            String info = (String) v.get(i);// 读取信息
                            String key = "";
                            if (info.startsWith("用户：")) {// 添加登录用户到客户端列表
                                key = info.substring(3, info.length());// 获得用户名并作为键使用
                                map.put(key, socket);// 添加键值对
                                Set<String> set = map.keySet();// 获得集合中所有键的Set视图
                                Iterator<String> keyIt = set.iterator();// 获得所有键的迭代器
                                while (keyIt.hasNext()) {
                                    String receiveKey = keyIt.next();// 获得表示接收信息的键
                                    Socket s = map.get(receiveKey);// 获得与该键对应的套接字对象
                                    PrintWriter out = new PrintWriter(s
                                            .getOutputStream(), true);// 创建输出流对象
                                    Iterator<String> keyIt1 = set.iterator();// 获得所有键的迭代器
                                    while (keyIt1.hasNext()) {
                                        String receiveKey1 = keyIt1.next();// 获得键，用于向客户端添加用户列表
                                        out.println(receiveKey1);// 发送信息
                                        out.flush();// 刷新输出缓冲区
                                    }
                                }
                            } else if (info.startsWith("退出：")) {
                                key = info.substring(3);// 获得退出用户的键
                                map.remove(key);// 添加键值对
                                Set<String> set = map.keySet();// 获得集合中所有键的Set视图
                                Iterator<String> keyIt = set.iterator();// 获得所有键的迭代器
                                while (keyIt.hasNext()) {
                                    String receiveKey = keyIt.next();// 获得表示接收信息的键
                                    Socket s = map.get(receiveKey);// 获得与该键对应的套接字对象
                                    PrintWriter out = new PrintWriter(s
                                            .getOutputStream(), true);// 创建输出流对象
                                    out.println("退出：" + key);// 发送信息
                                    out.flush();// 刷新输出缓冲区
                                }
                            } else {// 转发接收的消息
                                key = info.substring(info.indexOf("：发送给：") + 5,
                                        info.indexOf("：的信息是："));// 获得接收方的key值,即接收方的用户名
                                String sendUser = info.substring(0, info
                                        .indexOf("：发送给："));// 获得发送方的key值,即发送方的用户名
                                Set<String> set = map.keySet();// 获得集合中所有键的Set视图
                                Iterator<String> keyIt = set.iterator();// 获得所有键的迭代器
                                while (keyIt.hasNext()) {
                                    String receiveKey = keyIt.next();// 获得表示接收信息的键
                                    if (key.equals(receiveKey) && !sendUser.equals(receiveKey)) {// 与接受用户相同，但不是发送用户
                                        Socket s = map.get(receiveKey);// 获得与该键对应的套接字对象
                                        PrintWriter out = new PrintWriter(s.getOutputStream(), true);// 创建输出流对象
                                        out.println("MSG:" + info);// 发送信息
                                        out.flush();// 刷新输出缓冲区
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                ta_info.append(socket + "已经退出。\n");
            }
        }
    }
    
    public static void main(String args[]) {
        ChatServerFrame frame = new ChatServerFrame();
        frame.setVisible(true);
        frame.createSocket();
    }
    
    /**
     * Create the frame
     */
    public ChatServerFrame() {
        super();
        addWindowListener(new WindowAdapter() {
            public void windowIconified(final WindowEvent e) {
                setVisible(false);
            }
        });
        setTitle("聊天室服务器端");
        setBounds(100, 100, 385, 266);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        
        //托盘
        if (SystemTray.isSupported()){                                      // 判断是否支持系统托盘
            URL url=ChatServerFrame.class.getResource("server.png");          // 获取图片所在的URL
            ImageIcon icon = new ImageIcon(url);                            // 实例化图像对象
            Image image=icon.getImage();                                    // 获得Image对象
            TrayIcon trayIcon=new TrayIcon(image);                          // 创建托盘图标
            trayIcon.addMouseListener(new MouseAdapter(){                   // 为托盘添加鼠标适配器
                public void mouseClicked(MouseEvent e){                     // 鼠标事件
                    if (e.getClickCount()==2){                              // 判断是否双击了鼠标
                        showFrame();                                    // 调用方法显示窗体
                    }
                }
            });
            trayIcon.setToolTip("系统托盘");                                    // 添加工具提示文本
            PopupMenu popupMenu=new PopupMenu();                    // 创建弹出菜单
            MenuItem exit=new MenuItem("退出");                           // 创建菜单项
            exit.addActionListener(new ActionListener() {                   // 添加事件监听器
                public void actionPerformed(final ActionEvent arg0) {
                    System.exit(0);                                     // 退出系统
                }
            });
            popupMenu.add(exit);                                        // 为弹出菜单添加菜单项
            trayIcon.setPopupMenu(popupMenu);                           // 为托盘图标加弹出菜弹
            SystemTray systemTray=SystemTray.getSystemTray();           // 获得系统托盘对象
            try{
                systemTray.add(trayIcon);                               // 为系统托盘加托盘图标
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void showFrame(){
        this.setVisible(true);                                              // 显示窗体
        this.setState(Frame.NORMAL);
    }
}
