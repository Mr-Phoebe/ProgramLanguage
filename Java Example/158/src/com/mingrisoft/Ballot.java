package com.mingrisoft;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;

class Candidate extends JCheckBox { // 定义内容类，该类继承JCheckBox类
    /**
     * 
     */
    private static final long serialVersionUID = -5408876343113378593L;
    int len = 0;

    Candidate(String name, Icon icon) { // 该类包含有两个参数
        super(name, icon);
    }

    public int getBallot(String name) {
        File file = new File("D://count.txt"); // 创建文件对象
        FileReader fis;
        try {
            if (!file.exists()) // 如果该文件不存在
                file.createNewFile(); // 新建文件
            fis = new FileReader(file);
            BufferedReader bis = new BufferedReader(fis); // 创建BufferedReader对象
            String str[] = new String[3];
            String size;
            int i = 0;
            while ((size = bis.readLine()) != null) { // 循环读取文件内容
                str[i] = size.trim(); // 去除字符串中的空格
                if (str[i].startsWith(name)) {
                    int length = str[i].indexOf(":");
                    String sub = str[i].substring(length + 1, str[i].length()); // 对字符串进行截取
                    len = Integer.parseInt(sub);
                    continue;
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return len;
    }

    public void addBallot(String name) { // 定义增加选票方法
        File file = new File("D://count.txt"); // 创建文件对象
        FileReader fis;
        try {
            if (!file.exists()) // 如果该文件不存在
                file.createNewFile(); // 新建文件
            fis = new FileReader(file); // 对FileReader对象进行实例化
            BufferedReader bis = new BufferedReader(fis);
            String str[] = new String[3];
            String size;
            int i = 0;
            while ((size = bis.readLine()) != null) { // 循环读取文件
                str[i] = size.trim();
                if (str[i].startsWith(name)) {
                    int length = str[i].indexOf(":"); // 获取指定字符索引位置
                    String sub = str[i].substring(length + 1, str[i].length()); // 对字符串进行截取
                    len = Integer.parseInt(sub) + 1;
                    break;
                }
                i++;
            }
            FileWriter fw = new FileWriter(file); // 创建FileWriter 对象
            BufferedWriter bufw = new BufferedWriter(fw);
            bufw.write(name + ":" + len); // 向流中写数据

            bufw.close(); // 关闭流
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyMin extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 7341493970991277188L;
    Box baseBox, boxH, boxV; // 创建Box对象
    JTextArea text; // 创建JTextArea对象
    JButton button; // 创建JButton对象
    Candidate candidateOne, candidateTwo, candidateThree;

    public MyMin() { // 在构造方法中设置窗体布局
        setBounds(100, 100, 500, 120);
        setVisible(true);
        setTitle("选出你心中的好干部！！");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // 窗体关闭事件
                System.exit(0);
            }
        });
        baseBox = Box.createHorizontalBox();
        boxH = Box.createHorizontalBox();
        boxV = Box.createHorizontalBox();
        candidateOne = new Candidate("小兵", new ImageIcon("src/images/0.gif"));
        candidateTwo = new Candidate("小陈", new ImageIcon("src/images/1.gif"));
        candidateThree = new Candidate("小李", new ImageIcon("src/images/2.gif"));
        candidateOne.setSelectedIcon(new ImageIcon("src/images/0.gif"));
        candidateTwo.setSelectedIcon(new ImageIcon("src/images/1.gif"));
        candidateThree.setSelectedIcon(new ImageIcon("src/images/2.gif"));
        boxH.add(candidateOne);
        boxH.add(candidateTwo);
        boxH.add(candidateThree);
        text = new JTextArea();
        button = new JButton("显示得票数");
        button.addActionListener(this);
        boxV.add(text);
        boxV.add(button);
        boxV.add(boxH);
        baseBox.add(boxV);
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        con.add(baseBox);
        con.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText(null);
        File file = new File("D://count.txt"); // 创建文件对象
        if (!file.exists()) { // 如果该文件不存在
            try {
                file.createNewFile(); // 新建文件
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (candidateOne.isSelected()) {
            candidateOne.addBallot(candidateOne.getText());
        }
        if (candidateTwo.isSelected()) {
            candidateTwo.addBallot(candidateTwo.getText());
        }
        if (candidateThree.isSelected()) {
            candidateThree.addBallot(candidateThree.getText());
        }
        // 向文本框中追加信息
        text.append(candidateOne.getText() + ":" + candidateOne.getBallot(candidateOne.getText()) + "\n");
        text.append(candidateTwo.getText() + ":" + candidateTwo.getBallot(candidateTwo.getText()) + "\n");
        text.append(candidateThree.getText() + ":" + candidateThree.getBallot(candidateThree.getText()) + "\n");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file); // 创建FileWriter类对象
            BufferedWriter bufw = new BufferedWriter(fw); // 创建BufferedWriter类对象
            bufw.write(text.getText()); // 将字符串数组中元素写入到磁盘文件中
            bufw.close(); // 将BufferedWriter流关闭
            fw.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        candidateOne.setSelected(false);
        candidateTwo.setSelected(false);
        candidateThree.setSelected(false);
    }

}

public class Ballot {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MyMin();
    }
}
