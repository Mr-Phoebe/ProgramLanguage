package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class InsertInfo {
 static Connection conn = null;
    
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
    //将用户登录信息插入到数据库方法

public void insertUser(User user) {
    conn = getConn(); // 获取数据库连接
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_user values(?,?,?)"); // 定义插入数据库的预处理语句          
        statement.setString(1, user.getUserName());     //设置预处理语句参数
        statement.setString(2, user.getPassWord());
        SimpleDateFormat date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //根据指定格式定义SimpleDateFormat对象
        String datetime = date_time.format(new Date());     //对当前日期进行格式化
        statement.setString(3, datetime);
        statement.executeUpdate(); // 执行预处理语句
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
    
}
