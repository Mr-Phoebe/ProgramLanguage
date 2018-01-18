package com.mingrisoft;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTables {
    static Connection conn = null;
    
    // 获取数据库连接
    public static Connection getConn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_database17"; // 连接数据库URL
        String userName = "sa"; // 连接数据库的用户名
        String passWord = ""; // 连接数据库密码
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 获取数据库连接
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 返回Connection对象
    }
    
    public static ResultSet GetRs() {
        try {
            String[] tableType = { "TABLE" }; // 指定要进行查询的表类型
            Connection conn = getConn(); // 调用与数据库建立连接方法
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // 获取DatabaseMetaData实例
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// 获取数据库中所有数据表集合
            return resultSet;
        } catch (SQLException e) {
            System.out.println("记录数量获取失败！");
            return null;
        }
    }
    
    public static void main(String[] args) {
        ResultSet rst = GetRs();
        System.out.println("数据库中的表有：");
        try {
            while (rst.next()) { // 遍历集合
                String tableName = rst.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
