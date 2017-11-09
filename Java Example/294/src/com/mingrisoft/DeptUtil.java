package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptUtil {
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
    
public void insertDept(Dept dept) {
    conn = getConn(); // 获取数据库连接
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_dept values(?,?,?)"); // 定义插入数据库的预处理语句
        statement.setString(1,dept.getDid() ); // 设置预处理语句的参数值
        statement.setString(2,dept.getdName());
        statement.setString(3, dept.getPriName());      
        statement.executeUpdate(); // 执行预处理语句
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectDept() {
        conn = getConn(); // 获取数据库连接
        Statement statment;
        List list = new ArrayList<Dept>();
        try {
            statment = conn.createStatement(); // 获取Statement对象
            String sql = "select * from tb_dept"; // 定义查询SQL语句
            ResultSet rest = statment.executeQuery(sql); // 执行查询语句获取查询结果集
            while (rest.next()) { // 循环遍历查询结果集
              Dept dept = new Dept();
              dept.setDid(rest.getString(1));
              dept.setdName(rest.getString(2));
              dept.setPriName(rest.getString(3));
              list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 返回查询结果
    }
}
