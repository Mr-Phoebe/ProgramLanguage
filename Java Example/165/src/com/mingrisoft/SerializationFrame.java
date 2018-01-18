package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SerializationFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 9037418437879471072L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private File selectFile;
    private TestFrame frame;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SerializationFrame frame = new SerializationFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public SerializationFrame() {
        setTitle("\u628A\u7A97\u4F53\u538B\u7F29\u6210ZIP\u6587\u4EF6");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                do_this_windowOpened(arg0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel);
        
        chooseTextField = new JTextField();
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(10);
        
        JButton chooseButton = new JButton("\u9009\u62E9\u6587\u4EF6\u5939");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel panel = new JPanel();
        contentPane.add(panel);
        
        JButton serializeButton = new JButton("\u5E8F\u5217\u5316");
        serializeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_serializeButton_actionPerformed(arg0);
            }
        });
        panel.add(serializeButton);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectFile = fileChooser.getSelectedFile();
            chooseTextField.setText(selectFile.getAbsolutePath());
        }
    }
    
    protected void do_serializeButton_actionPerformed(ActionEvent arg0) {
        try {
            zipSerializationObject(frame, selectFile);
            JOptionPane.showMessageDialog(this, "完成序列化");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void do_this_windowOpened(WindowEvent arg0) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new TestFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void zipSerializationObject(Object object, File path) throws IOException {
        File serializeFile = new File(path + "serialization.dat");// 根据用户选择的路径创建文件
        FileOutputStream fos = new FileOutputStream(serializeFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);// 将对象写入到创建的DAT文件
        oos.close();// 释放资源
        fos.close();
        
        File zipFile = new File(path + "serialization.zip");// 创建压缩文件
        fos = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);
        byte[] buffer = new byte[1024];
        ZipEntry entry = new ZipEntry(serializeFile.getName());
        FileInputStream fis = new FileInputStream(serializeFile);
        zos.putNextEntry(entry);
        int read = 0;
        while ((read = fis.read(buffer)) != -1) {
            zos.write(buffer, 0, read);// 写入压缩文件
        }
        zos.closeEntry();
        fis.close();// 释放资源
        zos.close();
        fos.close();
        serializeFile.delete();// 删除创建的DAT文件
    }
    
}
