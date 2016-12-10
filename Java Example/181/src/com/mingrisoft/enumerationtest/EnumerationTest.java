package com.mingrisoft.enumerationtest;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 3; i++) {
            vector.add(i);
            System.out.println("在向量中增加元素：" + i);
        }
        Enumeration<Integer> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println("获得向量中的元素：" + e.nextElement());
        }
    }
}
