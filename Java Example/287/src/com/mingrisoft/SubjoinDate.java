package com.mingrisoft;

import java.sql.*;
/**
 * @author Administrator
 */
public class SubjoinDate {

	String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=master";
	String username = "sa";
	String password = "";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public SubjoinDate() { // 通过构造方法加载数据库驱动
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}

    public boolean Connection() {        //创建数据库连接
        try {
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("creatConnectionError!");
        }
        return true;
    }

    //对数据库的查询操作
    public ResultSet selectStatic(String sql) throws SQLException {
         ResultSet rs=null;
        if (con == null) {
            Connection();
        }
               try {
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery(sql);
         } catch (SQLException e) {
                     e.printStackTrace();
                    }
         closeConnection();
        return rs;
    }
    //更新数据库
    
    public boolean executeUpdate(String dataName, String mPath, String lPath) {
        if (con == null) {
            Connection(); // 数据库连接
        }
        try {
            stmt = con.createStatement();
            int iCount = stmt.executeUpdate("EXEC sp_attach_db @dbname = '"
                    + dataName + "', @filename1='" + mPath
                    + "', @filename2 = '" + lPath + "'");// 执行数据库附加
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        closeConnection(); // 调用关闭数据库连接方法
        return true;
    }

    //关闭数据库的操作
    public void closeConnection() {
       if (con != null && stmt != null && rs != null) {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to close connection!");
            } finally {
                con = null;
            }
        }
    }  
}
