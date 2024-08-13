package com.nas.type.design;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        System.out.println(queue1);
        System.out.println(queue2);

        queue2.add(x);

        System.out.println(queue1);
        System.out.println(queue2);


        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        System.out.println(queue1);
        System.out.println(queue2);

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.poll();
    }

    public int top() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {

    }
}
