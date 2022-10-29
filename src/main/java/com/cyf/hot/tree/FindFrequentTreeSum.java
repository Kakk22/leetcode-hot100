package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * @author 陈一锋
 * @date 2022/10/29 7:27 下午
 */
public class FindFrequentTreeSum {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-5));
        System.out.println(Arrays.toString(new FindFrequentTreeSum().findFrequentTreeSum(root)));
    }

    int maxCount = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = dfs(node.left) + dfs(node.right) + node.val;
        Integer count = map.get(sum);
        count = count == null ? 1 : count + 1;
        map.put(sum, count);

        maxCount = Math.max(maxCount, count);

        return sum;
    }
}
