package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目： 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 * @author 陈一锋
 * @date 2022/10/8 11:21 下午
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        System.out.println(new FindBottomLeftValue().findBottomLeftValue(root));
        System.out.println(new FindBottomLeftValue().findBottomLeftValue_queue(root));
    }

    public int findBottomLeftValue_queue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }



    private int maxDeep = -1;
    private int ans= 0;

    /**
     *
     * 思路:全局记录一个最大深度 递归如果找到叶子节点深度最大 则返回该值 前序遍历 同一层有多个 只取第一个
     *
     */
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode node,int count){

        count++;

        if(node.left == null && node.right == null){
            if(count > maxDeep){
                ans = node.val;
                maxDeep = count;
            }
        }


        if(node.left != null){
            dfs(node.left,count);
        }
        if(node.right != null){
            dfs(node.right,count);
        }
    }
}
