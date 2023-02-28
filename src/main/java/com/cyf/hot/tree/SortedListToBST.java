package com.cyf.hot.tree;

import com.cyf.node.ListNode;
import com.cyf.node.TreeNode;

/**
 * 题目:有序链表转换二叉搜索树
 * 给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
 *
 *
 *
 * @author 陈一锋
 * @date 2022/10/11 8:39 下午
 */
public class SortedListToBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode node = new SortedListToBST().sortedListToBST(head);
        System.out.println(node);
    }


    /**
     *  思路:找到中间的节点 左边构建左子树 右边构建右子树
     *  1.链表如何找到中间节点:快慢指针 快指针每次都两步 慢指针每次走一步 快指针走到尾时 则慢指针走到中间位置
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            // 快指针每次走两步
            fast = fast.next.next;
            //记录慢指针前面一个节点
            pre = slow;
            //慢指针每次走一步
            slow  = slow.next;
        }

        pre.next = null;
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);

        return node;
    }
}
