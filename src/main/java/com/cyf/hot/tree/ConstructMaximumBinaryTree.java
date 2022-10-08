package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * @author 陈一锋
 * @date 2022/10/8 10:59 下午
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(node);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return dfs(nums,0,nums.length-1);
    }

    public TreeNode dfs(int[] nums,int start,int end){
        if(start > end){
            return null;
        }

        int maxVal = nums[start];
        int maxIdx = start;
        for(int i = start;i<= end;i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(maxVal);
        node.left = dfs(nums,start,maxIdx-1);
        node.right = dfs(nums,maxIdx+1,end);
        return node;
    }
}
