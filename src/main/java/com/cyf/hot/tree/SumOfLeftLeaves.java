package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * 题目
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * @author 陈一锋
 * @date 2022/10/5 11:37 上午
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
    }


    private int sum = 0;

    /**
     * 找到所有左叶子节点相加即可
     * 递归时 如何找到左叶子节点？
     * 当前节点的左节点不为空且是叶子节点则找到
     *
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        //找到左叶子节点
        if(root.left != null && (root.left.left == null && root.left.right==null)){
            sum = sum + root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
