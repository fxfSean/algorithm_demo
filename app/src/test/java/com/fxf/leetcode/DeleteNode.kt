package com.fxf.leetcode

/**
 * 给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点
 */
class DeleteNode {
    fun deleteNode(head: ListNode?,toBeDeleted: ListNode?): ListNode? {
        if (head == null || toBeDeleted == null){
            return head
        }
        if (head == toBeDeleted){
            return head.next
        }

        if (toBeDeleted.next == null){
            var temp = head
            while (temp!!.next != toBeDeleted){
                temp = temp.next
            }
            temp.next = null
        }else{
            toBeDeleted.value = toBeDeleted.next!!.value
            toBeDeleted.next = toBeDeleted.next!!.next
        }
        return head
    }
}