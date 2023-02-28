package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * @author 陈一锋
 * @date 2022/10/3 11:16 下午
 */
public class MirrorTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode treeNode = new MirrorTree().mirrorTree(root);
        System.out.println(treeNode);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
