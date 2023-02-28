package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * @author 陈一锋
 * @date 2022/10/26 8:13 下午
 */
public class InorderSuccessor {

    public static void main(String[] args) {
        TreeNode target = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        TreeNode root = new TreeNode(5, target, new TreeNode(6));
        System.out.println(new InorderSuccessor().inorderSuccessor(root, target));
    }

    /**
     *  思路:二分查找 往下递归时记录返回值
     *  如果 当前节点比目标节点大 则返回值是当前节点 下次循环左子节点
     *  如果 当前节点比目标节点小或者等于 则下次循环右子节点
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int target = p.val;
        TreeNode res = null;
        while (root != null) {
            if (root.val > target) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
