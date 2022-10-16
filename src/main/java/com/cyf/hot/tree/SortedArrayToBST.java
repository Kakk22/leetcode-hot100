package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author 陈一锋
 * @date 2022/10/5 11:12 上午
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        TreeNode node = new SortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }

    /**
     * 思路: 由于数组是递增的,索引以数组中位数为节点 二分递归构建树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     * left 和 right 为左闭区间 和 右闭区间 [left,right]
     */
    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //表示奇数取中间 偶数取左边的数
        int mid = left  +((right - left) / 2);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);
        return node;
    }
}
