package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 * @author 陈一锋
 * @date 2022/10/9 8:36 下午
 */
public class IsBalanced {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(new IsBalanced().isBalanced(root));
    }

    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return res;
        }
        deep(root);
        return res;
    }

    /**
     *  思路:递归求树的深度 当出现左树深度与右树深度相差超过1 则全局记录返回值false
     */
    public int deep(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = deep(node.left);
        int right = deep(node.right);
        if(Math.abs(left - right) > 1){
            res = false;
        }
        return Math.max(left,right) + 1;
    }

}
