package com.nas.type.two_pointer;

public class InterSectionTwoLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null){
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }

            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
    public static void main(String[] args) {
        ListNode intersectNode = new ListNode(8);
        intersectNode.next = new ListNode(4);
        intersectNode.next.next = new ListNode(5);

        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = intersectNode;

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next = intersectNode;

        InterSectionTwoLinkedList solution = new InterSectionTwoLinkedList();
        ListNode intersection = solution.getIntersectionNode(listA, listB);

        if (intersection != null) {
            System.out.println("Intersected at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
