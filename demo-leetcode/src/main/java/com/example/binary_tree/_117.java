package com.example.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _117 {

    public Node connect(Node root) {
        //层序遍历
        if (root == null) {
            return null;
        }
        Queue<Node> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
