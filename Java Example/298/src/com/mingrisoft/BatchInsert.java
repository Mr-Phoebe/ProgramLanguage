package com.mingrisoft;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchInsert {
  Connection conn = null;
    
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
    
public void insertStu(String sql){
    conn = getConn();                       //获取数据库连接
    try {
        Statement statement = conn.createStatement();   //创建Statement对象
        statement.executeUpdate(sql);       //执行插入SQL语句
	System.out.println("插入数据成功");
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}

public static void main(String[] args) {
    BatchInsert insert = new BatchInsert();     //创建本类对象
    String sql = "insert tb_stu select '双双','女','生物科学','08d02' " +
    		"union all select '王爽','女','计算机应用','08d02' " +
    		"union all select '朱莉','女','英语','07d02'";     //定义插入的SQL语句
    insert.insertStu(sql);          //调用插入数据方法
}
}
