package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VireFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    LocalTableModel model = new LocalTableModel();
    GetFrame getFrame = new GetFrame();
    private  JComboBox nameComboBox;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VireFrame frame = new VireFrame();
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
    public VireFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 532, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("查看数据表结构");
        
        JLabel nameLabel = new JLabel("数据表：");
        nameLabel.setBounds(86, 39, 54, 15);
        contentPane.add(nameLabel);
        List list = getFrame.GetRs();
        String name[] = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            name[i] = list.get(i).toString();
        }
        nameComboBox  = new JComboBox(name);
            
        nameComboBox.setBounds(179, 36, 136, 21);
        contentPane.add(nameComboBox);
        
        JButton viewButton = new JButton("查看");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_viewButton_actionPerformed(arg0);
            }
        });
        viewButton.setBounds(362, 35, 93, 23);
        contentPane.add(viewButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 79, 496, 173);
        contentPane.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    //查看按钮的单击事件
    protected void do_viewButton_actionPerformed(ActionEvent arg0) {
       String name =  nameComboBox.getSelectedItem().toString();
       List list = getFrame.getMessage(name);
       model.setRowCount(0);
       for(int i = 0;i<list.size();i++){
           Student stu = (Student)list.get(i);
           model.addRow(new Object[] { stu.getId(), stu.getName(),stu.getLength(),
                    stu.getType(),stu.getDepict(),stu.getIfNull(),stu.getDigit(),stu.getAcquiescence() });
       }
    }
}
