package com.mingrisoft;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WareUtil {
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
    
public void insertWare(Ware ware) {
    conn = getConn(); // 获取数据库连接
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_ware values(?,?,?,?,?,?,?)"); // 定义插入数据库的预处理语句
        statement.setString(1,ware.getSID() ); // 设置预处理语句的参数值
        statement.setString(2,ware.getsName());
        statement.setString(3, ware.getSpec());
        statement.setString(4,ware.getCasing());
        statement.setString(5,ware.getUnit() );
        statement.setString(6, ware.getsDate());
        statement.setInt(7, ware.getAmout());
        statement.executeUpdate(); // 执行预处理语句
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectWare() {
        conn = getConn(); // 获取数据库连接
        Statement statment;
        List list = new ArrayList<Ware>();
        try {
            statment = conn.createStatement(); // 获取Statement对象
            String sql = "select * from tb_ware"; // 定义查询SQL语句
            ResultSet rest = statment.executeQuery(sql); // 执行查询语句获取查询结果集
            while (rest.next()) { // 循环遍历查询结果集
               Ware ware = new Ware();              //
               ware.setSID(rest.getString(1));
               ware.setsName(rest.getString(2));
               ware.setSpec(rest.getString(3));
               ware.setCasing(rest.getString(4));
               ware.setUnit(rest.getString(5));
               ware.setsDate(rest.getString(6));
               ware.setAmout(rest.getInt(7));
               list.add(ware);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 返回查询结果
    }
    public static String getDateTime(){     //该方法返回值为String类型
        SimpleDateFormat format;
                            //simpleDateFormat类可以选择任何用户定义的日期-时间格式的模式
        Date date = null; 
        Calendar myDate = Calendar.getInstance();
                            //Calendar的方法getInstance()，以获得此类型的一个通用的对象
        myDate.setTime(new java.util.Date());
                            //使用给定的Date设置此Calendar的时间
        date = myDate.getTime();
                            //返回一个表示此Calendar时间值（从历元至现在的毫秒偏移量）的Date对象
        format = new SimpleDateFormat("yyyy-MM-dd");
                            //编写格式化时间为“年-月-日 时：分：秒”
        String strRtn = format.format(date);
                            //将给定的Date格式化为日期/时间字符串，并将结果赋值给给定的String
        return strRtn;          //返回保存返回值变量
    }

   
}
