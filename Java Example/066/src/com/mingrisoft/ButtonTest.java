package com.mingrisoft;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5726190585100402900L;
    private JPanel contentPane;
    
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
                    ButtonTest frame = new ButtonTest();
                    frame.setVisible(true);
                    frame.contentPane.requestFocus();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public ButtonTest() {
        setTitle("普通内部类的简单应用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        final JButton redButton = new JButton();
        redButton.setText("红色");
        redButton.setBounds(15, 20, 82, 30);
        redButton.addActionListener(new ColorAction(Color.RED));
        contentPane.add(redButton);

        final JButton greenButton = new JButton();
        greenButton.setText("绿色");
        greenButton.setBounds(100, 20, 82, 30);
        greenButton.addActionListener(new ColorAction(Color.GREEN));
        contentPane.add(greenButton);

        final JButton blueButton = new JButton();
        blueButton.setText("蓝色");
        blueButton.setBounds(185, 20, 82, 30);
        blueButton.addActionListener(new ColorAction(Color.BLUE));
        contentPane.add(blueButton);
    }
    
    private class ColorAction implements ActionListener {
        
        private Color background;
        
        public ColorAction(Color background) {
            this.background = background;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	contentPane.setBackground(background);
            
        }
    }
}
