package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    public Connection Con() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection Con = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=master",
                    "sa", "");
            return Con;
        } catch (Exception e) {
            return null;
        }
    }
    
    // 获取所有数据库名称
    
    public List getDatabase() {
        List list = new ArrayList(); // 定义List集合对象
        Connection con = Con(); // 获取数据库连接
        Statement st; // 定义Statement对象
        try {
            st = con.createStatement(); // 实例化Statement对象
            ResultSet rs = st.executeQuery("select name from dbo.sysdatabases"); // 指定查询所有数据库方法
            while (rs.next()) { // 循环遍历查询结果集
                list.add(rs.getString(1)); // 将查询数据添加到List集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 返回查询结果
    }
    
    // 定义查询备份数据库方法

public void getBak(String databaseName, String databasePath) {
    Connection con = Con(); // 获取数据库连接
    Statement st;
    try {          
        st = con.createStatement(); // 实例化Statement对象
        st.executeUpdate("restore database " + databaseName
                + " from disk='" + databasePath + "'"); // 指定数据库备份SQL语句
        con.close(); // 关闭连接
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public static void main(String[] args) {
        Resume resume = new Resume();
        resume.getBak("master", "c://master.bak");
    }
}
