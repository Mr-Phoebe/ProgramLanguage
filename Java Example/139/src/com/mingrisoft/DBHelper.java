package com.mingrisoft;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

public class DBHelper implements DBConfig {

    public static ImageIcon retrievePicture(Picture picture) {
        try {
            Class.forName(DRIVER);// 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 定义SQL语句
        String sql = "select picturefile from tb_picture where id = " + picture.getId() + " and picturename = '" + picture.getPictureName() + "'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接
            stat = conn.createStatement();// 获得语句对象
            rs = stat.executeQuery(sql);// 获得查询结果
            if (rs.next()) {
                Blob pictureFile = rs.getBlob("picturefile");// 获得Blob对象
                return new ImageIcon(pictureFile.getBytes(1, (int) pictureFile.length()));// 创建图表
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat != null) {
                try {
                    stat.close();
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
        return null;
    }
}
