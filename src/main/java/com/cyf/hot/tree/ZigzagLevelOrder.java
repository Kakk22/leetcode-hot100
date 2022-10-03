package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author 陈一锋
 * @date 2022/10/3 10:29 上午
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();

        //双端队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            while (size > 0) {
                size--;
                TreeNode node = q.poll();
                if (flag){
                    levelList.offerFirst(node.val);
                }else {
                    levelList.offerLast(node.val);
                }
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }
            flag = !flag;
            res.add(levelList);
        }
        return res;
    }
}
