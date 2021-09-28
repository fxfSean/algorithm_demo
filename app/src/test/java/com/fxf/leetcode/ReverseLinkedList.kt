package com.fxf.leetcode

import java.util.*

/**
 * 链表翻转
 */
class ReverseLinkedList {

    //借助链表
    fun printListInverselyUsingIteration(root: ListNode?): ListNode?{
        if (root == null) return null
        val stack = Stack<ListNode>()
        var header = root
        while (header != null){
            stack.push(header)
            header = header.next
        }
        var temp: ListNode = ListNode(0)
        var pointer = temp
        while (!stack.isEmpty()){
            pointer.next = stack.peek()
            pointer = pointer.next!!
        }
        return temp
    }

    fun reverseList(root: ListNode?): ListNode? {
        if (root == null)return null
        var head = root
        var curr = root.next
        var next = root
        while (curr != null){
            next = curr.next
            curr.next = head
            head = curr
            curr = next
        }
        return head
    }

    fun reverseBetween(head: ListNode,m: Int,n: Int): ListNode{
        if (m == 1){
            return rev(head,n)
        }
        return reverseBetween(head.next!!,m-1,n-1)
    }
    var afterN: ListNode? = null
    fun rev(head: ListNode, count: Int):ListNode{
        if (count == 1){
            afterN = head.next
            return head
        }

        val last = rev(head.next!!,count-1)
        head.next!!.next = head
        head.next = afterN
        return last

    }

    fun reverseGroup(head: ListNode?,k: Int): ListNode? {
        if (head == null)return null
        val a = head
        var b = head
        for (i in 0 until k){
            if (b == null)return head
            b = b.next
        }
        val newHead = reverseBetween(head,1,k)
        a.next = reverseGroup(head,k)
        return newHead
    }
}