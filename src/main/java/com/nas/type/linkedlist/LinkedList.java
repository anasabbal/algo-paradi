package com.nas.type.linkedlist;

public class LinkedList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    public void add(T data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    private void printList(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }
    private void remove(T data){
        if(head == null){
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)){
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printList();
    }
    public T get(int index){

    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
