package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateSilder extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5326757798867881120L;
    private JPanel contentPane;
    private JSlider yearSlider;
    private JSlider monthSlider;
    private JSlider daySlider;
    private JLabel dateLabel;
    private Calendar calendar = new GregorianCalendar();
    private ChangeListener cl = new DateListener();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy\u5E74MM\u6708dd\u65E5");
    
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
                    DateSilder frame = new DateSilder();
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
    public DateSilder() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u65E5\u671F\u9009\u62E9\u5DE5\u5177");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u9009\u62E9\u7684\u65E5\u671F", TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(59, 59, 59)));
        contentPane.add(panel1);
        
        dateLabel = new JLabel("");
        dateLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
        panel1.add(dateLabel);
        
        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5E74", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panel2);
        panel2.setLayout(new BorderLayout(0, 0));
        
        yearSlider = new JSlider();
        yearSlider.setSnapToTicks(true);
        yearSlider.setPaintTicks(true);
        yearSlider.setPaintLabels(true);
        yearSlider.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel2.add(yearSlider);
        
        JPanel panel3 = new JPanel();
        panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u6708", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panel3);
        panel3.setLayout(new BorderLayout(0, 0));
        
        monthSlider = new JSlider();
        monthSlider.setSnapToTicks(true);
        monthSlider.setPaintTicks(true);
        monthSlider.setPaintLabels(true);
        monthSlider.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel3.add(monthSlider);
        
        JPanel panel4 = new JPanel();
        panel4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u65E5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panel4);
        panel4.setLayout(new BorderLayout(0, 0));
        
        daySlider = new JSlider();
        daySlider.setSnapToTicks(true);
        daySlider.setPaintTicks(true);
        daySlider.setPaintLabels(true);
        daySlider.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
        panel4.add(daySlider);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        
        yearSlider.setMaximum(2020);
        yearSlider.setMinimum(2000);
        yearSlider.setMajorTickSpacing(5);
        yearSlider.setMinorTickSpacing(1);
        yearSlider.setValue(calendar.get(Calendar.YEAR));
        Dictionary<Integer, Component> yearLabel = new Hashtable<Integer, Component>();
        yearLabel.put(2000, new JLabel("2000Äê"));
        yearLabel.put(2005, new JLabel("2005Äê"));
        yearLabel.put(2010, new JLabel("2010Äê"));
        yearLabel.put(2015, new JLabel("2015Äê"));
        yearLabel.put(2020, new JLabel("2020Äê"));
        yearSlider.setLabelTable(yearLabel);
        yearSlider.addChangeListener(cl);
        
        monthSlider.setMaximum(12);
        monthSlider.setMinimum(1);
        monthSlider.setMajorTickSpacing(1);
        monthSlider.setValue(calendar.get(Calendar.MONTH) + 1);
        String[] months = (new DateFormatSymbols()).getShortMonths();
        Dictionary<Integer, Component> monthLabel = new Hashtable<Integer, Component>(12);
        for (int i = 0; i < 12; i++) {
            monthLabel.put(i + 1, new JLabel(months[i]));
        }
        monthSlider.setLabelTable(monthLabel);
        monthSlider.addChangeListener(cl);
        
        daySlider.setMaximum(calendar.getMaximum(Calendar.DAY_OF_MONTH));
        daySlider.setMinimum(1);
        daySlider.setMajorTickSpacing(5);
        daySlider.setMinorTickSpacing(1);
        daySlider.setValue(calendar.get(Calendar.DATE));
        daySlider.addChangeListener(cl);
        
        dateLabel.setText(dateFormat.format(new Date()));
    }
    
    private class DateListener implements ChangeListener {
        
        @Override
        public void stateChanged(ChangeEvent e) {
            calendar.set(yearSlider.getValue(), monthSlider.getValue() - 1, 1);
            int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            if (daySlider.getMaximum() != maxDays) {
                daySlider.setValue(Math.min(daySlider.getValue(), maxDays));
                daySlider.setMaximum(maxDays);
                daySlider.repaint();
            }
            calendar.set(yearSlider.getValue(), monthSlider.getValue() - 1, daySlider.getValue());
            dateLabel.setText(dateFormat.format(calendar.getTime()));
        }
        
    }
}
