package TreeAndGraph;

import Utilities.TreeNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    private static class MaxRootAndLocalPathSums {
        int rootSum;
        int localSum;

        public MaxRootAndLocalPathSums(int maxRoot, int maxLocal) {
            this.rootSum = maxRoot;
            this.localSum = maxLocal;
        }
    }

    public static int maxPathSum(TreeNode root) {
        MaxRootAndLocalPathSums result = getMaxRootAndLocalPathSums(root);
        return Math.max(result.rootSum, result.localSum);
    }

    private static MaxRootAndLocalPathSums getMaxRootAndLocalPathSums(TreeNode root) {
        int val = root.val;

        Set<Integer> possibleRoots = new HashSet<>();
        possibleRoots.add(val);

        Set<Integer> possibleLocals= new HashSet<>();

        MaxRootAndLocalPathSums leftResult = new MaxRootAndLocalPathSums(0, 0);
        if(root.left != null) {
            leftResult = getMaxRootAndLocalPathSums(root.left);
            int leftRootSum = leftResult.rootSum;
            int leftLocalSum = leftResult.localSum;

            possibleRoots.add(val + leftRootSum);
            possibleLocals.add(leftLocalSum);
        }

        MaxRootAndLocalPathSums rightResult = new MaxRootAndLocalPathSums(0, 0);
        if(root.right != null) {
            rightResult = getMaxRootAndLocalPathSums(root.right);
            int rightRootSum = rightResult.rootSum;
            int rightLocalSum = rightResult.localSum;

            possibleRoots.add(val + rightRootSum);
            possibleLocals.add(rightLocalSum);
        }

        if(root.right != null && root.left != null) {
            possibleLocals.add(val + leftResult.rootSum + rightResult.rootSum);
        }

        int maxRoot = possibleRoots.isEmpty() ? 0 : Collections.max(possibleRoots);
        int maxLocal = Math.max(maxRoot, possibleLocals.isEmpty() ? 0 : Collections.max(possibleLocals));

        return new MaxRootAndLocalPathSums(maxRoot, maxLocal);
    }

    public int maxPathSumOld(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));

    }
}
