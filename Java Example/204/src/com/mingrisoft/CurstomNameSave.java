package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class CurstomNameSave extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8760640967260226648L;
    private JTextArea textArea;
    private JLabel label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CurstomNameSave frame = new CurstomNameSave();
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
    public CurstomNameSave() {
        setTitle("\u4E3A\u4FDD\u5B58\u5BF9\u8BDD\u6846\u8BBE\u7F6E\u9ED8\u8BA4\u6587\u4EF6\u540D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("\u6587\u4EF6");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("\u65B0\u5EFA\u6587\u6863");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_actionPerformed(e);
            }
        });
        menu.add(menuItem);
        
        JMenuItem menuItem_2 = new JMenuItem("\u9000\u51FA");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_2_actionPerformed(e);
            }
        });
        menu.add(menuItem_2);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setTabSize(4);
        ;
        textArea.setEnabled(false);
        scrollPane.setViewportView(textArea);
        
        label = new JLabel("\u65B0\u5EFA\u6587\u6863");
        contentPane.add(label, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("\u4FDD\u5B58");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
    }
    
    protected void do_menuItem_actionPerformed(ActionEvent e) {
        // 接收用户输入
        String string = JOptionPane.showInputDialog("请输入新建文档名称");
        if (string == null)
            return;
        label.setText(string);// 用标签控件显示用户输入的稳定名称
        textArea.setEnabled(true);// 激活文本域控件
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = label.getText();// 获取标签控件保存的文档民初
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        File file = new File(text + ".txt");// 用文档名称创建文件对象
        chooser.setSelectedFile(file);// 设置文件选择器的选择文件
        chooser.showSaveDialog(this);// 显示保存对话框
        File selectedFile = chooser.getSelectedFile();
        JOptionPane.showMessageDialog(this, "文件保存路径：\n" + selectedFile);
    }
    
    protected void do_menuItem_2_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
