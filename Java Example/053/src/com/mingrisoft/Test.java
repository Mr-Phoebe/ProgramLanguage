package com.mingrisoft;

import java.awt.Color;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Java", 12, 21, Color.BLACK); // ´´½¨Ã¨ßä1ºÅ
        Cat cat2 = new Cat("C++", 12, 21, Color.WHITE); // ´´½¨Ã¨ßä2ºÅ
        Cat cat3 = new Cat("Java", 12, 21, Color.BLACK); // ´´½¨Ã¨ßä3ºÅ
        System.out.println("Ã¨ßä1ºÅ£º" + cat1);// Êä³öÃ¨ßä1ºÅ
        System.out.println("Ã¨ßä2ºÅ£º" + cat2);// Êä³öÃ¨ßä2ºÅ
        System.out.println("Ã¨ßä3ºÅ£º" + cat3);// Êä³öÃ¨ßä3ºÅ
    }

}
