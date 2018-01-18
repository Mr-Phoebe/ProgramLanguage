package com.mingrisoft;
import java.sql.*;
import javax.swing.JOptionPane;
public class DAO {
    private static DAO dao = new DAO(); // 声明DAO类的静态实例
    /**
     * 构造方法，加载数据库驱动
     */
    public DAO() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "数据库驱动加载失败。\n"
                    + e.getMessage());
        }
    }
    
    /**
     * 获得数据库连接的方法
     * 
     * @return Connection
     */
    public static Connection getConn() {
        try {
            Connection conn = null; // 定义数据库连接
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=database/db_picture.mdb"; // 数据库db_picture.mdb的URL
            String username = ""; // 数据库的用户名
            String password = ""; // 数据库密码
            conn = DriverManager.getConnection(url, username, password); // 建立连接
            return conn; // 返回连接
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "数据库连接失败。\n" + e.getMessage());
            return null;
        }
    }
}