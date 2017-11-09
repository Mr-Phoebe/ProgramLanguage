package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CopyFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    private CopyDate copyDate = new CopyDate();
    private  JComboBox idComboBox ;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CopyFrame frame = new CopyFrame();
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
    public CopyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("将数据从一张表复制到另一张表");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLlabel = new JLabel("编号：");
        messageLlabel.setBounds(79, 34, 54, 15);
        panel.add(messageLlabel);
  
        List list = copyDate.getExcellenceStu();
        Object [] ids = new Object[list.size()];
        for(int i = 0;i< list.size();i++){
            ExcellenceStu stu = (ExcellenceStu)list.get(i);
            ids[i] = stu.getId();
            model.addRow(new Object[]{stu.getId(),stu.getName(),stu.getSex(),stu.getSpecialty(),stu.getGrade()});
        }
        idComboBox  = new JComboBox(ids);        
        idComboBox.setBounds(143, 31, 71, 21);
        panel.add(idComboBox);
        
        JButton insertButton = new JButton("添加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(263, 30, 71, 23);
        panel.add(insertButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(48, 82, 324, 136);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    //添加按钮的单击处理事件
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        System.out.println(idComboBox.getSelectedItem());
        int id = Integer.parseInt(idComboBox.getSelectedItem().toString());
        copyDate.insertStu(id);
        JOptionPane.showMessageDialog(getContentPane(), 
                "已经将该生添加到优秀学生信息表tb_excellenceStu中！", "信息提示框", JOptionPane.WARNING_MESSAGE);

    }
}
