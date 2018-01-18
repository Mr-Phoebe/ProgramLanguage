package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JRadioButtonTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7985880225039901522L;
    private JPanel contentPane;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JLabel label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JRadioButtonTest frame = new JRadioButtonTest();
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
    public JRadioButtonTest() {
        setTitle("\u5355\u9009\u6309\u94AE\u7684\u5E94\u7528");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(0, 1, 5, 5));
        
        radioButton1 = new JRadioButton("\u56FE\u72471");
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton1_actionPerformed(e);
            }
        });
        buttonPanel.add(radioButton1);
        
        radioButton2 = new JRadioButton("\u56FE\u72472");
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton2_actionPerformed(e);
            }
        });
        buttonPanel.add(radioButton2);
        
        radioButton3 = new JRadioButton("\u56FE\u72473");
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButton3_actionPerformed(e);
            }
        });
        buttonPanel.add(radioButton3);
        
        JPanel panel = new JPanel();
        contentPane.add(panel);
        
        label = new JLabel();
        panel.add(label);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
    }
    
    protected void do_radioButton1_actionPerformed(ActionEvent e) {
        if (radioButton1.isSelected()) {
            ImageIcon icon = new ImageIcon("src/com/mingrisoft/1.png");
            label.setIcon(icon);
        }
    }
    
    protected void do_radioButton2_actionPerformed(ActionEvent e) {
        if (radioButton2.isSelected()) {
            ImageIcon icon = new ImageIcon("src/com/mingrisoft/2.png");
            label.setIcon(icon);
        }
    }
    
    protected void do_radioButton3_actionPerformed(ActionEvent e) {
        if (radioButton3.isSelected()) {
            ImageIcon icon = new ImageIcon("src/com/mingrisoft/3.png");
            label.setIcon(icon);
        }
    }
}
