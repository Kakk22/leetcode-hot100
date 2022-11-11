package com.cyf.hot.linked;

import com.cyf.node.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
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
