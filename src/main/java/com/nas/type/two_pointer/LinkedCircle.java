package com.nas.type.two_pointer;

public class LinkedCircle {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;

        LinkedCircle solution = new LinkedCircle();
        System.out.println(solution.hasCycle(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;

        System.out.println(solution.hasCycle(head2));

        ListNode head3 = new ListNode(1);

        System.out.println(solution.hasCycle(head3));
    }
}
