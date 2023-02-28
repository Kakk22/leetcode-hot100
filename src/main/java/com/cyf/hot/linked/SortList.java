package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**
 * 将链表排序
 *
 * 5 -> 2 -> 1 -> 4 -> 3
 *
 * 1 -> 2 -> 3- > 4 -> 5
 * @author 陈一锋
 * @date 2022/11/7 9:00 下午
 */
public class SortList {

    public static void main(String[] args) {
        ListNode node = new ListNode(5, new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3)))));
        System.out.println(new SortList().sortList(node));
    }

    /**
     * 思路:
     * 1.快慢指针找到中间节点
     * 2.归并左链表和右链表
     * 3.合并两个有序链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //没有头节点的快慢指针 fast要比慢指针快一步
        ListNode fast = head.next, slow = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        //归并
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        //合并两个有序链表
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = left != null ? left : right;
        return res.next;
    }
}
