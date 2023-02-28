package com.cyf.hot.linked;

import com.cyf.node.ListNode;

/**
 * @author 陈一锋
 * @date 2022/11/12 10:36 上午
 */
public class MyLinkedList {
    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = new ListNode(0, null);
        size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index <= 0){
            this.addAtHead(val);
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0){
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if(cur.next != null){
            cur.next = cur.next.next;
        }
        size--;
    }
}

class Client{
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);

        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList);

        MyLinkedList myLinkedList_01 = new MyLinkedList();
        myLinkedList_01.addAtHead(4);
        System.out.println(myLinkedList_01.get(1));
        myLinkedList_01.addAtHead(1);
        myLinkedList_01.addAtHead(5);
        myLinkedList_01.deleteAtIndex(3);
        myLinkedList_01.addAtHead(7);
        System.out.println(myLinkedList_01.get(3));
        System.out.println(myLinkedList_01.get(3));
        System.out.println(myLinkedList_01.get(3));
        myLinkedList_01.addAtHead(1);
        myLinkedList_01.deleteAtIndex(4);

    }
}
