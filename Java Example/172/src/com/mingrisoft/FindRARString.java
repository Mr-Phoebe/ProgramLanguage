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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FindRARString extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 2631969102249114205L;
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextField searchStringField;
    private JTextField extNameField;
    private ButtonGroup group;
    private JTextArea infoArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindRARString frame = new FindRARString();
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
    public FindRARString() {
        setTitle("\u5728\u538B\u7F29\u6587\u4EF6\u4E2D\u67E5\u627E\u5B57\u7B26\u4E32");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 508, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(5, 5));

        JLabel lblrar = new JLabel("\u9009\u62E9RAR\u6587\u6863\uFF1A");
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

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(5, 0));

        JLabel label = new JLabel("\u8F93\u5165\u641C\u7D22\u6587\u672C\uFF1A");
        panel_2.add(label, BorderLayout.WEST);

        searchStringField = new JTextField();
        panel_2.add(searchStringField, BorderLayout.CENTER);
        searchStringField.setColumns(10);

        JButton searchButton = new JButton("\u641C\u7D22");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_searchButton_actionPerformed(e);
            }
        });
        panel_2.add(searchButton, BorderLayout.EAST);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_2.add(panel_1, BorderLayout.SOUTH);

        JLabel label_1 = new JLabel("\u6307\u5B9A\u6269\u5C55\u540D\uFF1A");
        panel_1.add(label_1);

        extNameField = new JTextField();
        extNameField.setText("*.txt");
        panel_1.add(extNameField);
        extNameField.setColumns(10);

        JRadioButton radioButton1 = new JRadioButton("\u533A\u5206\u5927\u5C0F\u5199");
        radioButton1.setActionCommand("c");
        panel_1.add(radioButton1);

        JRadioButton radioButton2 = new JRadioButton("\u4E0D\u533A\u5206\u5927\u5C0F\u5199");
        radioButton2.setActionCommand("i");
        radioButton2.setSelected(true);
        panel_1.add(radioButton2);
        group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "\u538B\u7F29\u6587\u4EF6\u5217\u8868\uFF1A",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        infoArea = new JTextArea();
        scrollPane.setViewportView(infoArea);
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
    }

    /**
     * 搜索按钮的事件处理方法
     * 
     * @param e
     */
    protected void do_searchButton_actionPerformed(ActionEvent e) {
        String searchText = searchStringField.getText();
        if (searchText.isEmpty() || rarFile == null) {
            getToolkit().beep();// 发出提示声音
            return;
        }
        // 获取区分大小写的标记
        String arg = group.getSelection().getActionCommand();
        int count = 0;
        try {
            // 执行rar命令
            Process process = getRuntime().exec("rar i" + arg + "=\"" + searchText + "\" -c- \"" + rarFile + "\" " + extNameField.getText());
            // 获取进程的输入流扫描器
            Scanner scan = new Scanner(process.getInputStream());
            infoArea.setText("");
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
