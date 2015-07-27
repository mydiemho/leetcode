package Utilities;

/**
 * Created by myho on 7/6/15.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return val + ", " +
                next;
    }
}
