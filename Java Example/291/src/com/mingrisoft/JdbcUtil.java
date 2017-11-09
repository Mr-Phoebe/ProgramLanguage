package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
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
    
    public void insertEmp(Emp emp) {
        conn = getConn(); // 获取数据库连接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_emp values(?,?,?,?,?,?)"); // 定义插入数据库的预处理语句
            statement.setString(1, emp.getName()); // 设置预处理语句的参数值
            statement.setString(2, emp.getSex());
            statement.setInt(3, emp.getAge());
            statement.setString(4, emp.getDept());
            statement.setString(5, emp.getPhone());
            statement.setString(6, emp.getRemark());
            statement.executeUpdate(); // 执行预处理语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int selectEmpUseName(String name) {
        conn = getConn(); // 获取数据库连接
        Statement statment;
        int id = 0; // 定义保存返回值的int对象
        try {
            statment = conn.createStatement(); // 获取Statement对象
            String sql = "select id from tb_emp where name = '" + name + "'"; // 定义查询SQL语句
            ResultSet rest = statment.executeQuery(sql); // 执行查询语句获取查询结果集
            while (rest.next()) { // 循环遍历查询结果集
                id = rest.getInt(1); // 获取查询结果
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; // 返回查询结果
    }
    
}
