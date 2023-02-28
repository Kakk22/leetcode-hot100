package com.cyf.hot.tree;

import com.cyf.node.TreeNode;


/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * @author 陈一锋
 * @date 2022/10/6 11:29 上午
 */
public class DeleteNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        DeleteNode bean = new DeleteNode();
//        bean.deleteNode(root, 3);
        bean.deleteNode(root, 0);
        System.out.println(root);

//        TreeNode root1 = new TreeNode(50, new TreeNode(30, null, new TreeNode(40)), new TreeNode(70, new TreeNode(60), new TreeNode(80)));
//        bean.deleteNode(root1, 50);
//        System.out.println(root1);
    }


    /**
     *
     * 思路
     *  第一种情况：没找到删除的节点，遍历到空节点直接返回了
     * 找到删除的节点
     * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
     * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
     * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
     * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            //递归查找左子树 删除了则返回新的节点
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            //找到相等的值
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //根节点为删除节点且左右子树都不为空
            //1.找到右节点最小的节点
            //2.将左子树节点 作为 最小节点的子节点
            TreeNode newRoot = root.right;
            TreeNode minRight = root.right;
            while (minRight.left != null) {
                minRight = minRight.left;
            }
            minRight.left = root.left;
            return newRoot;
        }

        return root;
    }

}
