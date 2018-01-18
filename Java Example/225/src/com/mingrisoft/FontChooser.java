package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontChooser extends JFrame {
    
    private static final long serialVersionUID = -560821100423371891L;
    private JPanel contentPane;
    private JCheckBoxMenuItem bold;
    private JCheckBoxMenuItem italic;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JRadioButtonMenuItem radioButtonMenuItem3;
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
                    FontChooser frame = new FontChooser();
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
    public FontChooser() {
        setTitle("\u590D\u9009\u6846\u4E0E\u5355\u9009\u6309\u94AE\u83DC\u5355\u9879");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu1 = new JMenu("\u590D\u9009\u6846\u6309\u94AE\u9879");
        menu1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(menu1);
        
        bold = new JCheckBoxMenuItem("\u52A0\u7C97");
        bold.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        bold.addActionListener(listener);
        menu1.add(bold);
        
        italic = new JCheckBoxMenuItem("\u659C\u4F53");
        italic.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        italic.addActionListener(listener);
        menu1.add(italic);
        
        JMenu menu2 = new JMenu("\u5355\u9009\u6309\u94AE\u83DC\u5355\u9879");
        menu2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menuBar.add(menu2);
        
        radioButtonMenuItem1 = new JRadioButtonMenuItem("\u534E\u6587\u96B6\u4E66");
        radioButtonMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButtonMenuItem1_actionPerformed(e);
            }
        });
        radioButtonMenuItem1.setFont(new Font("»ªÎÄÁ¥Êé", Font.PLAIN, 16));
        menu2.add(radioButtonMenuItem1);
        
        radioButtonMenuItem2 = new JRadioButtonMenuItem("\u5FAE\u8F6F\u96C5\u9ED1");
        radioButtonMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButtonMenuItem2_actionPerformed(e);
            }
        });
        radioButtonMenuItem2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        menu2.add(radioButtonMenuItem2);
        
        radioButtonMenuItem3 = new JRadioButtonMenuItem("\u65B9\u6B63\u8212\u4F53");
        radioButtonMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButtonMenuItem3_actionPerformed(e);
            }
        });
        radioButtonMenuItem3.setFont(new Font("·½ÕýÊæÌå", Font.PLAIN, 16));
        menu2.add(radioButtonMenuItem3);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonMenuItem1);
        group.add(radioButtonMenuItem2);
        group.add(radioButtonMenuItem3);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("\u300AJava\u7F16\u7A0B\u8BCD\u5178\u300B\u662F\u6BCF\u4E2AJava\u7231\u597D\u8005\u7684\u5FC5\u5907\u54C1\uFF01");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    private ActionListener listener = new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int mode = 0;
            if (bold.isSelected()) {
                mode += Font.BOLD;
            }
            if (italic.isSelected()) {
                mode += Font.ITALIC;
            }
            Font font = label.getFont();
            label.setFont(new Font(font.getName(), mode, font.getSize()));
        }
    };
    
    protected void do_radioButtonMenuItem1_actionPerformed(ActionEvent e) {
        Font font = label.getFont();
        label.setFont(new Font("»ªÎÄÁ¥Êé", font.getStyle(), font.getSize()));
    }
    
    protected void do_radioButtonMenuItem2_actionPerformed(ActionEvent e) {
        Font font = label.getFont();
        label.setFont(new Font("Î¢ÈíÑÅºÚ", font.getStyle(), font.getSize()));
    }
    
    protected void do_radioButtonMenuItem3_actionPerformed(ActionEvent e) {
        Font font = label.getFont();
        label.setFont(new Font("·½ÕýÊæÌå", font.getStyle(), font.getSize()));
    }
}
