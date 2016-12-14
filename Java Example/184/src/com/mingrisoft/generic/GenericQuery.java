package com.mingrisoft.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class GenericQuery {
    
    private static String URL = "jdbc:mysql://localhost:3306/db_database13";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "111";
    private static Connection conn;
    
    public static Connection getConnection() {
        DbUtils.loadDriver(DRIVER);
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static <T> List<T> query(String sql, Class<T> type) {
        QueryRunner qr = new QueryRunner();
        List<T> list = null;
        try {
            list = qr.query(getConnection(), sql, new BeanListHandler<T>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }
}
