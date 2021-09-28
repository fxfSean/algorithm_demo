package com.fxf.leetcode

/**
 * 环的起点
 */
class RingStartIndex {
    fun getIndex(head: ListNode?): ListNode?{
        if (head == null)return null
        var fast = head
        var slow = head
        while (fast != null && fast.next != null){
            fast = fast.next!!.next
            slow = slow!!.next
            if (fast == slow){
                break
            }
        }
        slow = head
        while (slow != fast){
            slow = slow!!.next
            fast = fast!!.next
        }
        return slow
    }
}