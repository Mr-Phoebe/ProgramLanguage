package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
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

public class ClientSocketFrame extends JFrame {
    private JTextArea ta_info;
    private File file = null;// 声明所选择图片的File对象
    private JTextField tf_path;
    private DataInputStream in = null; // 创建流对象
    private DataOutputStream out = null; // 创建流对象
    private Socket socket; // 声明Socket对象
    private long lengths = -1;// 图片文件的大小
    private String fileName = null;
    
    private void connect() { // 连接套接字方法
        ta_info.append("尝试连接......\n"); // 文本域中信息信息
        try { // 捕捉异常
            socket = new Socket("192.168.1.122", 1978); // 实例化Socket对象
            ta_info.append("完成连接。\n"); // 文本域中提示信息
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
            String name = in.readUTF();// 读取文件名
            long lengths = in.readLong();// 读取文件的长度
            byte[] bt = new byte[(int) lengths];// 创建字节数组
            for (int i = 0; i < bt.length; i++) {
                bt[i] = in.readByte();// 读取字节信息并存储到字节数组
            }
            FileDialog dialog = new FileDialog(ClientSocketFrame.this, "保存");// 创建对话框
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
            ta_info.append("文件接收完毕。\n");
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
        tf_path.setPreferredSize(new Dimension(140,25));
        panel.add(tf_path);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();// 创建文件选择器
                FileFilter filter = new FileNameExtensionFilter("音频文件（WAV/MIDI/MP3/AU)", "WAV", "MID", "MP3", "AU");// 创建过滤器
                fileChooser.setFileFilter(filter);// 设置过滤器
                int flag = fileChooser.showOpenDialog(null);// 显示打开对话框
                if (flag == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile(); // 获取选中音频文件的File对象
                }
                if (file != null) {
                    tf_path.setText(file.getAbsolutePath());// 音频文件的完整路径
                    fileName = file.getName();// 获得音频文件的名称
                }
            }
        });
        button.setText("选择音频");
        panel.add(button);

        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    DataInputStream inStream = null;// 定义数据输入流对象
                    if (file != null) {
                        lengths = file.length();// 获得所选择音频文件的大小
                        inStream = new DataInputStream(new FileInputStream(file));// 创建输入流对象
                    } else {
                        JOptionPane.showMessageDialog(null, "还没有选择音频文件。");
                        return;
                    }
                    out.writeUTF(fileName);// 写入音频文件名
                    out.writeLong(lengths);// 将文件的大小写入输出流
                    byte[] bt = new byte[(int) lengths];// 创建字节数组
                    int len = -1;// 用于存储读取到的字节数
                    while ((len = inStream.read(bt)) != -1) {// 将音频文件读取到字节数组
                        out.write(bt);// 将字节数组写入输出流
                    }
                    out.flush();// 更新输出流对象
                    out.close();// 关闭输出流对象
                    ta_info.append("文件发送完毕。\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        button_1.setText("发  送");
        panel.add(button_1);

        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        //
    }
}
