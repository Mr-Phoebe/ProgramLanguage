package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IndexFileFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 2008614713725440868L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JComboBox comboBox;
    private JProgressBar progressBar;
    private JTextArea textArea;
    private File chooseFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IndexFileFrame frame = new IndexFileFrame();
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
    public IndexFileFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);

        chooseTextField = new JTextField();
        chooseTextField.setText("\u9009\u62E9\u4FDD\u5B58\u78C1\u76D8\u7D22\u5F15\u7684\u6587\u4EF6");
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(18);

        JButton chooseButton = new JButton("\u9009\u62E9\u6587\u4EF6");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);

        JPanel Panel = new JPanel();
        contentPane.add(Panel, BorderLayout.SOUTH);

        comboBox = new JComboBox();
        comboBox.setMaximumRowCount(8);
        Panel.add(comboBox);

        File[] files = File.listRoots();
        for (File file : files) {
            if (file.isDirectory()) {
                comboBox.addItem(file);
            }
        }
        comboBox.setSelectedIndex(0);

        JButton createButton = new JButton("\u521B\u5EFA\u7D22\u5F15");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_createButton_actionPerformed(arg0);
            }
        });
        Panel.add(createButton);

        progressBar = new JProgressBar();
        Panel.add(progressBar);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("文本文件", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chooseFile = fileChooser.getSelectedFile();
            chooseTextField.setText(chooseFile.getAbsolutePath());
        }
    }

    protected void do_createButton_actionPerformed(ActionEvent arg0) {
        if (chooseFile == null) {
            JOptionPane.showMessageDialog(this, "请选择保存索引的文件", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String disc = comboBox.getSelectedItem().toString();// 获得用户选择的磁盘
        final List<String> list = new ArrayList<String>();// 用list保存索引
        final File rootFile = new File(disc);// 利用用户选择的磁盘创建File对象
        final StringBuilder sb = new StringBuilder();// 利用StringBuilder对象保存写入的索引
        progressBar.setIndeterminate(true);// 设置滚动条开始滚动
        new Thread() {// 在一个新的线程中处理创建索引和写入索引的操作
            @Override
            public void run() {
                getFilePath(list, rootFile);// 获得磁盘上所有文件的路径
                Iterator<String> iterator = list.iterator();// 创建迭代器
                while (iterator.hasNext()) {// 遍历list
                    sb.append(iterator.next());
                    sb.append("\r\n");
                    try {
                        Thread.sleep(100);// 线程休眠0.1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textArea.setText(sb.toString());// 在文本域中显示文件路径
                }
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(chooseFile);
                    fileWriter.write(textArea.getText());// 向用户选择的文本文件写入数据
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                progressBar.setIndeterminate(false);// 停止进度条的滚动
                JOptionPane.showMessageDialog(null, "索引创建成功");// 提示用户索引创建成功
            };
        }.start();
    }

    private static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();
        if (files == null)
            return list;
        for (File file : files) {
            if (file.isDirectory()) {
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", "/"));
            }
        }
        return list;
    }

}
