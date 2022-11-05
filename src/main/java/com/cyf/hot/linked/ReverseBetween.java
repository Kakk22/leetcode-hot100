package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 1 -> 2 -> 3 -> 4 -> 5  left = 2 right = 4
 *
 * 1 -> 4 -> 3 -> 2 -> 5
 *
 *
 * @author 陈一锋
 * @date 2022/11/5 11:01 上午
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new ReverseBetween().reverseBetween(node, 2, 4);
        System.out.println(listNode);
    }

    /**
     *  思路:
     *  1. 快慢指针 快指针先走到right处 保存 right的next节点 end
     *  2. 慢指针 走到left处 保存 left前一个节点 tail
     *  3. 反转 left -> right 的链表
     *  4. 将 tail的next 指向 right节点
     *  5. 将 right 的next 指向 end节点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);


        ListNode fast = res;
        for (int i = 0; i < right; i++) {
            fast = fast.next;
        }


        ListNode cur = res;
        ListNode tail = cur;
        int k = 0;
        for (int i = 0; i < left; i++) {
            cur = cur.next;
            k++;
            if (k+1 == left) {
                tail = cur;
            }
        }

        head = fast;

        //反转链表

        // 需要连接的下一个节点
        ListNode end = fast.next;
        ListNode pre = fast.next;
        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        tail.next = head;
        return res.next;
    }
}
