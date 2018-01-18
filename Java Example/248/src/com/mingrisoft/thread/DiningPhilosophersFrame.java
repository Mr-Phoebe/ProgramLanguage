package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class DiningPhilosophersFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9072333459039474643L;
	private JPanel contentPane;
	private JTextArea thinkingTextArea;
	private JTextArea eatingTextArea;
	private JTextArea waitingTextArea;

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
					DiningPhilosophersFrame frame = new DiningPhilosophersFrame();
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
	public DiningPhilosophersFrame() {
		setTitle("\u54F2\u5B66\u5BB6\u5C31\u9910\u95EE\u9898");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel labelPanel = new JPanel();
		contentPane.add(labelPanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u54F2\u5B66\u5BB6\u7684\u72B6\u6001");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanel.add(label);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton startButton = new JButton("\u5F00\u59CB\u8FD0\u884C");
		startButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_startButton_actionPerformed(arg0);
			}
		});
		buttonPanel.add(startButton);
		
		JPanel statePanel = new JPanel();
		contentPane.add(statePanel, BorderLayout.CENTER);
		statePanel.setLayout(new GridLayout(1, 3, 5, 5));
		
		JPanel thinkingPanel = new JPanel();
		statePanel.add(thinkingPanel);
		thinkingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel thinkingLabel = new JLabel("\u601D\u8003");
		thinkingLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		thinkingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thinkingPanel.add(thinkingLabel, BorderLayout.NORTH);
		
		JScrollPane thinkingScrollPane = new JScrollPane();
		thinkingPanel.add(thinkingScrollPane, BorderLayout.CENTER);
		
		thinkingTextArea = new JTextArea();
		thinkingTextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		thinkingScrollPane.setViewportView(thinkingTextArea);
		
		JPanel eatingPanel = new JPanel();
		statePanel.add(eatingPanel);
		eatingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel eatingLabel = new JLabel("\u5C31\u9910");
		eatingLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		eatingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eatingPanel.add(eatingLabel, BorderLayout.NORTH);
		
		JScrollPane eatingScrollPane = new JScrollPane();
		eatingPanel.add(eatingScrollPane, BorderLayout.CENTER);
		
		eatingTextArea = new JTextArea();
		eatingTextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		eatingScrollPane.setViewportView(eatingTextArea);
		
		JPanel waitingPanel = new JPanel();
		statePanel.add(waitingPanel);
		waitingPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel waitingLabel = new JLabel("\u7B49\u5F85");
		waitingLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		waitingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		waitingPanel.add(waitingLabel, BorderLayout.NORTH);
		
		JScrollPane waitingScrollPane = new JScrollPane();
		waitingPanel.add(waitingScrollPane, BorderLayout.CENTER);
		
		waitingTextArea = new JTextArea();
		waitingTextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		waitingScrollPane.setViewportView(waitingTextArea);
	}

	protected void do_startButton_actionPerformed(ActionEvent arg0) {
		ChopstickArray chopstickArray = new ChopstickArray(5);
		for(int i=0;i<5;i++) {
			new Thread(new Philosopher(i, chopstickArray, thinkingTextArea, eatingTextArea, waitingTextArea)).start();
		}
	}
}
