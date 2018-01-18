package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BallotUtil {
    static Connection conn = null;
    
    // 获取数据库连接
    public static Connection getConn() {
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
    
    // 定义添加选票表中字段方法
    
    public void addField(String fieldName, String type) {
        conn = getConn(); // 获取数据库连接
        try {
            Statement statement = conn.createStatement(); // 获取Statement方法
            String sql = "alter table tb_ballot add " + fieldName + " " + type; // 向数据表中添加字段
            statement.executeUpdate(sql); // 执行更新数据表SQL语句
            conn.close(); // 关闭数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 定义删除选票表中字段方法
    
    public void deleteField(String fieldName) {
        conn = getConn(); // 获取数据库连接
        try {
            Statement statement = conn.createStatement();
            String sql = "alter table tb_ballot drop column " + fieldName; // 定义从数据库中删除字段SLQ语句
            statement.executeUpdate(sql); // 执行删除操作
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 定义获取数据表中所有字段方法
    public List getField() {
        List list = new ArrayList();
        conn = getConn();
        try {
            Statement ps = conn.createStatement();
            ResultSet rest = ps.executeQuery("select * from tb_ballot");
            ResultSetMetaData rsme = rest.getMetaData();
            int columnCount = rsme.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String cName = rsme.getColumnName(i);
                list.add(cName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
