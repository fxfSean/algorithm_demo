package com.fxf.leetcode

import org.junit.Test
import java.util.*
import kotlin.math.min

/**
 * 反转链表
 */
class LinkedListReverse {

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null)return null
        var pre = head
        val listMin = LinkedList<Int>()
        listMin.push(Int.MAX_VALUE)
        min(1,2)
        listMin.pop()
        var curr = head.next
        var next : ListNode? = null
        while (curr != null){
            next = curr.next
            curr.next = pre

            pre = curr
            curr = next
        }
        head.next = null

        return pre
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}