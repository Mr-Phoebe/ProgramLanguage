package com.mingrisoft;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDescribe {
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
    //定义获取字段的描述信息方法

public List getDescribe(String tableName) {
    conn = getConn();           //获取数据库连接
    List list = new ArrayList();    //定义List集合对象
    try {
        Statement stmt = conn.createStatement();    //获取Statement对象
        ResultSet rest = stmt
                .executeQuery("select c.name,b.value FROM sysobjects a,sysproperties b,syscolumns " +
                		"c where a.name='"+tableName+"' and a.id=b.id and b.id=c.id and b.smallid=c.colorder");   //执行查询语句
        while(rest.next()){ //循环遍历查询结果集
            Describe describe = new Describe(); //定义定义的JavaBean对象
            describe.setName(rest.getString(1));    //设置对象属性
            describe.setValue(rest.getString(2));   
            list.add(describe);             //向集合中添加对象
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return list;
}    
    
    //主方法
    public static void main(String[] args) {
        GetDescribe getDescribe = new GetDescribe();
        List list = getDescribe.getDescribe("tb_book");
        System.out.println("数据表tb_book的字段与描述信息为：");
        for(int i = 0;i<list.size();i++){
            Describe describe = (Describe)list.get(i);
            System.out.println("   字段为："+describe.getName()+"  描述信息为："+describe.getValue());
        }
    }
    
}
