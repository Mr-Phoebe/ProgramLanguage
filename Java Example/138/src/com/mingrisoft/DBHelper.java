package com.mingrisoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper implements DBConfig {

    public static boolean savePicture(Picture picture) {
        try {
            Class.forName(DRIVER);// 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FileInputStream in = null;
        String sql = "insert into tb_picture (picturename, picturefile) values (?, ?);";// 定义SQL语句
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            in = new FileInputStream(picture.getPictureFile());// 获得文件输入流
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接
            ps = conn.prepareStatement(sql);// 获得预处理对象
            ps.setString(1, picture.getPictureName());// 设置文件名
            ps.setBlob(2, in);// 设置文件输入流
            ps.execute();// 保存数据
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
