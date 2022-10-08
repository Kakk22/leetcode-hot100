package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * @author 陈一锋
 * @date 2022/10/7 3:46 下午
 */
public class BuildTreeTwo {

    public static void main(String[] args) {
        //inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        BuildTreeTwo bean = new BuildTreeTwo();
        TreeNode node = bean.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(node);

//        TreeNode node_01 = bean.buildTree(new int[]{1,2}, new int[]{2,1});
//        System.out.println(node_01);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(postorder,map,postorder.length-1,0,inorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, Map<Integer,Integer> map ,int postRight,int inLeft,int inRight){
        if(inLeft > inRight){
            return null;
        }

        int midVal = postorder[postRight];
        //父节点在中序数组中的下标
        int idx = map.get(midVal);
        TreeNode node = new TreeNode(midVal);

        node.left = buildTree(postorder,map,postRight - (inRight - idx) -1, inLeft, idx -1);
        node.right = buildTree(postorder,map,postRight-1,idx+1,inRight);

        return node;
    }
}
