package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈一锋
 * @date 2022/10/7 3:46 下午
 */
public class BuildTreeTwo {

    public static void main(String[] args) {
        //inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        BuildTreeTwo bean = new BuildTreeTwo();
//        TreeNode node = bean.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(node);

        TreeNode node_01 = bean.buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(node_01);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(postorder,map,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] postorder, Map<Integer,Integer> map, int postLeft, int postRight){
        if(postLeft > postRight){
            return null;
        }

        int midVal = postorder[postRight];
        //父节点在中序数组中的下标
        int idx = map.get(midVal);
        TreeNode node = new TreeNode(midVal);

        int leftSize = idx - postLeft - 1;
        node.left = buildTree(postorder,map,postLeft,leftSize);
        node.right = buildTree(postorder,map,leftSize + 1,postRight-1);

        return node;
    }
}
