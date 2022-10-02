package com.cyf.hot.tree;

import com.cyf.node.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * @author 陈一锋
 * @date 2022/10/2 4:33 下午
 */
public class Connect {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        Node connect = new Connect().connect(node);
    }


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        //层序遍历
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node preNode = null;
            int size = q.size();
            while (size > 0) {
                size--;
                Node node = q.poll();
                if (preNode != null) {
                    preNode.next = node;
                }
                preNode = node;
                if (size == 0) {
                    node.next = null;
                }
                if (node.left!=null){
                    q.add(node.left);

                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }

        }
        return root;
    }

    //递归版本
    public Node connect_01(Node root){
        if(root == null){
            return root;
        }
        //递归版本
        if(root.left != null){
            root.left.next = root.right;
        }
        //如果当前的next不为空 则当前节点的右节点的next是 当前节点的next的左节点
        //因为递归从上往下 上层已经建立好next的关系
        if(root.right !=null && root.next !=null){
            root.right.next = root.next.left;
        }
        connect_01(root.left);
        connect_01(root.right);
        return root;
    }
}
