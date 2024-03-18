package com.example.binary_tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = que.poll();
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
                if (i == n - 1) {
                    ans.add(cur.val);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
