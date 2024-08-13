package com.nas.type.design;


import com.nas.type.stack.Stack;

public class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {

        QueueUsingStack myQueue = new QueueUsingStack();
        myQueue.push(1);
        myQueue.push(2);

        // Test the peek operation
        System.out.println(myQueue.peek());  // Output: 1

        // Test the pop operation
        System.out.println(myQueue.pop());   // Output: 1

        // Test the empty operation
        System.out.println(myQueue.empty()); // Output: false

        // Pop the remaining element
        System.out.println(myQueue.pop());   // Output: 2

        // Test the empty operation after popping all elements
        System.out.println(myQueue.empty());
    }
}
