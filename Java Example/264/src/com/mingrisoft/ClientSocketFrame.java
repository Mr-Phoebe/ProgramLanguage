package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ClientSocketFrame extends JFrame {
    private Image sendImg = null; // 声明图像对象
    private Image receiveImg = null; // 声明图像对象
    private SendImagePanel sendImagePanel = null; // 声明图像面板对象
    private ReceiveImagePanel receiveImagePanel = null; // 声明图像面板对象
    private File imgFile = null;// 声明所选择图片的File对象
    private JTextField tf_path;
    private DataInputStream in = null; // 创建流对象
    private DataOutputStream out = null; // 创建流对象
    private Socket socket; // 声明Socket对象
    private Container cc; // 声明Container对象
    private long lengths = -1;// 图片文件的大小
    
    private void connect() { // 连接套接字方法
        try { // 捕捉异常
            socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
            while (true) {
                if (socket != null && !socket.isClosed()) {
                    out = new DataOutputStream(socket.getOutputStream());// 获得输出流对象
                    in = new DataInputStream(socket.getInputStream());// 获得输入流对象
                    getServerInfo();// 调用getServerInfo()方法
                } else {
                    socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    public static void main(String[] args) { // 主方法
        ClientSocketFrame clien = new ClientSocketFrame(); // 创建本例对象
        clien.setVisible(true); // 将窗体显示
        clien.connect(); // 调用连接方法
    }
    
    private void getServerInfo() {
        try {
            long lengths = in.readLong();// 读取图片文件的长度
            byte[] bt = new byte[(int) lengths];// 创建字节数组
            for (int i = 0; i < bt.length; i++) {
                bt[i] = in.readByte();// 读取字节信息并存储到字节数组
            }
            receiveImg = new ImageIcon(bt).getImage();// 创建图像对象
            receiveImagePanel.repaint();// 重新绘制图像
        } catch (Exception e) {
        } finally {
            try {
                if (in != null) {
                    in.close();// 关闭流
                }
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
    public ClientSocketFrame() {
        super();
        setTitle("客户端程序");
        setBounds(100, 100, 373, 257);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        
        final JLabel label = new JLabel();
        label.setText("路径：");
        panel.add(label);
        
        tf_path = new JTextField();
        tf_path.setPreferredSize(new Dimension(140, 25));
        panel.add(tf_path);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();// 创建文件选择器
                FileFilter filter = new FileNameExtensionFilter(
                        "图像文件（JPG/GIF/BMP)", "JPG", "JPEG", "GIF", "BMP");// 创建过滤器
                fileChooser.setFileFilter(filter);// 设置过滤器
                int flag = fileChooser.showOpenDialog(null);// 显示打开对话框
                if (flag == JFileChooser.APPROVE_OPTION) {
                    imgFile = fileChooser.getSelectedFile(); // 获取选中图片的File对象
                }
                if (imgFile != null) {
                    tf_path.setText(imgFile.getAbsolutePath());// 图片完整路径
                    try {
                        sendImg = ImageIO.read(imgFile);// 构造BufferedImage对象
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                sendImagePanel.repaint();// 调用paint()方法
            }
        });
        button.setText("选择图片");
        panel.add(button);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    DataInputStream inStream = null;// 定义数据输入流对象
                    if (imgFile != null) {
                        lengths = imgFile.length();// 获得选择图片的大小
                        inStream = new DataInputStream(new FileInputStream(
                                imgFile));// 创建输入流对象
                    } else {
                        JOptionPane.showMessageDialog(null, "还没有选择图片文件。");
                        return;
                    }
                    out.writeLong(lengths);// 将文件的大小写入输出流
                    byte[] bt = new byte[(int) lengths];// 创建字节数组
                    int len = -1;
                    while ((len = inStream.read(bt)) != -1) {// 将图片文件读取到字节数组
                        out.write(bt);// 将字节数组写入输出流
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        button_1.setText("发  送");
        panel.add(button_1);
        
        final JPanel panel_1 = new JPanel();
        panel_1.setLayout(new BorderLayout());
        getContentPane().add(panel_1, BorderLayout.CENTER);
        
        final JPanel panel_2 = new JPanel();
        panel_2.setLayout(new GridLayout(1, 0));
        panel_1.add(panel_2, BorderLayout.NORTH);
        
        final JLabel label_1 = new JLabel();
        label_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        label_1.setText("客户端选择的要发送的图片");
        panel_2.add(label_1);
        
        final JLabel label_2 = new JLabel();
        label_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        label_2.setText("接收到服务器端发送的图片     ");
        panel_2.add(label_2);
        
        final JPanel imgPanel = new JPanel();
        sendImagePanel = new SendImagePanel();
        receiveImagePanel = new ReceiveImagePanel();
        imgPanel.add(sendImagePanel);
        imgPanel.add(receiveImagePanel);
        final GridLayout gridLayout = new GridLayout(1, 0);
        gridLayout.setVgap(6);
        imgPanel.setLayout(gridLayout);
        panel_1.add(imgPanel, BorderLayout.CENTER);
        //
    }
    
    // 创建面板类
    class SendImagePanel extends JPanel {
        public void paint(Graphics g) {
            if (sendImg != null) {
                g.clearRect(0, 0, this.getWidth(), this.getHeight());// 清除绘图上下文的内容
                g.drawImage(sendImg, 0, 0, this.getWidth(), this.getHeight(),
                        this);// 绘制指定大小的图片
            }
        }
    }
    
    // 创建面板类
    class ReceiveImagePanel extends JPanel {
        public void paint(Graphics g) {
            if (receiveImg != null) {
                g.clearRect(0, 0, this.getWidth(), this.getHeight());// 清除绘图上下文的内容
                g.drawImage(receiveImg, 0, 0, this.getWidth(),
                        this.getHeight(), this);// 绘制指定大小的图片
            }
        }
    }
}
