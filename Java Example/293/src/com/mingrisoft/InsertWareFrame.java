package com.mingrisoft;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
public class InsertWareFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField specTextField;
    private JTextField casingTextField;
    private JTextField unitTextField;
    private JTextField amountTextField;
    private WareUtil util = new WareUtil();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertWareFrame frame = new InsertWareFrame();
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
    public InsertWareFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 373, 324);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("添加商品信息");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 358, 292);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("名称：");
        nameLabel.setBounds(57, 31, 54, 15);
        panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(108, 28, 184, 21);
        panel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel specLabel = new JLabel("规格：");
        specLabel.setBounds(57, 70, 54, 15);
        panel.add(specLabel);
        
        specTextField = new JTextField();
        specTextField.setBounds(108, 67, 184, 21);
        panel.add(specTextField);
        specTextField.setColumns(10);
        
        JLabel casingLabel = new JLabel("包装：");
        casingLabel.setBounds(57, 111, 54, 15);
        panel.add(casingLabel);
        
        casingTextField = new JTextField();
        casingTextField.setColumns(10);
        casingTextField.setBounds(108, 108, 184, 21);
        panel.add(casingTextField);
        
        JLabel unitLabel = new JLabel("单位：");
        unitLabel.setBounds(57, 150, 54, 15);
        panel.add(unitLabel);
        
        unitTextField = new JTextField();
        unitTextField.setBounds(107, 147, 185, 21);
        panel.add(unitTextField);
        unitTextField.setColumns(10);
        
        JLabel amountLabel = new JLabel("数量：");
        amountLabel.setBounds(57, 191, 54, 15);
        panel.add(amountLabel);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(108, 188, 184, 21);
        panel.add(amountTextField);
        amountTextField.setColumns(10);
        
        JButton insertButton = new JButton("添加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(86, 230, 65, 23);
        panel.add(insertButton);
        
        JButton watchButton = new JButton("查看");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_watchButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(201, 230, 65, 23);
        panel.add(watchButton);
    }
    
    // 添加按钮的单击处理事件
    
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        String name = nameTextField.getText(); // 获取用户添加的商品名称
        String spec = specTextField.getText(); // 获取用户添加的商品规格
        String unit = unitTextField.getText(); // 获取用户添加的商品单位
        String casing = casingTextField.getText(); // 获取用户添加的商品包装
        int count = Integer.parseInt(amountTextField.getText()); // 获取用户添加的商品数量
        int ID = 0;
        String sDate = WareUtil.getDateTime(); // 调用获取系统时间方法
        List list = util.selectWare(); // 获取商品表中全部的商品
        String sid = "";
        for (int i = 0; i < list.size(); i++) { // 循环遍历查询结果集
            Ware ware = (Ware) list.get(i); // 获取商品
            sid = ware.getSID(); // 获取商品编号
        }
        if (list.size() == 0) { // 如果商品集合中为空
            sid = "CS" + sDate.replace("-", "") + "00001"; // 定义商品编号
        } else { // 如果商品集合不为空
            sid = sid.trim();
            ID = Integer.parseInt(sid.substring(sid.length() - 5)); // 截取商品编号中的后五位
            sid = sid.substring(0, sid.length() - 5)
                    + String.format("%05d", ID + 1); // 定义商品编号
        }
        Ware ware = new Ware(); // 定义与商品表对应的JavaBean对象
        ware.setSID(sid); // 设置JavaBean编号
        ware.setsName(name);
        ware.setSpec(spec);
        ware.setUnit(unit);
        ware.setsDate(sDate);
        ware.setCasing(casing);
        ware.setAmout(count);
        util.insertWare(ware); // 添加商品信息
        JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！", "信息提示框",
                JOptionPane.CANCEL_OPTION);
        
    }
    
    // 查看按钮的单击处理事件
    protected void do_watchButton_actionPerformed(ActionEvent arg0) {
        SelectWareFrame selectWare = new SelectWareFrame();
        selectWare.setVisible(true);
    }
}
