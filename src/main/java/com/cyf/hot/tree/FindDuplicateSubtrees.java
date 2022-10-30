package com.cyf.hot.tree;

import com.cyf.node.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * <p>
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 *
 * @author 陈一锋
 * @date 2022/10/30 10:23 下午
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(root));

    }

    private Map<String, TreeNode> map = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();

    /**
     * 思路 序列化树 比较序列化 如果相同则说明 结构相同 节点值相同
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        seri(root);
        return new ArrayList<>(set);
    }

    public String seri(TreeNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append("(").append(seri(node.left)).append(")");
        sb.append("(").append(seri(node.right)).append(")");
        sb.append(")");

        String s = sb.toString();
        if (map.containsKey(s)) {
            set.add(map.get(s));
        } else {
            map.put(s, node);
        }
        return s;
    }
}
