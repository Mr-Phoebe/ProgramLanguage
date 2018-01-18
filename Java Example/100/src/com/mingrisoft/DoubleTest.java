package com.mingrisoft;

public class DoubleTest {
    public static void main(String[] args) {
        Double number1 = 12.4;
        Double number2 = 12.3;
        System.out.println("number1£º" + number1);
        System.out.println("number2£º" + number2);
        switch (number1.compareTo(number2)) {
            case -1:
                System.out.println("number1 < number2");
                break;
            case 0:
                System.out.println("number1 == number2");
                break;
            case 1:
                System.out.println("number1 > number2");
                break;
        }
    }
}
