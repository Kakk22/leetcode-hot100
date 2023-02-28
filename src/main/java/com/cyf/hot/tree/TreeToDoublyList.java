package com.cyf.hot.tree;

import com.cyf.node.Node;

import java.util.LinkedList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 解法1.中序遍历存储到双端队列, 遍历队列构建关系
 * 解法2.中序遍历递归 完成节点关系构建
 *
 * @author 陈一锋
 * @date 2022/10/8 8:36 下午
 */
public class TreeToDoublyList {

    public static void main(String[] args) {
        Node node = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        Node n = new TreeToDoublyList().treeToDoublyList(node);
        System.out.println(n);

        Node node_01 = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        Node n2 = new TreeToDoublyList().treeToDoublyList_01(node_01);
        System.out.println(n2);
    }

    /**
     * 借助双端队列完成
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        dfs(root, linkedList);

        Node res = linkedList.getFirst();

        Node pre = linkedList.getLast();
        while (!linkedList.isEmpty()) {
            Node n = linkedList.poll();
            n.right = linkedList.peek() == null ? res : linkedList.peek();
            n.left = pre;
            pre = n;
        }
        return res;
    }

    public void dfs(Node node, LinkedList<Node> linkedList) {
        if (node == null) {
            return;
        }
        dfs(node.left, linkedList);
        linkedList.add(node);
        dfs(node.right, linkedList);
    }

    private Node pre, head;

    public Node treeToDoublyList_01(Node root) {
        if (root == null) {
            return null;
        }

        dfs_01(root);

        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs_01(Node node) {
        if (node == null) {
            return;
        }
        dfs_01(node.left);
        if (pre != null) {
            pre.right = node;
        } else {
            //找到头节点
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs_01(node.right);
    }
}
