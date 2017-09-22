package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientFrame extends JFrame {
    private JTextField tf_newUser;
    private JList user_list;
    private JTextArea ta_info;
    private JTextField tf_send;
    private ObjectOutputStream out;// 声明输出流对象
    private boolean loginFlag = false;// 为true时表示已经登录，为false时表示未登录
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatClientFrame frame = new ChatClientFrame();
                    frame.setVisible(true);
                    frame.createClientSocket();// 调用方法创建套接字对象
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void createClientSocket() {
        try {
            Socket socket = new Socket("192.168.1.122", 1982);// 创建套接字对象
            out = new ObjectOutputStream(socket.getOutputStream());// 创建输出流对象
            new ClientThread(socket).start();// 创建并启动线程对象
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    class ClientThread extends Thread {
        Socket socket;
        public ClientThread(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));// 创建输入流对象
                DefaultComboBoxModel model = (DefaultComboBoxModel) user_list
                        .getModel();// 获得列表框的模型
                while (true) {
                    String info = in.readLine().trim();// 读取信息
                    if (!info.startsWith("MSG:")) {// 接收到的不是消息
                        if (info.startsWith("退出：")) {// 接收到的是退出消息
                            model.removeElement(info.substring(3));// 从用户列表中移除用户
                        } else {// 接收到的是登录用户
                            boolean itemFlag = false;// 标记是否为列表框添加列表项，为true不添加，为false添加
                            for (int i = 0; i < model.getSize(); i++) {// 对用户列表进行遍历
                                if (info.equals((String) model.getElementAt(i))) {// 如果用户列表中存在该用户名
                                    itemFlag = true;// 设置为true，表示不添加到用户列表
                                    break;// 结束for循环
                                }
                            }
                            if (!itemFlag) {
                                    model.addElement(info);// 将登录用户添加到用户列表
                            } 
                        }
                    } else {// 如果获得的是消息，则在文本域中显示接收到的消息
                        DateFormat df = DateFormat.getDateInstance();// 获得DateFormat实例
                        String dateString = df.format(new Date());         // 格式化为日期
                        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// 获得DateFormat实例
                        String timeString = df.format(new Date());         // 格式化为时间
                        String sendUser = info.substring(4,info.indexOf("：发送给："));// 获得发送信息的用户
                        String receiveInfo = info.substring(info.indexOf("：的信息是：")+6);// 获得接收到的信息
                        ta_info.append("  "+sendUser + "    " +dateString+"  "+timeString+"\n  "+receiveInfo+"\n");// 在文本域中显示信息
                        ta_info.setSelectionStart(ta_info.getText().length()-1);// 设置选择起始位置
                        ta_info.setSelectionEnd(ta_info.getText().length());// 设置选择的结束位置
                        tf_send.requestFocus();// 使发送信息文本框获得焦点
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void send() {
        if (!loginFlag) {
            JOptionPane.showMessageDialog(null, "请先登录。");
            return;// 如果用户没登录则返回
        }
        String sendUserName = tf_newUser.getText().trim();// 获得登录用户名
        String info = tf_send.getText();// 获得输入的发送信息
        if (info.equals("")) {
            return;// 如果没输入信息则返回，即不发送
        }
        Vector<String> v = new Vector<String>();// 创建向量对象，用于存储发送的消息
        Object[] receiveUserNames = user_list.getSelectedValues();// 获得选择的用户数组
        if (receiveUserNames.length <= 0) {
            return;// 如果没选择用户则返回
        }
        for (int i = 0; i < receiveUserNames.length; i++) {
            String msg = sendUserName + "：发送给：" + (String) receiveUserNames[i]
                    + "：的信息是： " + info;// 定义发送的信息
            v.add(msg);// 将信息添加到向量
        }
        try {
            out.writeObject(v);// 将向量写入输出流，完成信息的发送
            out.flush();// 刷新输出缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateFormat df = DateFormat.getDateInstance();// 获得DateFormat实例
        String dateString = df.format(new Date());         // 格式化为日期
        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// 获得DateFormat实例
        String timeString = df.format(new Date());         // 格式化为时间
        String sendUser = tf_newUser.getText().trim();// 获得发送信息的用户
        String receiveInfo = tf_send.getText().trim();// 显示发送的信息
        ta_info.append("  "+sendUser + "    " +dateString+"  "+timeString+"\n  "+receiveInfo+"\n");// 在文本域中显示信息
        tf_send.setText(null);// 清空文本框
        ta_info.setSelectionStart(ta_info.getText().length()-1);// 设置选择的起始位置
        ta_info.setSelectionEnd(ta_info.getText().length());// 设置选择的结束位置
        tf_send.requestFocus();// 使发送信息文本框获得焦点
    }
    
    /**
     * Create the frame
     */
    public ChatClientFrame() {
        super();
        setTitle("聊天室客户端");
        setBounds(100, 100, 385, 288);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        
        final JLabel label = new JLabel();
        label.setText("输入聊天内容：");
        panel.add(label);
        
        tf_send = new JTextField();
        tf_send.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                send();// 调用方法发送信息
            }
        });
        tf_send.setPreferredSize(new Dimension(180, 25));
        panel.add(tf_send);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                send();// 调用方法发送信息
            }
        });
        button.setText("发  送");
        panel.add(button);
        
        final JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(100);
        getContentPane().add(splitPane, BorderLayout.CENTER);
        
        final JScrollPane scrollPane = new JScrollPane();
        splitPane.setRightComponent(scrollPane);
        
        ta_info = new JTextArea();
        ta_info.setFont(new Font("", Font.BOLD, 14));
        scrollPane.setViewportView(ta_info);
        
        final JScrollPane scrollPane_1 = new JScrollPane();
        splitPane.setLeftComponent(scrollPane_1);
        
        user_list = new JList();
        user_list.setModel(new DefaultComboBoxModel(new String[] { "" }));
        scrollPane_1.setViewportView(user_list);
        
        final JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.NORTH);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("用户名称：");
        panel_1.add(label_1);
        
        tf_newUser = new JTextField();
        tf_newUser.setPreferredSize(new Dimension(140, 25));
        panel_1.add(tf_newUser);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (loginFlag) {// 已登录标记为true
                    JOptionPane.showMessageDialog(null, "在同一窗口只能登录一次。");
                    return;
                }
                String userName = tf_newUser.getText().trim();// 获得登录用户名
                Vector v = new Vector();// 定义向量，用于存储登录用户
                v.add("用户：" + userName);// 添加登录用户
                try {
                    out.writeObject(v);// 将用户向量发送到服务器
                    out.flush();// 刷新输出缓冲区
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                tf_newUser.setEnabled(false);// 禁用用户文本框
                loginFlag = true;// 将已登录标记设置为true
            }
        });
        button_1.setText("登  录");
        panel_1.add(button_1);

        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String exitUser = tf_newUser.getText().trim();
                Vector v = new Vector();
                v.add("退出：" + exitUser);
                try {
                    out.writeObject(v);
                    out.flush();// 刷新输出缓冲区
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);                                     // 退出系统
            }
        });
        button_2.setText("退  出");
        panel_1.add(button_2);
        //托盘
        if (SystemTray.isSupported()){                                      // 判断是否支持系统托盘
            URL url=ChatClientFrame.class.getResource("client.png");          // 获取图片所在的URL
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
                    String exitUser = tf_newUser.getText().trim();
                    Vector v = new Vector();
                    v.add("退出：" + exitUser);
                    try {
                        out.writeObject(v);
                        out.flush();// 刷新输出缓冲区
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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
