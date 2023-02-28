package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在 32 位 带符号整数范围内。
 * <p>
 *
 * @author 陈一锋
 * @date 2022/10/20 9:18 下午
 */
public class WidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        System.out.println(new WidthOfBinaryTree().widthOfBinaryTree(root));
    }


    /**
     * 思路 给每个节点都记录一个编号, 每层的宽度等于最右节点减掉最左节点+1
     * 左节点下标等于 当前节点下标 * 2 + 1
     * 右节点下标等于 当前节点下标 * 2 + 2
     */
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));

        int ans = 0;
        while (!q.isEmpty()) {
            ans = Math.max((q.peekLast().val - q.peekFirst().val) + 1, ans);
            int size = q.size();
            while (size > 0) {
                size--;
                Node node = q.remove();
                TreeNode treeNode = node.treeNode;
                //当前节点下标
                int val = node.val;
                if (treeNode.left != null) {
                    q.add(new Node(treeNode.left, val * 2 + 1));
                }
                if (treeNode.right != null) {
                    q.add(new Node(treeNode.right, val * 2 + 2));
                }
            }
        }
        return ans;
    }

    class Node {
        TreeNode treeNode;
        int val;

        public Node(TreeNode treeNode, int val) {
            this.treeNode = treeNode;
            this.val = val;
        }
    }
}
