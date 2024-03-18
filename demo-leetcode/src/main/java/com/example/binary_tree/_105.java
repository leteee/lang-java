package com.example.binary_tree;

import java.util.HashMap;
import java.util.Map;

public class _105 {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int preorderRoot = pl;
        int rootVal = preorder[preorderRoot];
        int inorderRoot = indexMap.get(rootVal);
        //根节点
        TreeNode root = new TreeNode(rootVal);
        int sizeLeft = inorderRoot - il;
        // 左子树
        root.left = buildTree(preorder, inorder, pl + 1, pl + sizeLeft, il, inorderRoot - 1);
        //右子树
        root.right = buildTree(preorder, inorder, pl + sizeLeft + 1, pr, inorderRoot + 1, ir);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = new _105().buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
