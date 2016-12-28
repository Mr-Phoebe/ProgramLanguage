package com.mingrisoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DatabaseServerFrame extends JFrame {
    
    private JTextArea ta_info;
    private PrintWriter writer; // 声明PrintWriter类对象
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
    
    public void getserver() {
        try {
            server = new ServerSocket(1978); // 实例化Socket对象
            ta_info.append("服务器套接字已经创建成功\n"); // 输出信息
            while (true) { // 如果套接字是连接状态
                ta_info.append("等待客户机的连接......\n"); // 输出信息
                socket = server.accept(); // 实例化Socket对象
                writer = new PrintWriter(socket.getOutputStream(), true);// 创建输出流对象
                getClientInfo(); // 调用getClientInfo()方法
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    
    private void getClientInfo() {
        try {
            BufferedReader reader; // 声明BufferedReader对象
            while (true) { // 如果套接字是连接状态
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // 实例化BufferedReader对象
                String line = reader.readLine();// 读取客户端信息
                if (line != null) {
                    String[] value = new String[2];// 创建数组
                    value[0] = line.substring(0, line.indexOf(":data:"));// 获得姓名
                    value[1] = line.substring(line.indexOf(":data:") + 6);// 获得年龄
                    ta_info.append("接收到客户端的信息\n姓名为："+value[0]+" 年龄为："+value[1]+"。\n");
                    try {
                        Connection conn = DAO.getConn();// 获得数据库连接
                        String sql = "insert into tb_employee (name,age) values(?,?)";// 定义SQL语句
                        PreparedStatement ps = conn.prepareStatement(sql);// 创建PreparedStatement对象，并传递SQL语句
                        ps.setString(1, value[0]); // 为第1个参数赋值
                        ps.setInt(2, Integer.parseInt(value[1]));// 为第2个参数赋值
                        int flag = ps.executeUpdate(); // 执行SQL语句，获得更新记录数
                        ps.close();// 关闭PreparedStatement对象
                        conn.close();// 关闭连接
                        if (flag > 0) {
                            ta_info.append("并成功地保存到数据库中。\n");
                            writer.println("保存成功。");// 向客户端输出保存成功的信息
                        } else {
                            writer.println("保存失败。\n");// 向客户端输出保存成功的信息
                        }
                    } catch (SQLException ee) {
                        writer.println("保存失败。\n" + ee.getMessage());// 向客户端输出保存成功的信息
                    }
                }
            }
        } catch (Exception e) {
            ta_info.append("客户端已退出。\n");
        } finally {
            try {
                if (socket != null) {
                    socket.close(); // 关闭套接字
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        DatabaseServerFrame frame = new DatabaseServerFrame();
        frame.setVisible(true);
        frame.getserver(); // 调用方法
    }
    
    /**
     * Create the frame
     */
    public DatabaseServerFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("服务器端程序");
        setBounds(100, 100, 277, 263);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 241, 205);
        getContentPane().add(scrollPane);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        //
    }
    
}
