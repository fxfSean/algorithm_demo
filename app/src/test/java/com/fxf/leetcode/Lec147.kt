package com.fxf.leetcode

import org.junit.Test

class Lec147 {
    @Test
    fun t0() {

    }

    fun insert(head: ListNode?): ListNode?{
        if (head == null)return null
        val shaobing = ListNode(0)
        shaobing.next = head
        var tail = head
        var curr = head.next
        while (curr != null){
            if (tail!!.`val` <= curr.`val`){
                tail = tail.next
                curr = curr.next
            }else{
                val temp = curr.next
                var behind = shaobing
                var forward = shaobing.next
                while (forward!!.`val` < curr.`val`){
                    behind = behind.next!!
                    forward = forward.next
                }
                behind.next = curr
                curr.next = forward
                tail.next = temp
                curr = temp
            }
        }
        return shaobing.next
    }

    public class ListNode {
        var `val`: Int
        var next: ListNode? = null
        constructor(x: Int)
        { `val` = x; }
    }
}