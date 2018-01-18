package com.mingrisoft;
public class JPEGSaver implements ImageSaver {
    
    @Override
    public void save() {
        System.out.println("将图片保存成JPG格式");
    }
}