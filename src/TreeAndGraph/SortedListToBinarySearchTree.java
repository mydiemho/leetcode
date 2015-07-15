package TreeAndGraph;

import Utilities.LinkedListNode;
import Utilities.TreeNode;

/**
 * Created by myho on 7/6/15.
 */
public class SortedListToBinarySearchTree {

    /*
    https://leetcode.com/discuss/32902/my-simple-java-solution
     */
    public TreeNode sortedListToBST(LinkedListNode head) {

        if (head == null) {
            return null;
        }

        // find middle element to use as root
        LinkedListNode rootNode = head;

        LinkedListNode fast = head;

        // this point to the node before the middle element
        LinkedListNode leftEnd = null;

        // Even length: mid = (len /2)  - 1
        // Odd length: mid = floor(len/2)
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            leftEnd = rootNode;
            rootNode = rootNode.next;
        }

        if (leftEnd != null) {
            // break the link since the next element will become the root of the tree
            leftEnd.next = null;
        } else {
            // case of length <= 2
            head = null;
        }

        TreeNode root = new TreeNode(rootNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rootNode.next);

        return root;
    }

    public TreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if(end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = createMinimalBST(arr, start, mid-1);
        root.right = createMinimalBST(arr, mid+1, end);

        return root;
    }

    /*
    https://leetcode.com/discuss/39089/simple-o-n-java-solution-with-hashmap
     */
}
