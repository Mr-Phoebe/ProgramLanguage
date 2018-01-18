package com.mingrisoft;



import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class BallotUtilFrame extends JFrame {
    
    private JPanel contentPane;
    private BallotUtil util = new BallotUtil();
    private JTextField nameTextField;
    private  JComboBox typeComboBox;
    private  JComboBox deleteComboBox;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BallotUtilFrame frame = new BallotUtilFrame();
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
    public BallotUtilFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 427, 233);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 411, 195);
        contentPane.add(tabbedPane);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("添加字段", null, panel, null);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("字段名称：");
        nameLabel.setBounds(84, 22, 75, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(151, 19, 156, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel typeLabel = new JLabel("数据类型：");
        typeLabel.setBounds(84, 62, 75, 15);
        panel.add(typeLabel);
        String [] type = new String[]{"int","varchar(50)","datetime","float"};
        typeComboBox = new JComboBox(type);
        typeComboBox.setBounds(151, 59, 156, 21);
        panel.add(typeComboBox);
        
        JButton addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_addButton_actionPerformed(arg0);
            }
        });
        addButton.setBounds(151, 112, 93, 23);
        panel.add(addButton);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("删除字段", null, panel_1, null);
        panel_1.setLayout(null);
        
        JLabel deleteLabel = new JLabel("删除字段：");
        deleteLabel.setBounds(86, 23, 86, 15);
        panel_1.add(deleteLabel);
        List listName = util.getField();
        String[] name = new String[listName.size()];
        for(int i = 0;i<listName.size();i++){
           name[i] = listName.get(i).toString();           
        }
        deleteComboBox = new JComboBox(name);
        deleteComboBox.setBounds(166, 20, 97, 21);
        panel_1.add(deleteComboBox);
        
        JButton button = new JButton("删除");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(144, 117, 70, 23);
        panel_1.add(button);
        setTitle("动态维护投票数据库");
        List list = util.getField();
        String id[] = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            id[i] = list.get(i).toString();            
        }
    }
    //添加按钮的单击事件
    protected void do_addButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText();
        String type = typeComboBox.getSelectedItem().toString();
        util.addField(name, type);
        JOptionPane.showMessageDialog(getContentPane(), 
                "字段添加成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);

    }
    //删除按钮的单击事件
    protected void do_button_actionPerformed(ActionEvent arg0) {
        String name =  deleteComboBox.getSelectedItem().toString();
        util.deleteField(name);
        JOptionPane.showMessageDialog(getContentPane(), 
                "字段删除成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
    }
}
