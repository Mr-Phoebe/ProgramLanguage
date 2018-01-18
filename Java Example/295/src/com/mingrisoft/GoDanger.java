package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class GoDanger {
    private Connection conn;
    // 获取数据库连接
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database17"; // 连接数据库URL
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
    public void insertBookSell(BookSell bookSell) {
        conn = getConn(); // 获取数据库连接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_bookSell values(?,?,?,?)"); // 定义插入数据库的预处理语句
         
            statement.setString(1,bookSell.getBookName() );
            statement.setString(2, bookSell.getStock());
            statement.setFloat(3, bookSell.getPrice());
            statement.setString(4, bookSell.getBookConcern());
            statement.executeUpdate(); // 执行预处理语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
