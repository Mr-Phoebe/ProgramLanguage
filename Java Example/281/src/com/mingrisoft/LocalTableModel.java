package com.mingrisoft;


public class LocalTableModel extends javax.swing.table.DefaultTableModel {
    Class[] types = new Class[] { java.lang.Object.class,
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class };
    boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
    
    public LocalTableModel() {
        super(new Object[][] {}, new String[] { "字段编号", "字段名", "字段长度", "字段类别",
                "描述", "是否为空", "小数位数", "默认值" });
    }
    
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}