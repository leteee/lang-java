package com.example.binary_tree;

public class _124 {

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        maxPathSum = Math.max(maxPathSum, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {

    }
}
