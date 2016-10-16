package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ComminuteFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 2547743180459668116L;
    private JPanel contentPane;
    private JTextField sourceTextField;
    private JTextField sizeTextField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ComminuteFrame frame = new ComminuteFrame();
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
    public ComminuteFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 211);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("文件分割");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 414, 181);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel messagelabel = new JLabel("源文件：");
        messagelabel.setBounds(47, 41, 54, 20);
        panel.add(messagelabel);

        sourceTextField = new JTextField();
        sourceTextField.setBounds(105, 41, 178, 21);
        panel.add(sourceTextField);
        sourceTextField.setColumns(10);

        JButton sourceButton = new JButton("选择");
        sourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                do_sourceButton_actionPerformed(arg0);
            }
        });
        sourceButton.setBounds(303, 40, 67, 23);
        panel.add(sourceButton);

        JLabel sizelabel = new JLabel("分割大小：");
        sizelabel.setBounds(34, 86, 67, 15);
        panel.add(sizelabel);

        sizeTextField = new JTextField();
        sizeTextField.setBounds(105, 83, 178, 21);
        panel.add(sizeTextField);
        sizeTextField.setColumns(10);
        sizeTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) { // 某键按下时调用的方法
                char ch = event.getKeyChar(); // 获取用户键入的字符
                if ((ch < '0' || ch > '9')) { // 如果用户输入的信息不为数字或小数
                    event.consume(); // 不允许用户键入
                }

            }
        });

        JLabel lblM = new JLabel("M");
        lblM.setBounds(313, 86, 44, 15);
        panel.add(lblM);

        JButton cominButton = new JButton("分割");
        cominButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                do_cominButton_actionPerformed(arg0);
            }
        });
        cominButton.setBounds(101, 138, 93, 23);
        panel.add(cominButton);

        JButton close = new JButton("退出");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                do_close_actionPerformed(arg0);
            }
        });
        close.setBounds(229, 138, 93, 23);
        panel.add(close);
    }

    protected void do_sourceButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        String path = fd.getDirectory() + fd.getFile();
        if (!path.equals("") && !(path == null)) {
            sourceTextField.setText(path);
        }
    }

    protected void do_cominButton_actionPerformed(ActionEvent arg0) {
        ComminuteUtil util = new ComminuteUtil();
        String path = sourceTextField.getText();
        int size = Integer.parseInt(sizeTextField.getText());
        String subPath = path.substring(0, path.lastIndexOf("\\"));
        util.fenGe(new File(path), new File(subPath), size);
        JOptionPane.showMessageDialog(getContentPane(), "文件分割成功！", "信息提示框", JOptionPane.PLAIN_MESSAGE);
    }

    protected void do_close_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
