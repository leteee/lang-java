package com.example.binary_tree_search;

import java.util.Stack;

public class _230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0) {
                break;
            }
            cur = cur.right;
        }

        return cur.val;
    }

    public static void main(String[] args) {

    }
}
