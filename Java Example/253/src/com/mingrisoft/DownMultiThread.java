package com.mingrisoft;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

public class DownMultiThread implements Runnable{
    private String sUrl = "";// 网络资源地址
    private File desFile;// 需要写入的目标文件对象
    private long startPos;// 写入的开始位置
    private long endPos;// 写入的结束位置
    /**
     * @param sUrl 网络资源地址
     * @param file 需要写入的目标文件对象
     * @param startPos 写入的开始位置
     * @param endPos 写入的结束位置
     */
    public DownMultiThread(String sUrl,File desFile,long startPos,long endPos) {
        this.sUrl = sUrl;
        this.desFile = desFile;
        this.startPos = startPos;
        this.endPos = endPos;
    }
    @Override
    public void run() {
        try {
            URL url = new URL(sUrl);// 创建下载资源的URL对象
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();// 打开连接对象
            conn.setRequestProperty("User-Agent", "NetFox");// 设置请求属性
            String rangeProperty = "bytes="+startPos+"-";// 定义范围属性
            if (endPos > 0){
                rangeProperty = "bytes="+startPos+"-" + endPos;// 调整范围属性的值
            }
            conn.setRequestProperty("RANGE", rangeProperty);// 指定范围属性
            RandomAccessFile out = new RandomAccessFile(desFile, "rw");// 创建可读写的流对象
            out.seek(startPos);// 指定读写的开始标记
            InputStream in = conn.getInputStream();// 获得网络资源的输入流对象
            BufferedInputStream bin = new BufferedInputStream(in);// 创建输入缓冲流对象
            byte[] buff = new byte[2048];// 创建字节数组
            int len = -1;// 声明存放读取字节数的变量
            len=bin.read(buff);// 读取到内容并添加到字节数组
            while (len!=-1){
                out.write(buff,0,len);// 写入磁盘文件
                len=bin.read(buff);// 读取到内容并添加到字节数组
            }
            out.close();// 关闭流
            bin.close();// 关闭流
            conn.disconnect();// 断开连接
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
