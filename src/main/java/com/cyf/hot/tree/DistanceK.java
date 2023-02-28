package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 k 。
 * <p>
 * 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。
 *
 * @author 陈一锋
 * @date 2022/10/23 2:45 下午
 */
public class DistanceK {

    public static void main(String[] args) {
        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode root = new TreeNode(3,
                target,
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(new DistanceK().distanceK(root, target, 2));
    }


    Map<Integer, TreeNode> parentMap = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    /**
     * 思路:从target往下查到深度距离k的
     * 难点是 如何查到target父节点方向符合距离的结果
     * <p>
     * 1.先递归创建所有节点的与父节点的关系
     * 2.再递归查找左右子树满足深度的
     * 3.递归查到父节点的左右子树满足深度的
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dsfParent(root);

        findAns(target, null, 0, k);
        return ans;
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }

        //from 的判断是为了不走重复路线
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }

        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }

        if (parentMap.get(node.val) != from) {
            findAns(parentMap.get(node.val), node, depth + 1, k);
        }

    }

    private void dsfParent(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                parentMap.put(node.left.val, node);
                dsfParent(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right.val, node);
                dsfParent(node.right);
            }
        }
    }
}
