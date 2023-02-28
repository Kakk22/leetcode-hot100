package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**142. 环形链表 II
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * @author 陈一锋
 * @date 2022/11/13 11:42 上午
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode last = new ListNode(-4);
        ListNode node = new ListNode(2,new ListNode(0));
        node.next=  last;
        last.next = node;
        ListNode head = new ListNode(3, node);
        ListNode result = new DetectCycle().detectCycle(head);
        System.out.println(result.val);
    }
    // 快慢指针 快指针每次走两步 慢指针每次走一步
    // 当两者相等时 则存在环
    // 存在环后 快指针从头开始走 每次走1一步 慢指针在相遇位置走 每次走一步
    // 当指针再次相遇时 则为环入口
    // 解法推倒 https://leetcode.cn/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow ==fast){
                break;
            }
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
