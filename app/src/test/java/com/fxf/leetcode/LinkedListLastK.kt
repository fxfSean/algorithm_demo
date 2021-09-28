package com.fxf.leetcode

import org.junit.Test


/**
 * 输入一个链表，输出该链表中倒数第k 个结点。
 * 为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点.
 * 例如一个链表有6 个结点，从头结 点开始它们的值依次是1 、2、3、4、5 、6。
 * 这个个链表的倒数第3 个结点是值为4 的结点
 */
class LinkedListLastK {

    fun findKthToTail(head: ListNode?,k: Int): ListNode?{
        if (k < 1 || head == null){
            return null
        }
        var pointer = head
        var header = head
        for (i in 1 until k) {
            // 说明还有结点
            pointer = if (pointer!!.next != null) {
                pointer.next!!
            } else {
                // 返回结果
                return null
            }
        }
        while (pointer!!.next != null){
            header = head.next
            pointer = pointer.next
        }
        return header
    }

    @Test
    public fun t0(){

    }
}