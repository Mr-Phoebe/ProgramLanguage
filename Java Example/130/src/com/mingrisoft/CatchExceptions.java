package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CatchExceptions {
    private static String URL = "jdbc:mysql://localhost:3306/db_database";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "mr";
    private static String PASSWORD = "mingri";
    private static Connection conn;
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);// 加载驱动程序
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 建立连接
            return conn;
        } catch (ClassNotFoundException e) {// 捕获类为发现异常
            e.printStackTrace();
        } catch (SQLException e) {// 捕获SQL异常
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        CatchExceptions.getConnection();
    }
}
