package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class AddressList extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1533432567332718336L;
    private JTextField phonetextField; // 创建文本框组件
    private JTextField emailtextField;
    private JTextField nametextField;
    final JPanel panel = new JPanel(); // 创建面板组件
    JMenu fileMenu; // 定义菜单对象
    JMenuItem reveal;
    JMenuItem kinescope;
    JPanel jPanel = new JPanel();
    File file = new File("D://addressList.txt"); // 创建文件对象

    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddressList frame = new AddressList(); // 创建本类对象
                    frame.setVisible(true); // 设置窗体可视状态
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public AddressList() { // 构造方法中实现窗体布局
        super();
        setTitle("个人通讯录"); // 设置窗体标题
        getContentPane().setLayout(null); // 设置窗体布局
        setBounds(100, 100, 382, 237);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        fileMenu = new JMenu("文件");
        reveal = new JMenuItem("显示");
        kinescope = new JMenuItem("录入");
        reveal.addActionListener(this);
        kinescope.addActionListener(this);
        this.setJMenuBar(bar);
        bar.add(fileMenu);
        fileMenu.add(reveal);
        fileMenu.add(kinescope);

        panel.setLayout(null);
        panel.setBounds(0, 0, 374, 178);
        getContentPane().add(panel);

        final JLabel namelabel = new JLabel();
        namelabel.setBounds(77, 29, 66, 18);
        namelabel.setText("输入姓名：");
        panel.add(namelabel);

        nametextField = new JTextField();
        nametextField.setBounds(149, 27, 122, 22);
        panel.add(nametextField);

        final JLabel emaillabel = new JLabel();
        emaillabel.setBounds(77, 66, 66, 18);
        emaillabel.setText("输入Email:");
        panel.add(emaillabel);

        emailtextField = new JTextField();
        emailtextField.setBounds(149, 64, 122, 22);
        panel.add(emailtextField);

        final JLabel phonelabel = new JLabel();
        phonelabel.setText("输入电话：");
        phonelabel.setBounds(77, 103, 66, 18);
        panel.add(phonelabel);

        phonetextField = new JTextField();
        phonetextField.setBounds(149, 101, 122, 22);
        panel.add(phonetextField);

        final JLabel label = new JLabel();
        label.setText("单击录入：");
        label.setBounds(77, 137, 66, 18);
        panel.add(label);

        final JButton kinbutton = new JButton();
        kinbutton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                kinbuttonActionPerformed(e);

            }
        });
        kinbutton.setText("录入");
        kinbutton.setBounds(149, 132, 122, 28);
        panel.add(kinbutton);
    }

    private void kinbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (nametextField.getText().equals("") || (emailtextField.getText().equals("")) || (phonetextField.getText().equals(""))) { // 如果用户没有将信息输入完整
                JOptionPane.showMessageDialog(this, "请输入完整内容", "信息提示框", JOptionPane.WARNING_MESSAGE); // 给出提示信息
                return; // 退出程序
            }
            if (!file.exists()) // 如果文件不存在
                file.createNewFile(); // 新建文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true))); // 创建BufferedWriter对象
            out.write("姓名：" + nametextField.getText() + "， "); // 向文件中写内容
            out.write("邮箱：" + emailtextField.getText() + "， ");
            out.write("电话：" + phonetextField.getText());
            out.newLine(); // 新建一行
            out.close(); // 关闭流
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reveal) { // 如果用户单击的是显示菜单项
            try {
                getContentPane().remove(panel);
                jPanel.setLayout(null); // 设置窗体布局
                jPanel.setBounds(0, 0, 374, 178);
                JTextArea jtextarea = new JTextArea(20, 10); // 创建文本域对象
                jtextarea.setBounds(0, 0, 374, 178); // 设置文本域显示位置与大小
                getContentPane().add(jPanel); // 窗体中添加面板
                jPanel.add(jtextarea); // 向面板中添加文本域
                BufferedReader in = new BufferedReader(new FileReader(file)); // 创建BufferedReader
                                                                              // 对象
                String name = null;
                int number = 1;
                while ((name = in.readLine()) != null) { // 循环从文件中读数据
                    jtextarea.append("\n" + number + "、 " + name); // 将读取数据显示在文本域中
                    name = new String(name);
                    number++;
                }
                in.close();
                repaint();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == kinescope) { // 如果用户单击录入菜单项
            getContentPane().remove(jPanel); // 将面板移除窗体
            getContentPane().add(panel);
            repaint(); // 窗体重绘
        }
    }
}
