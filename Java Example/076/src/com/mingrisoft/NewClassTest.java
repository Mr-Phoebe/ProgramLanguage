package com.mingrisoft;

import java.io.File;
import java.lang.reflect.Constructor;

public class NewClassTest {
    public static void main(String[] args) {
        try {//获得File类的Constructor对象
            Constructor<File> constructor = 
                                              File.class.getDeclaredConstructor(String.class);
            System.out.println("使用反射创建File对象");
            File file = constructor.newInstance("d://明日科技.txt");
            System.out.println("使用File对象在D盘创建文件：明日科技.txt");
            file.createNewFile();//创建新的文件
            System.out.println("文件是否创建成功：" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
