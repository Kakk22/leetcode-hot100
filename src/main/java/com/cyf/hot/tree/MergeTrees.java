package com.cyf.hot.tree;

import com.cyf.node.ListNode;
import com.cyf.node.TreeNode;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 */

/**
 * @author 陈一锋
 * @date 2022/7/26 10:11 下午
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //合并根节点
        root1.val += root2.val;
        //合并左子树
        root1.left = mergeTrees(root1.left, root2.left);
        //合并右子树
        root2.right = mergeTrees(root2.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));
        TreeNode right = new TreeNode(2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));
        TreeNode treeNode = new MergeTrees().mergeTrees(left, right);
    }
}
