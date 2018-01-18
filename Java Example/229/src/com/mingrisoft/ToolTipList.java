package com.mingrisoft;

import java.awt.event.MouseEvent;

import javax.swing.JList;

public class ToolTipList extends JList {
    
    private static final long serialVersionUID = -5334116242803068391L;
    private Object[][] data;
    
    public ToolTipList(Object[][] data) {
        this.data = data;
        Object[] listData = new Object[data.length];
        for (int i = 0; i < listData.length; i++) {
            listData[i] = data[i][0];
        }
        setListData(listData);
        
    }
    
    @Override
    public String getToolTipText(MouseEvent event) {
        int index = locationToIndex(event.getPoint());
        if (index > -1) {
            return "<html><font face=Î¢ÈíÑÅºÚ size=16 color=red>" + data[index][1]+ "</font></html>";
        } else {
            return super.getToolTipText(event);
        }
    }
}