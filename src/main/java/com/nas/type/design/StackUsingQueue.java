package com.nas.type.design;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {

    }

    public int pop() {
        return 0;
    }

    public int top() {
        return 0;
    }

    public boolean empty() {
        return false;
    }
}
