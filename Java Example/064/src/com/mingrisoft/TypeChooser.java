package com.mingrisoft;
public class TypeChooser {
    public static ImageSaver getSaver(String type) {
        if (type.equalsIgnoreCase("GIF")) {//使用if else语句来判断图片的类型
            return new GIFSaver();
        } else if (type.equalsIgnoreCase("JPEG")) {
            return new JPEGSaver();
        } else if (type.equalsIgnoreCase("PNG")) {
            return new PNGSaver();
        } else {
            return null;
        }
    }
}
