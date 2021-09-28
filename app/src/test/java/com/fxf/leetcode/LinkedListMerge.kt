package com.fxf.leetcode

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 */
class LinkedListMerge {

    fun merge(head1: ListNode?,head2: ListNode?): ListNode?{
        if (head1 == null){
            return head2
        }
        if (head2 == null){
            return head1
        }

        var root: ListNode = ListNode(0)
        var pointer = root
        var temp1 = head1
        var temp2 = head2
        while (temp1 != null && temp2 != null){
            if (temp1.value < head2.value){
                pointer.next = temp1
                temp1 = temp1.next
            } else {
                pointer.next = temp2
                temp2 = temp2.next
            }
            pointer = pointer.next!!
        }

        if (temp1 == null){
            pointer.next = temp2
        }

        if (temp2 == null){
            pointer.next = temp1
        }

        return root.next
    }
}