package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * @author 陈一锋
 * @date 2022/10/28 8:50 下午
 */
public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        new SumRootToLeaf().sumRootToLeaf(root);
    }

    private int sum = 0;

    /**
     * 思路 后序遍历 每进入一层 则算出当前节点的二进制和,如果是叶子节点 则累加到sum参数
     */
    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private int helper(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        // 二进制 两数 相拼
        preSum = preSum * 2 + root.val;
        if (root.left == null && root.right == null) {
            sum += preSum;
        }
        return helper(root.left, preSum) + helper(root.right, preSum);
    }
}
