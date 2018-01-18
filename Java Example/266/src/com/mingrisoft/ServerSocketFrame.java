package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ServerSocketFrame extends JFrame {
    private JTextArea ta_info;
    private File file = null;// 声明所选择图片的File对象
    private JTextField tf_path;
    private DataOutputStream out = null; // 创建流对象
    private DataInputStream in = null; // 创建流对象
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    private long lengths = -1; // 图片文件的大小
    private String fileName = null;
    
    public void getServer() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            ta_info.append("等待客户机的连接......\n"); // 输出信息
            socket = server.accept(); // 实例化Socket对象
            ta_info.append("客户机连接成功......\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                if (socket != null && !socket.isClosed()) {
                    out = new DataOutputStream(socket.getOutputStream());// 获得输出流对象
                    in = new DataInputStream(socket.getInputStream());// 获得输入流对象
                    getClientInfo(); // 调用getClientInfo()方法
                } else {
                    socket = server.accept(); // 实例化Socket对象
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    private void getClientInfo() {
        try {
            String name = in.readUTF();// 读取文件名
            long lengths = in.readLong();// 读取文件的长度
            byte[] bt = new byte[(int) lengths];// 创建字节数组
            for (int i = 0; i < bt.length; i++) {
                bt[i] = in.readByte();// 读取字节信息并存储到字节数组
            }
            FileDialog dialog = new FileDialog(ServerSocketFrame.this, "保存");// 创建对话框
            dialog.setMode(FileDialog.SAVE);// 设置对话框为保存对话框
            dialog.setFile(name);
            dialog.setVisible(true);// 显示保存对话框
            String path = dialog.getDirectory();// 获得文件的保存路径
            
            String newFileName = dialog.getFile();// 获得保存的文件名
            if (path == null || newFileName == null) {
                return;
            }
            String pathAndName = path + "\\" + newFileName;// 文件的完整路径
            FileOutputStream fOut = new FileOutputStream(pathAndName);
            fOut.write(bt);
            fOut.flush();
            fOut.close();
            ta_info.append("文件接收完毕。");
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
    
    public static void main(String[] args) { // 主方法
        ServerSocketFrame frame = new ServerSocketFrame(); // 创建本类对象
        frame.setVisible(true);
        frame.getServer(); // 调用方法
    }
    
    public ServerSocketFrame() {
        super();
        setTitle("服务器端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 260);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        
        final JLabel label = new JLabel();
        label.setText("路径：");
        panel.add(label);
        
        tf_path = new JTextField();
        tf_path.setPreferredSize(new Dimension(140, 25));
        panel.add(tf_path);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();// 创建文件选择器
                FileFilter filter = new FileNameExtensionFilter(
                        "视频文件（AVI/MPG/DAT/RM)", "AVI", "MPG", "DAT", "RM");// 创建过滤器
                fileChooser.setFileFilter(filter);// 设置过滤器
                int flag = fileChooser.showOpenDialog(null);// 显示打开对话框
                if (flag == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile(); // 获取选中视频文件的File对象
                }
                if (file != null) {
                    tf_path.setText(file.getAbsolutePath());// 视频文件的完整路径
                    fileName = file.getName();// 获得视频文件的名称
                }
            }
        });
        button_1.setText("选择视频");
        panel.add(button_1);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    DataInputStream inStream = null;// 定义数据输入流对象
                    if (file != null) {
                        lengths = file.length();// 获得所选择视频文件的大小
                        inStream = new DataInputStream(
                                new FileInputStream(file));// 创建输入流对象
                    } else {
                        JOptionPane.showMessageDialog(null, "还没有选择视频文件。");
                        return;
                    }
                    out.writeUTF(fileName);// 写入视频文件名
                    out.writeLong(lengths);// 将文件的大小写入输出流
                    byte[] bt = new byte[(int) lengths];// 创建字节数组
                    int len = -1;
                    while ((len = inStream.read(bt)) != -1) {// 将视频文件读取到字节数组
                        out.write(bt);// 将字节数组写入输出流
                    }
                    out.flush();
                    out.close();
                    ta_info.append("文件发送完毕。");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        button.setText("发  送");
        panel.add(button);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
    }
    
}
