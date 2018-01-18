package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTables {
    Connection conn = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载MySQL数据库驱动
            String url = "jdbc:mysql://localhost:3306/db_database17"; // 定义与连接数据库的url
            String user = "root"; // 定义连接数据库的用户名
            String passWord = "111"; // 定义连接数据库的密码
            conn = DriverManager.getConnection(url, user, passWord); // 连接连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    // 显示数据库
public ResultSet listDB() {
    String sql = "show tables;"; // 定义查询数据SQL语句
    try {
        conn = getConnection(); // 获取数据库连接
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY); // 实例化Statement对象
        ResultSet rs = stmt.executeQuery(sql); // 执行查询SQL语句
        return rs;              //返回查询结果
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}
    
    public static void main(String[] args) {
        GetTables tables = new GetTables();
        ResultSet rest = tables.listDB();
        System.out.println("数据库db_database17下的数据表有：");
        try {
            while (rest.next()) {
                System.out.println(rest.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
