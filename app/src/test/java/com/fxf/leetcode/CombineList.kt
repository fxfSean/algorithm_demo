package com.fxf.leetcode

class CombineList {

    /**
     * 合并两个有序的链表
     */
    fun combineLinkedList(list1: ListNode,list2: ListNode): ListNode? {
        var list1: ListNode? = list1
        var list2: ListNode? = list2
        var listSum = ListNode(0)
        var tail: ListNode? = listSum
        while (list1 != null && list2 != null){
            if (list1.value > list2.value){
                tail!!.next = list2
                list2 = list2.next
            } else {
                tail!!.next = list1
                list1 = list1.next
            }
            tail = tail!!.next
        }

        if (list1 == null){
            tail!!.next = list2
        }
        if (list2 == null){
            tail!!.next = list1
        }
        return listSum.next

    }
}