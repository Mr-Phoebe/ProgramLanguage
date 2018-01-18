package com.mingrisoft;
public class User {
    public static void main(String[] args) {
        System.out.print("用户选择了GIF格式：");
        ImageSaver saver = TypeChooser.getSaver("GIF");//获得保存图片为GIF类型的对象
        saver.save();
        System.out.print("用户选择了JPEG格式：");//获得保存图片为JPEG类型的对象
        saver = TypeChooser.getSaver("JPEG");
        saver.save();
        System.out.print("用户选择了PNG格式：");//获得保存图片为PNG类型的对象
        saver = TypeChooser.getSaver("PNG");
        saver.save();
    }
}
