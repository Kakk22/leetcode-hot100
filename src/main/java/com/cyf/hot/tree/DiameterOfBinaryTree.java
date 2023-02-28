package com.cyf.hot.tree;
/**
 * 题目:二叉树的直径
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * <p>
 * <p>
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */


import com.cyf.node.TreeNode;

/**
 * @author 陈一锋
 * @date 2022/7/26 9:49 下午
 */
public class DiameterOfBinaryTree {

    private int max;

    /**
     * 求两个节点的最大值,其实就是求树的深度
     */
    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }

    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDeep = deep(node.left);
        int rightDeep = deep(node.right);
        max = Math.max(max, (leftDeep + rightDeep));
        //+1是当前层
        return Math.max(leftDeep, rightDeep) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node));
    }
}
