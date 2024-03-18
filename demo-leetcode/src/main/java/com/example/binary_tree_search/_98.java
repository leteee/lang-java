package com.example.binary_tree_search;

import java.util.Queue;
import java.util.Stack;

public class _98 {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double preVal = -Double.MAX_VALUE;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (preVal >= cur.val) {
                return false;
            }
            preVal = cur.val;
            cur = cur.right;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
