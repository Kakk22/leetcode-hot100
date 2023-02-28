package com.cyf.hot.linked;

import com.cyf.node.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 陈一锋
 * @date 2022/11/10 5:12 下午
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers bean = new AddTwoNumbers();
        ListNode res = bean.addTwoNumbers(node, node2);
        System.out.println(res);

        // -------------
        ListNode node01 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode node02 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(bean.addTwoNumbers_01(node01, node02));

    }

    /**
     * 解法1： 反转两条链表 进行相加后 再反转结果链表
     * 解法2 利用栈 先进后出
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //反转两个链表
        l1 = rever(l1);
        l2 = rever(l2);

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int car = 0;
        while (l1 != null || l2 != null || car != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = car + x + y;
            car = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return rever(res.next);
    }

    public ListNode rever(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    public ListNode addTwoNumbers_01(ListNode l1, ListNode l2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        while (l1 != null) {
            q1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            q2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;
        while (!q1.isEmpty() || !q2.isEmpty() || carry != 0){
            int x = q1.isEmpty() ? 0 : q1.pop();
            int y = q2.isEmpty() ? 0 : q2.pop();

            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode curNode = new ListNode(sum);
            curNode.next = res;
            res = curNode;
        }
        return res;
    }
}
