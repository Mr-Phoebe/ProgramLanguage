package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubjoinFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField dataTxtField;
    private JTextField logTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SubjoinFrame frame = new SubjoinFrame();
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
    public SubjoinFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 240);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("附加数据库");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 205);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("数据库名称：");
        nameLabel.setBounds(54, 32, 83, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(134, 29, 180, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel databasLlabel = new JLabel("数据库文件地址：");
        databasLlabel.setBounds(28, 72, 115, 15);
        panel.add(databasLlabel);
        
        dataTxtField = new JTextField();
        dataTxtField.setBounds(134, 69, 180, 21);
        panel.add(dataTxtField);
        dataTxtField.setColumns(10);
        
        JLabel logLabel = new JLabel("日志文件地址：");
        logLabel.setBounds(42, 117, 95, 15);
        panel.add(logLabel);
        
        logTextField = new JTextField();
        logTextField.setBounds(134, 114, 180, 21);
        panel.add(logTextField);
        logTextField.setColumns(10);
        
        JButton brownButton = new JButton("浏览");
        brownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_brownButton_actionPerformed(arg0);
            }
        });
        brownButton.setBounds(331, 68, 69, 23);
        panel.add(brownButton);
        
        JButton logBrowButton = new JButton("浏览");
        logBrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_logBrowButton_actionPerformed(arg0);
            }
        });
        logBrowButton.setBounds(331, 113, 69, 23);
        panel.add(logBrowButton);
        
        JButton subjoinButton = new JButton("附加数据库");
        subjoinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_subjoinButton_actionPerformed(arg0);
            }
        });
        subjoinButton.setBounds(167, 157, 115, 23);
        panel.add(subjoinButton);
    }
    
    // 浏览数据库文件按钮单击事件
    protected void do_brownButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory() + fd.getFile();
        if (filePath.endsWith(".MDF")) {
            dataTxtField.setText(filePath);
        }
    }
    
    // 浏览数据库日志文件按钮单击事件
    protected void do_logBrowButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory() + fd.getFile();
        if (filePath.endsWith(".LDF")) {
            logTextField.setText(filePath);
        }
    }
    
    // 附加数据库按钮单击事件
    protected void do_subjoinButton_actionPerformed(ActionEvent arg0) {
        String namePath = nameTextField.getText();
        String dataName = dataTxtField.getText();
        String logFile = logTextField.getText();
        if ((!namePath.equals("")) && (!dataName.equals(""))
                && (!logFile.equals(""))) {
            SubjoinDate userDao = new SubjoinDate();
            userDao.executeUpdate(namePath, dataName, logFile);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "数据附加成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
