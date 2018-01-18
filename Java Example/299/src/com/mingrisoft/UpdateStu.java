package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateStu {
    // 获取数据库连接
    private Connection conn;
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
    //定义更新tb_stu表方法

public void updateStu(Stu stu){
    conn = getConn();   //获取数据库连接
    try {
        PreparedStatement statement = conn.prepareStatement("update tb_stu set name = ?,sex = ?,grade = ?,specialty = ? where id = ?");//定义更新SQL语句
        statement.setString(1, stu.getName());  //设置预处理语句参数
        statement.setString(2, stu.getSex());
        statement.setString(3,stu.getGrade());
        statement.setString(4, stu.getSpecialty());
        statement.setInt(5, stu.getId());
        statement.execute();    //执行预处理语句
    } catch (Exception e) {            
        e.printStackTrace();
    }        
}
    
    //定义查询所有同学信息方法
    public List selectStu(){
        conn = getConn();
        Statement statement;
        List list = new ArrayList<Stu>();
        try {
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu");
            while(rest.next()){
                Stu stu = new Stu();
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));
                list.add(stu);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return list;        
    }
    //定义按照指定编号查询学生信息方法
    public Stu selectStu(int id){
        conn = getConn();
        Statement statement;
        Stu stu = new Stu();
        try {         
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu where id = "+id);
            while(rest.next()){              
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));          
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return stu;        
    }
}
