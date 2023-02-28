package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * @author 陈一锋
 * @date 2022/11/6 1:09 上午
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates bean = new DeleteDuplicates();
        ListNode node_01 = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println(bean.deleteDuplicates(node_01));

        ListNode node_02 = new ListNode(1, new ListNode(1, new ListNode(1)));
        System.out.println(bean.deleteDuplicates(node_02));

        ListNode node_03 = new ListNode(1, new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(3)))));
        System.out.println(bean.deleteDuplicates(node_03));
    }

    /**
     * 如果当前节点的下一个节点与当前节点值一致 则删除下一个节点 指针不动
     * 如果当前节点与下一个节点值不同 则指针向下移动
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
