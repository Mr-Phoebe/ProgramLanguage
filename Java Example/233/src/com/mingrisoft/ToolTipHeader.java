package com.mingrisoft;

import java.awt.event.MouseEvent;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class ToolTipHeader extends JTableHeader {
    
    private static final long serialVersionUID = 6694115973725345619L;
    private String[] toolTips;
    
    public ToolTipHeader(TableColumnModel model) {
        super(model);
    }
    
    public void setToolTips(String[] toolTips) {
        this.toolTips = toolTips;
    }
    
    @Override
    public String getToolTipText(MouseEvent event) {
        int index = columnAtPoint(event.getPoint());
        if (index != -1) {
            return "<html><font face=Î¢ÈíÑÅºÚ size=16 color=red>" + toolTips[index] + "</font></html>";
        } else {
            return "";
        }
    }
}