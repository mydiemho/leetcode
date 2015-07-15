package Utilities;

/**
 * Created by myho on 7/6/15.
 */
public class LinkedListNode {
    public int val;
    public LinkedListNode next;

    public LinkedListNode(int x) {
        val = x;
    }

    public LinkedListNode() {
    }

    @Override
    public String toString() {
        return val + ", " +
                next;
    }
}
