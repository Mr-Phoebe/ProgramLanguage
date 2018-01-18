package com.mingrisoft;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MySQLConn {
    Connection conn = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载MySQL数据库驱动
            String url = "jdbc:mysql://localhost:3306/information_schema"; // 定义与连接数据库的url
            String user = "root"; // 定义连接数据库的用户名
            String passWord = "111"; // 定义连接数据库的密码
            conn = DriverManager.getConnection(url, user, passWord); // 连接连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
      
    // 获取MySQL所有数据库方法
    public List getDatabase() {
        List list = new ArrayList(); // 定义List集合对象
        Connection con = getConnection(); // 获取数据库连接
        Statement st; // 定义Statement对象
        try {
            st = con.createStatement(); // 实例化Statement对象
            ResultSet rs = st.executeQuery("select schema_name from SCHEMATA"); // 指定查询所有数据库方法
            while (rs.next()) { // 循环遍历查询结果集
                list.add(rs.getString(1)); // 将查询数据添加到List集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 返回查询结果
    }
    
    // 备份数据库方法

public boolean mysqldump(String database, String path) { // 备份数据库
    try {
        Process p = Runtime.getRuntime().exec(
                "cmd.exe /c mysqldump -uroot -p111 " + database + " >"
                        + path + "");           //定义进行数据备份的语句
        StringBuffer out1 = new StringBuffer(); //定义字符串缓冲对象
        byte[] b = new byte[1024];              //定义字节数组
        for (int i; ((i = p.getInputStream().read(b)) != -1);) { // 将数据写入到指定文件中
            out1.append(new String(b, 0, i));   //向流中追加数据
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}
    
    
}
