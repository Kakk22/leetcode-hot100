package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * 给你一棵二叉搜索树的root，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author 陈一锋
 * @date 2022/10/16 9:39 上午
 */
public class IncreasingBST {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5,
//                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
//                new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9))));
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        TreeNode node = new IncreasingBST().increasingBST(root);
        System.out.println(node);
    }

    /**
     *
     * 思路 中序遍历
     * 每次记录当前节点 中序遍历构建右子节点
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        currentNode = head;
        inorder(root);
        return head.right;
    }

    private TreeNode currentNode;

    public void inorder(TreeNode node) {
        if (node == null){
            return;
        }
        inorder(node.left);
        currentNode.right = node;
        node.left = null;
        currentNode = currentNode.right;
        inorder(node.right);
    }
}
