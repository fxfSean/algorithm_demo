package com.fxf.leetcode

class FindLastK {
    fun find(head: ListNode?,k: Int): ListNode{
        var head = head
        var slow = head
        var k = k
        while (k-- > 0){
            head = head!!.next!!
        }
        while (head != null){
            head = head.next!!
            slow = slow!!.next
        }
        return slow!!
    }
}