package com.mingrisoft;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();	// 创建列表
        for (int i = 0; i < 10; i++) {					// 向列表中增加10个元素
            list.add(i);
        }
        System.out.println("列表中的全部元素：");
        for(Iterator<Integer> it = list.iterator();it.hasNext();) {
            System.out.print(it.next()+" ");
        }
    }
}
