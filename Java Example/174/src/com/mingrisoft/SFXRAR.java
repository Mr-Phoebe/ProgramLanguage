package com.mingrisoft;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SFXRAR extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 132068340261296319L;
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextArea infoArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SFXRAR frame = new SFXRAR();
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
    public SFXRAR() {
        setTitle("\u4ECERAR\u538B\u7F29\u5305\u4E2D\u5220\u9664\u6587\u4EF6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 226);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(15, 10, 506, 33);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(5, 5));

        JLabel lblrar = new JLabel("\u3000\u9009\u62E9RAR\u6587\u6863\uFF1A");
        panel.add(lblrar, BorderLayout.WEST);

        JButton browseButton = new JButton("\u6D4F\u89C8");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_renameButton_actionPerformed(e);
            }
        });
        panel.add(browseButton, BorderLayout.EAST);

        rarFileField = new JTextField();
        rarFileField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(15, 147, 506, 33);
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(30);
        contentPane.add(panel_1);

        JButton createButton = new JButton("\u521B\u5EFA");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_createButton_actionPerformed(e);
            }
        });
        panel_1.add(createButton);

        JButton closeButton = new JButton("\u5173\u95ED");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 51, 506, 86);
        contentPane.add(scrollPane);

        infoArea = new JTextArea();
        scrollPane.setViewportView(infoArea);
    }

    /**
     * 浏览按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_renameButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setFileFilter(new FileNameExtensionFilter("RAR文档", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(this);// 显示文件打开对话框
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 获取选择的rar文件
        rarFileField.setText(rarFile.toString());// 显示rar文件到文本框
    }

    /**
     * 关闭按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        dispose();
    }

    /**
     * 创建按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_createButton_actionPerformed(ActionEvent e) {
        if (rarFile == null)// 验证用户是否选择了rar文件
            return;
        try {
            // 执行rar命令
            Process process = getRuntime().exec("rar s -y -c- " + rarFile);
            Scanner scan = new Scanner(process.getInputStream());
            infoArea.setText("");// 情况文本域控件的内容
            int count = 0;
            while (scan.hasNext()) {// 遍历进程执行结果
                String line = scan.nextLine();// 获取单行信息
                if (line.isEmpty())
                    count++;
                if (count < 2)// 过滤非查询结果
                    continue;
                infoArea.append(line + "\n");// 查询结果添加到文本域控件
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
