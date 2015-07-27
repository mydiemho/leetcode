package LinkedList;

import Utilities.ListNode;

/**
 * Created by myho on 7/12/15.
 */

/*
 * https://leetcode.com/problems/partition-list/
 */
public class Partition {

    // partition a linked list around a value x such that all nodes < x comes before all node >= x
    // input: 3 -> 5 -> 8 -> 5 -> 10 ->  2 -> 1 (x = 5)
    // output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
    public static ListNode partition(ListNode node, int x)
    {
        // nodes that are < x
        ListNode beforeStart = null;
        ListNode beforeEnd = null;

        // nodes that are >= x
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while(node != null) {
            ListNode next = node.next;
            node.next = null;

            if(node.val < x) {
                if(beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if(afterStart == null) {
                    afterStart = node;
                    afterEnd = node;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }

            node = next;
        }

        // joined 2 lists
        if(beforeEnd == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
