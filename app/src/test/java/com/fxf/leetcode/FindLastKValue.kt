package com.fxf.leetcode

import java.lang.IllegalArgumentException

class FindLastKValue {

    fun findLastK(list: ListNode,k: Int): Int{
        if (k <= 0){
            throw IllegalArgumentException("参数不合法")
        }
        var fist: ListNode? = list
        var second: ListNode? = list
        var count = 0
        while (fist != null){
            if (count == k){
                second = second!!.next
            }
            fist = fist.next
            count++
        }
        if (count != k + 1){
            return -1 //not found
        }
        return second!!.value
    }
}