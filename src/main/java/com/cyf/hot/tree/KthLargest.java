package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * 思路：
 * 两种解法
 * 第一种:
 * 因为是二叉搜索树 通过中序遍历把树变成一个有序的数组，取数组长度-k 就得到第k大值的下标
 *
 * 第二种:
 * 中序遍历时，从右子树开始遍历,及先得到最大的树,记录一个变量c,当c等于k时 即找到第k大的数
 *
 * 明显第二种解法更优
 *
 * @author 陈一锋
 * @date 2022/10/6 10:49 上午
 */
public class KthLargest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        KthLargest bean = new KthLargest();
        System.out.println(bean.kthLargest_01(root, 1));
        System.out.println(bean.kthLargest_02(root, 1));
    }



    public int kthLargest_01(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        dfs_01(list,root);
        return list.get(list.size()-k);
    }

    public void dfs_01(List<Integer> list, TreeNode node){
        if(node == null){
            return;
        }
        dfs_01(list,node.left);
        list.add(node.val);
        dfs_01(list,node.right);
    }

    private int ans = 0 , count = 0;
    public int kthLargest_02(TreeNode root, int k) {
        dfs_02(k,root);
        return ans;
    }

    public void dfs_02(int k , TreeNode node){

        if(node.right != null){
            dfs_02(k,node.right);
        }
        if(++count == k){
            ans = node.val;
            return;
        }
        if(node.left != null){
            dfs_02(k,node.left);
        }
    }
}
