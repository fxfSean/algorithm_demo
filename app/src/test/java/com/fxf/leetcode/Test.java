package com.fxf.leetcode;

class Test {
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    public static ComplexListNode clone(ComplexListNode head) {
// 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }
        // 先复制结点
        cloneNodes(head);
// 再链接sibling字段
        connectNodes(head);
// 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    private static void connectNodes(ComplexListNode head) {
        while (head != null) {
            if (head.sibling != null) {
                head.next.sibling = head.sibling.next;
            }
            head = head.next.next;
        }
    }

    public static ComplexListNode reconnectNodes(ComplexListNode
                                                         head) {
// 当链表为空就直接返回空
        if (head == null) {
            return null;
        }
// 用于记录复制链表的头结点
        ComplexListNode newHead = head.next;
// 用于记录当前处理的复制结点
        ComplexListNode pointer = newHead;

// 被复制结点的next指向下一个原链表结点
        head.next = newHead.next;
// 指向新的被复制结点
        head = head.next;
        while (head != null) {
// pointer指向复制结点
            pointer.next = head.next;
            pointer = pointer.next;
// head的下一个指向复制结点的下一个结点，即原来链表的结点
            head.next = pointer.next;
// head指向下一个原来链表上的结点
            head = pointer.next;
        }
// 返回复制链表的头结点
        return newHead;
    }

    public static void cloneNodes(ComplexListNode head) {
// 如果链表不空，进行复制操作
        while (head != null) {
// 创建一个新的结点
            ComplexListNode tmp = new ComplexListNode();
// 将被复制结点的值传给复制结点
            tmp.value = head.value;
// 复制结点的next指向下一个要被复制的结点
            tmp.next = head.next;
// 被复制结点的next指向复制结点
            head.next = tmp;
// 到些处就已经完成了一个结点的复制并且插入到被复制结点的后面 // heed指向下一个被复制结点的位置
            head = tmp.next;
        }
    }

    private void t(){
        int i = 1;
        i ^= 2;
        int[][] dp = new int[2][2];
    }

    int[] a = {1,3};

}