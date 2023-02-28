package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**
 * 题目：147. 对链表进行插入排序
 * 给定单个链表的头head，使用 插入排序 对链表进行排序，并返回排序后链表的头。
 *
 * 插入排序算法的步骤:
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 *
 * 对链表进行插入排序。
 *
 * https://leetcode.cn/problems/insertion-sort-list/
 *
 * 4 -> 2 -> 1 -> 3
 *
 * 1 -> 2 -> 3 -> 4
 *
 * 
 * @author 陈一锋
 * @date 2022/11/11 9:27 下午
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode listNode = new InsertionSortList().insertionSortList(node);
        System.out.println(listNode);
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0,head);
        ListNode cur = res.next;

        while(cur != null && cur.next != null){
            if(cur.next.val < cur.val){
                ListNode temp = cur.next.next;
                ListNode target = cur.next;

                ListNode point = res;
                while(point != null && point.next != null){
                    if(target.val < point.next.val){
                        ListNode node = point.next;
                        point.next = target;
                        target.next = node;
                        break;
                    }
                    point = point.next;
                }
                cur.next = temp;
            }else{
                cur = cur.next;
            }
        }
        return res.next;
    }

}
