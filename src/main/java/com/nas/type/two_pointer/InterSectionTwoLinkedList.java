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

    /**
     * Finds the intersection node of two singly linked lists.
     *
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the node at which the intersection of the two linked lists begins, or null if there is no intersection
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) { // check if both lists are null
            return null; // if both are null, return null as there is no intersection
        }
        ListNode pointerA = headA; // initialize pointerA to the head of the first list
        ListNode pointerB = headB; // initialize pointerB to the head of the second list

        while (pointerA != pointerB) { // loop until the two pointers meet
            if (pointerA == null) { // check if pointerA has reached the end of the first list
                pointerA = headB; // switch pointerA to the head of the second list
            } else {
                pointerA = pointerA.next; // move pointerA to the next node
            }

            if (pointerB == null) { // check if pointerB has reached the end of the second list
                pointerB = headA; // switch pointerB to the head of the first list
            } else {
                pointerB = pointerB.next; // move pointerB to the next node
            }
        }

        return pointerA; // return the intersection node or null if no intersection
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
