package com.mingrisoft;
public class GIFSaver implements ImageSaver {
    @Override
    public void save() {//实现save()方法
        System.out.println("将图片保存成GIF格式");
    }
}
