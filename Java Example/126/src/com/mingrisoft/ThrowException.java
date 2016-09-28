package com.mingrisoft;
public class ThrowException {
    public static void throwException() {
        throw new UnsupportedOperationException("方法尚未实现");		// 抛出异常
    }
    public static void main(String[] args) {
        ThrowException.throwException();							// 调用抛出异常的方法
    }
}
