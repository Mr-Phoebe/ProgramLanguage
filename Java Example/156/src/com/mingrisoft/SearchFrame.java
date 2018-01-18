package com.mingrisoft;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SearchFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5432640926699761559L;
    private JPanel contentPane;
    private JTextField pathTextField;
    private JTextField nameTextField;
    private JComboBox postfixComboBox;
    private DefaultListModel model = new DefaultListModel();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchFrame frame = new SearchFrame();
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
    public SearchFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("在指定范围内搜索文件");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel pathLabel = new JLabel("文件地址：");
        pathLabel.setBounds(24, 33, 75, 15);
        panel.add(pathLabel);
        
        pathTextField = new JTextField();
        pathTextField.setBounds(108, 30, 196, 21);
        panel.add(pathTextField);
        pathTextField.setColumns(10);
        
        JButton chooserButton = new JButton("选择地址");
        chooserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooserButton_actionPerformed(arg0);
            }
        });
        chooserButton.setBounds(326, 29, 98, 23);
        panel.add(chooserButton);
        
        JLabel nameLabel = new JLabel(" 文件名 ：");
        nameLabel.setBounds(36, 85, 63, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(108, 82, 108, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel postfixLabel = new JLabel("后缀：");
        postfixLabel.setBounds(226, 85, 52, 15);
        panel.add(postfixLabel);
        String postfix[] = { ".txt", ".doc", ".gif", ".jpg", ".bp3" };
        postfixComboBox = new JComboBox(postfix);
        postfixComboBox.setBounds(288, 82, 63, 21);
        panel.add(postfixComboBox);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(36, 136, 371, 116);
        panel.add(scrollPane);
        
        JList resultList = new JList(model);
        scrollPane.setViewportView(resultList);
        
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_searchButton_actionPerformed(arg0);
            }
        });
        searchButton.setBounds(361, 81, 63, 23);
        panel.add(searchButton);
    }
    
    // 定义获取只可以选择文件夹的选择框
    public JFileChooser getChooser() {
        JFileChooser fd = new JFileChooser();
        String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(windows);
        } catch (Exception e) {
            e.printStackTrace();
        }// 设置见面风格
        SwingUtilities.updateComponentTreeUI(fd);// 使设置的界面风格生效
        fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // 指示只显示目录
        fd.showOpenDialog(this);
        return fd;
    }
    
    //定义选择文件按钮的单击处理事件
    protected void do_chooserButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fd = getChooser();
        if ((fd.getSelectedFile() != null)
                && (!fd.getSelectedFile().equals(""))) {
            String strPath = fd.getSelectedFile().getPath();
            pathTextField.setText(strPath);
        }
    }
    //定义确定搜索按钮的单击处理事件
    @SuppressWarnings("rawtypes")
    protected void do_searchButton_actionPerformed(ActionEvent arg0) {
        FileSearch search = new FileSearch();
        model.removeAllElements();
        String name = nameTextField.getText();
        if ((name != null) && (!name.equals(""))) {
            List list = search.findFiles(pathTextField.getText(), name
                    + postfixComboBox.getSelectedItem());
            for (int i = 0; i < list.size(); i++) {
                model.addElement(list.get(i));
            }
        }
        
    }
}
