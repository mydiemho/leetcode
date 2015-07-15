package TreeAndGraph;

import Utilities.TreeNode;

/**
 * Created by myho on 7/6/15.
 */

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        // edge case: null check
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        // edge case: no children nodes
        if(root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);

        // because the path may start and end at any node, and
        // a node's value may be negative which will diminish the sum
        // we need to do more checks

        // need to check 4 cases
        // 1. only take root
        // 2. take root + left
        // 3. take root + right
        // 4. left + root + right

        int leftSumWithRoot = leftSum + root.val;
        int rigthSumWithRoot = rightSum + root.val;
        int sumAll = leftSum + root.val + rightSum;

        int[] sums = {root.val, leftSum, rightSum, leftSumWithRoot, rigthSumWithRoot, sumAll};

        return 0;
    }
}
