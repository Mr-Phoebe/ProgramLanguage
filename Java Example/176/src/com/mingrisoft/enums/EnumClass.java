package com.mingrisoft.enums;

public class EnumClass {
    
    public static void main(String[] args) {
        for (Size size : Size.values()) {
            System.out.println(size + "µÄÐòÊýÊÇ£º" + size.ordinal());
            System.out.print(size.compareTo(Size.SMALL) + " ");
            System.out.print(size.equals(Size.SMALL) + " ");
            System.out.println(size == Size.SMALL);
            System.out.println(size.name());
            System.out.println("********************");
        }
    }
}
