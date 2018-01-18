package com.mingrisoft;
import java.util.*;
import java.io.*;

public class FileSearch {
    
    public List<File> findFiles(String baseDirName, String targetFileName) {
        List<File> fileList = new ArrayList<File>(); // 定义保存返回值的List对象
        File baseDir = new File(baseDirName); // 根据参数创建File对象
        if (!baseDir.exists() || !baseDir.isDirectory()) { // 如果该File对象不存在或者不是一个目录
            return fileList; // 返回List对象
        }
        String tempName = null;
        File[] files = baseDir.listFiles(); // 获取参数目录下的文件数组
        for (int i = 0; i < files.length; i++) { // 循环遍历文件数组
            if (!files[i].isDirectory()) { // 如果数组中的文件不是一个目录
                tempName = files[i].getName(); // 获取该数组的名称
                if (FileSearch.findName(targetFileName, tempName)) { // 调用文件匹配方法
                    fileList.add(files[i].getAbsoluteFile()); // 将指定的文件名添加到集合中
                }
            }
        }
        return fileList;
    }
    
    public static boolean findName(String pattern, String str) {
        int patternLength = pattern.length(); // 获取参数字符串的长度
        int strLength = str.length();
        int strIndex = 0;
        char eachCh;
        for (int i = 0; i < patternLength; i++) { // 循环字符参数字符串中的每个字符
            eachCh = pattern.charAt(i); // 获取字符串中每个索引位置的字符
            if (eachCh == '*') { // 如果这个字符是一个星号
                while (strIndex < strLength) {
                    if (findName(pattern.substring(i + 1), str
                            .substring(strIndex))) { // 如果文件名与搜索模型匹配
                        return true;
                    }
                    strIndex++;
                }
            } else if (eachCh == '?') { // 如果包含问号
                strIndex++;
                if (strIndex > strLength) { // 如果str中没有字符可以匹配“?”号
                    return false;
                }
            } else { // 如果要寻找的是普通的文件
                if ((strIndex >= strLength) || (eachCh != str.charAt(strIndex))) { // 如果没有查找到匹配的文件
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }
}
