package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Calculator extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 8974251829789201782L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculator frame = new Calculator();
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
    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        textField = new JTextField();
        textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        contentPane.add(textField, BorderLayout.NORTH);
        textField.setColumns(10);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        
        JButton number1Button = new JButton("1");
        number1Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number1Button);
        
        JButton number2Button = new JButton("2");
        number2Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number2Button);
        
        JButton number3Button = new JButton("3");
        number3Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number3Button);
        
        JButton addButton = new JButton("+");
        addButton.setForeground(Color.RED);
        addButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(addButton);
        
        JButton number4Button = new JButton("4");
        number4Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number4Button);
        
        JButton number5Button = new JButton("5");
        number5Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number5Button);
        
        JButton number6Button = new JButton("6");
        number6Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number6Button);
        
        JButton subtractButton = new JButton("-");
        subtractButton.setForeground(Color.RED);
        subtractButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(subtractButton);
        
        JButton number7Button = new JButton("7");
        number7Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number7Button);
        
        JButton number8Button = new JButton("8");
        number8Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number8Button);
        
        JButton number9Button = new JButton("9");
        number9Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number9Button);
        
        JButton multiplyButton = new JButton("*");
        multiplyButton.setForeground(Color.RED);
        multiplyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(multiplyButton);
        
        JButton number0Button = new JButton("0");
        number0Button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(number0Button);
        
        JButton dotButton = new JButton(".");
        dotButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(dotButton);
        
        JButton equalButton = new JButton("=");
        equalButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(equalButton);
        
        JButton divideButton = new JButton("/");
        divideButton.setForeground(Color.RED);
        divideButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        panel.add(divideButton);
    }

}
