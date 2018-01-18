package com.mingrisoft;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RarAnnotate extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -7145152842194908145L;
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextArea annotateArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RarAnnotate frame = new RarAnnotate();
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
    public RarAnnotate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblrar = new JLabel("\u3000\u9009\u62E9RAR\u6587\u6863\uFF1A");
        panel.add(lblrar, BorderLayout.WEST);

        JButton browseButton = new JButton("\u6D4F\u89C8");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_browseButton_actionPerformed(e);
            }
        });
        panel.add(browseButton, BorderLayout.EAST);

        rarFileField = new JTextField();
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(25);
        contentPane.add(panel_1, BorderLayout.SOUTH);

        JButton annotateButton = new JButton("\u6DFB\u52A0/\u4FEE\u6539");
        annotateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_annotateButton_actionPerformed(e);
            }
        });
        panel_1.add(annotateButton);

        JButton closeButton = new JButton("\u5173\u95ED");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "\u6CE8\u91CA\u6587\u6863\uFF1A",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        annotateArea = new JTextArea();
        annotateArea.setLineWrap(true);
        scrollPane.setViewportView(annotateArea);
    }

    /**
     * 浏览按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_browseButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileFilter(new FileNameExtensionFilter("RAR文档", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(this);// 显示文件打开对话框
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 获取选择的rar文件
        rarFileField.setText(rarFile.toString());// 显示rar文件到文本框
        try {
            // 创建临时文件
            File tempFile = File.createTempFile("rar", ".txt");
            // 执行提取注释命令，把注释信息保存在临时文件中
            Process process = getRuntime().exec("rar cw \"" + rarFile + "\" \"" + tempFile + "\" -y");
            process.getOutputStream().close();// 关闭进程输出流
            Scanner sc = new Scanner(process.getInputStream());
            while (sc.hasNext()) {
                sc.nextLine();// 清空输入流
            }
            process.getInputStream().close();// 关闭输入流
            annotateArea.setText("");// 情况文本域内容
            Scanner scan = new Scanner(tempFile);// 创建读取临时文件的扫描器
            while (scan.hasNext()) {
                // 把注释信息显示到文本域控件中
                annotateArea.append(scan.next() + "\n");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 关闭按钮的事件监听器
     * 
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    /**
     * 添加修改按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_annotateButton_actionPerformed(ActionEvent e) {
        String annotateStr = annotateArea.getText();// 获取注释文本
        int length = annotateStr.getBytes().length;// 获取注释文本长度
        if (length > 32767) {// 限制文本长度
            JOptionPane.showMessageDialog(null, "注释长度不能大于32767");
            return;
        }
        try {
            Process process = getRuntime().exec(// 执行添加注释命令
                    "rar c \"" + rarFile + "\"");
            // 把注释文本传递给注释命令
            process.getOutputStream().write(annotateStr.getBytes());
            process.getOutputStream().close();// 关闭输出流
            process.getInputStream().close();// 关闭输入流
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
