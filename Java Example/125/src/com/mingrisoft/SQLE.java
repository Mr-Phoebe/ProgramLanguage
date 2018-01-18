package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLE {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/db_database";				// MySQL数据库的URL
        String DRIVER = "com.mysql.jdbc.Driver";						// MySQL数据库的驱动
        String USERNAME = "mr";										// 数据库的用户名
        Connection connection = null;
        try {
            Class.forName(DRIVER);										// 加载驱动
            connection = DriverManager.getConnection(URL, USERNAME, "");		// 建立连接
        } catch (SQLException e) {						// 捕获SQLException
            e.printStackTrace();
        } catch (ClassNotFoundException e) {			// 捕获ClassNotFoundException
            e.printStackTrace();
        } finally {
            try {
                connection.close();						// 释放资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
