package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 * |
 * 1 -> 2 -> 5
 * <p>
 * <p>
 * 1 -> 1 -> 1 -> 2  -> 3
 * |
 * 2 -> 3
 *
 * @author 陈一锋
 * @date 2022/11/6 9:37 上午
 */
public class DeleteDuplicates02 {

    public static void main(String[] args) {
        DeleteDuplicates02 bean = new DeleteDuplicates02();
        ListNode node_01 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println(bean.deleteDuplicates(node_01));

        ListNode node_02 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3 )))));
        System.out.println(bean.deleteDuplicates(node_02));
    }

    /**
     *  思路:
     *  1.当前指针前节点pre,当前指针判断下一个节点是否与当前节点值相等 如果相等 则走到最后一个相等的节点 end
     *  2.将pre的下一个节点指向 end.next 进行下个循环 此时pre不动
     *  3.如果当前节点与下一个节点不相等 则pre走向下一个节点 继续循环
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode pre = res;

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
