package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.*;

/**
 * @author 陈一锋
 * @date 2022/10/15 2:55 下午
 */
public class AverageOfLevels {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(17)));
//        new AverageOfLevels().averageOfLevels(root);
        System.out.println(((double)29)/2);
    }


    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Double> res = new ArrayList<>();
        while(!q.isEmpty()){
            int total = q.size();
            int size = q.size();
            int sum = 0;
            while(size > 0){
                size -- ;
                TreeNode n = q.remove();
                sum += n.val;
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
            double d = (sum / total);
            res.add(d);

        }
        return res;
    }
}
