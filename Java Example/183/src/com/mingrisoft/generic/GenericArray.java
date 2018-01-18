package com.mingrisoft.generic;

import java.lang.reflect.Array;

public class GenericArray<T> {
    
    private T[] array;
    private int size;
    
    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> type, int size) {
        this.size = size;
        array = (T[]) Array.newInstance(type, size);
    }
    
    public void put(int index, T item) {
        if (size > index) {
            array[index] = item;
        }
    }
    
    public T get(int index) {
        
        if (size > index) {
            return array[index];
        } else {
            return null;
        }
    }
}
