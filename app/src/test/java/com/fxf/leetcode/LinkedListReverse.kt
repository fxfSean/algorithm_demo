package com.fxf.leetcode

import org.junit.Test
import java.util.*
import kotlin.math.min

/**
 * 反转链表
 */
class LinkedListReverse {

    fun reverseLinkedList(head: ListNode?) : ListNode?{
        if (head == null) {
            return null
        }
        var cur = head
        var pre: ListNode? = null
        while (cur != null) {
            val temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        }
        return pre;
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}