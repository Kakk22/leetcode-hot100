package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author 陈一锋
 * @date 2022/10/3 11:55 下午
 */
public class PathSumTow {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(new PathSumTow().pathSum(root, 22));
    }


    private List<List<Integer>> res = new ArrayList<>();

    /**
     *  每次进入一层则将目标数减掉当前节点的值,递归到叶子节点则只需要判断叶子节点的值与目标值是否一致
     *  这个有个难点是递归搜索找到节点后list如何处理
     *  1.每进入一层，则将当前节点加入list
     *  2.如果叶子节点等于目标值,则当前list满足条件,复制list到结果集
     *  3.如果没满足则递归求左子树和右子树
     *  4.递归结束 返回上一层时,要把当前节点的值从list中移除，因为如果不满足则不需要加入，满足的话会拷贝一份到结果集
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> cur = new LinkedList<>();
        pathSum(root, targetSum, cur);
        return res;
    }

    private void pathSum(TreeNode node, int targetSum, LinkedList<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            //找到叶子结点
            res.add(new ArrayList<>(list));
        } else {
            pathSum(node.left, targetSum - node.val, list);
            pathSum(node.right, targetSum - node.val, list);
        }
        list.removeLast();
    }
}
