package com.mingrisoft.generic;

import java.util.LinkedList;

public class Stack<T> {
    
    private LinkedList<T> container = new LinkedList<T>();
    
    public void push(T t) {
        container.addFirst(t);
    }
    
    public T pop() {
        return container.removeFirst();
    }
    
    public boolean empty() {
        return container.isEmpty();
    }
}
