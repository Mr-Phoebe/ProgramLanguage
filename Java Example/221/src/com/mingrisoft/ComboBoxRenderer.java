package com.mingrisoft;

import java.awt.Component;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer {
    private static final long serialVersionUID = -318939036460656104L;

    private Map<String, ImageIcon> content;
    public ComboBoxRenderer(Map<String, ImageIcon> content) {
        this.content = content;
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String key = (String)value;
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText(key);
        setIcon(content.get(key));
        setFont(list.getFont());
        return this;
    }
}
