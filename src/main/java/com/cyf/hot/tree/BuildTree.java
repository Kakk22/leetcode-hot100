package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目:105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * 前序1,2,4,7,3,5,6,8 ，中序4,7,2,1,5,3,8,6；
 * preorder 和 inorder 均 无重复 元素
 *
 * @author 陈一锋
 * @date 2022/10/1 7:23 下午
 */
public class BuildTree {

    /**
     * 思路:1.从前序遍历中第一个元素找到root 在中序遍历中找到root下标  中序遍历中 root前为左子树 root后为右子树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 通过数组下标完成
     * 查看resource/buildTree.img
     */
    public TreeNode buildTree_01(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree_01(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree_01(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preorder.length == 0 || preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int preVal = preorder[preLeft];
        TreeNode node = new TreeNode(preVal);
        // 中数在中序数组的下标
        int index = map.get(preVal);

        //左子树节点数
        int leftSize = index - inLeft;

        //递归构建左子树 及前序列遍历数组中 除掉当前根节点(preLeft+1) 左子树的个数 leftSize = index - inLeft 得出
        node.left = buildTree_01(preorder, preLeft + 1, preLeft + leftSize, inLeft, index);
        //递归构建右子树
        node.right = buildTree_01(preorder, preLeft + leftSize + 1, preRight, index + 1, inRight);

        return node;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new BuildTree().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        TreeNode treeNode = new BuildTree().buildTree(new int[]{1, 2}, new int[]{2, 1});

        TreeNode treeNode_01 = new BuildTree().buildTree_01(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

//        System.out.println(treeNode);
        System.out.println(treeNode_01);
    }
}
