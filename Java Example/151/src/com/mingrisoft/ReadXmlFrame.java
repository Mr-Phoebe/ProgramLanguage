package com.mingrisoft;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReadXmlFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -1297399552701564382L;
    private JPanel contentPane;
    private JTextField classNameTextField;
    private JTextField urlTextField;
    private JTextField userNameTextField;
    private JTextField passWordTextField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReadXmlFrame frame = new ReadXmlFrame();
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
    public ReadXmlFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 273);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("从XML文件中读取内容");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 245);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel classNameLabel = new JLabel("驱动代码：");
        classNameLabel.setBounds(48, 49, 74, 15);
        panel.add(classNameLabel);

        classNameTextField = new JTextField();
        ReadXMLDataBase readXml = new ReadXMLDataBase();
        classNameTextField.setBounds(132, 46, 238, 21);
        classNameTextField.setText(readXml.readXml("className"));
        panel.add(classNameTextField);
        classNameTextField.setColumns(10);

        JLabel urlLabel = new JLabel(" URL ：");
        urlLabel.setBounds(66, 90, 54, 15);
        panel.add(urlLabel);

        urlTextField = new JTextField();
        urlTextField.setText(readXml.readXml("url"));
        urlTextField.setBounds(132, 87, 238, 21);
        panel.add(urlTextField);
        urlTextField.setColumns(10);

        JLabel userNameLabel = new JLabel("用户名：");
        userNameLabel.setBounds(66, 127, 54, 15);

        panel.add(userNameLabel);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(132, 124, 238, 21);
        userNameTextField.setText(readXml.readXml("userName"));
        panel.add(userNameTextField);
        userNameTextField.setColumns(10);

        JLabel passWordLabel = new JLabel("密 码 ：");
        passWordLabel.setBounds(66, 171, 54, 15);
        panel.add(passWordLabel);

        passWordTextField = new JTextField();
        passWordTextField.setBounds(132, 168, 238, 21);
        passWordTextField.setText(readXml.readXml("passWord"));
        panel.add(passWordTextField);
        passWordTextField.setColumns(10);
    }

}
