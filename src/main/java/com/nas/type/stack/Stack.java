package com.nas.type.stack;

public class Stack<T> {

    private class Node {
        T data;
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node top;
    private int size;

    public Stack(){
        top = null;
        size = 0;
    }
    public void push(T data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println("|" + current.data + "|");
            current = current.next;
            if (current != null) {
                System.out.println(" -");
            }
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.printStack();

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.printStack();
        System.out.println(stack.size());
    }
}
