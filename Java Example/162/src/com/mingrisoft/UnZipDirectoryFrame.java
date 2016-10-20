package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class UnZipDirectoryFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7178478435446172846L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTable table;
    private File zipFile;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UnZipDirectoryFrame frame = new UnZipDirectoryFrame();
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
    public UnZipDirectoryFrame() {
        setTitle("\u6DF1\u5C42\u6587\u4EF6\u5939\u538B\u7F29\u5305\u7684\u91CA\u653E");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        chooseTextField = new JTextField();
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(18);
        
        JButton chooseButton = new JButton("\u9009\u62E9\u538B\u7F29\u6587\u4EF6");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton unzipButton = new JButton("\u5F00\u59CB\u89E3\u538B\u7F29");
        unzipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_unzipButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(unzipButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("文本文件", "zip"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            zipFile = fileChooser.getSelectedFile();
            chooseTextField.setText(zipFile.getAbsolutePath());
        }
    }
    
    protected void do_unzipButton_actionPerformed(ActionEvent arg0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[] { "序号", "文件名" });
        List<String> list = new ArrayList<String>();
        try {
            unzip(zipFile, list);
            for (int i = 0; i < list.size(); i++) {
                model.addRow(new Object[] { i + 1, list.get(i) });
            }
            table.setModel(model);
            JOptionPane.showMessageDialog(this, "解压缩完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void unzip(File zipFile, List<String> list) throws IOException {
        // 利用用户选择的ZIP文件创建ZipInputStream对象
        ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry;
        while ((entry = in.getNextEntry()) != null) {// 遍历所有ZipEntry对象
            if (!entry.isDirectory()) {// 如果是文件则创建并写入
                File tempFile = new File(zipFile.getParent() + File.separator + entry.getName());
                list.add(tempFile.getName());// 增加文件名
                new File(tempFile.getParent()).mkdirs();// 创建文件夹
                tempFile.createNewFile();// 创建新文件
                FileOutputStream out = new FileOutputStream(tempFile);
                int b;
                while ((b = in.read()) != -1) {// 写入数据
                    out.write(b);
                }
                out.close();// 释放资源
            }
        }
        in.close();
    }
}
