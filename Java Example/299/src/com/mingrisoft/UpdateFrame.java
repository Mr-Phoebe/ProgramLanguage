package com.mingrisoft;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UpdateFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField gradeTextField;
    private JTextField specialityTextField;
    private Stu stu = null;
    private  JComboBox sexComboBox;

    
    /**
     * Create the frame.
     */
    public UpdateFrame() {

        setBounds(100, 100, 409, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        File file = new File("file.txt");
     
        try {
            FileInputStream fin = new FileInputStream(file);
            int count =  fin.read();
            System.out.println(count);
            UpdateStu updateStu = new UpdateStu();
            stu = updateStu.selectStu(count);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 393, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel IDLabel = new JLabel("编号：");
        IDLabel.setBounds(55, 21, 54, 15);
        panel.add(IDLabel);
        
        idTextField = new JTextField();
        idTextField.setText(stu.getId()+"");
        idTextField.setEditable(false);
        idTextField.setBounds(101, 18, 216, 21);
        panel.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(55, 57, 48, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setText(stu.getName());
        nameTextField.setBounds(101, 54, 216, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel seLlabel = new JLabel("性别：");
        seLlabel.setBounds(55, 95, 54, 15);
        panel.add(seLlabel);
        String sex[] = new String[]{"男","女"};
        sexComboBox = new JComboBox(sex);
        sexComboBox.setSelectedItem(stu.getSex());
        sexComboBox.setBounds(101, 92, 67, 21);
        panel.add(sexComboBox);
        
        JLabel gradeLabel = new JLabel("年级：");
        gradeLabel.setBounds(55, 132, 54, 15);
        panel.add(gradeLabel);
        
        gradeTextField = new JTextField();
        gradeTextField.setText(stu.getGrade());
        gradeTextField.setBounds(101, 129, 216, 21);
        panel.add(gradeTextField);
        gradeTextField.setColumns(10);
        
        JLabel specialityLabel = new JLabel("专业：");
        specialityLabel.setBounds(55, 175, 54, 15);
        panel.add(specialityLabel);
        
        specialityTextField = new JTextField();
        specialityTextField.setText(stu.getSpecialty());
        specialityTextField.setBounds(102, 172, 215, 21);
        panel.add(specialityTextField);
        specialityTextField.setColumns(10);
        
        JButton updateButton = new JButton("修改");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_updateButton_actionPerformed(arg0);
            }
        });
        updateButton.setBounds(101, 214, 67, 23);
        panel.add(updateButton);
        
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(208, 214, 67, 23);
        panel.add(closeButton);
    }
    //修改按钮的单击事件
    protected void do_updateButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText();
        String sex = sexComboBox.getSelectedItem().toString();
        String grade = gradeTextField.getText();
        String speciality = specialityTextField.getText();
        stu.setName(name);
        stu.setSex(sex);
        stu.setGrade(grade);
        stu.setSpecialty(speciality);
        UpdateStu updateStu = new UpdateStu();
        updateStu.updateStu(stu);
        JOptionPane.showMessageDialog(getContentPane(), 
                "数据修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);

    }
    //关闭按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        this.setVisible(false);
    }
}
