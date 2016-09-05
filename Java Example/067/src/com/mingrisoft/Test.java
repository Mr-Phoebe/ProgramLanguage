package com.mingrisoft;
import javax.swing.JOptionPane;

public class Test {
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock(1000, true);
        clock.start();
        JOptionPane.showMessageDialog(null, "ÊÇ·ñÍË³ö£¿");
        System.exit(0);
    }
}