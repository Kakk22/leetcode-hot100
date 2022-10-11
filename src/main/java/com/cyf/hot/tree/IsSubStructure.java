package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

/**
 * @author 陈一锋
 * @date 2022/10/4 10:07 上午
 */
public class IsSubStructure {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
//        TreeNode b = new TreeNode(4, new TreeNode(1), null);
        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(-4), new TreeNode(-3)), new TreeNode(1));
        TreeNode b = new TreeNode(1, new TreeNode(-4), null);
        IsSubStructure bean = new IsSubStructure();
        boolean resbool = bean.isSubStructure(root, b);
        System.out.println(resbool);
        ;
    }

    //
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        // 此处递归是为了找root一致的节点
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    // 这个方法递归是查找当根节点一致时，左右子树是否一致
    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }

        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
