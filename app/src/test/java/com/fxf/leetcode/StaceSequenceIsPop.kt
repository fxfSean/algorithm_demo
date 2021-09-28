package com.fxf.leetcode

import java.util.*

class StaceSequenceIsPop {

    /**
     * ,输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的 弹出顺序。假设压入栈的所有数字均不相等
     */
    fun sequenceIsPop(data1: IntArray,data2: IntArray): Boolean {
        val stack = Stack<Int>()
        var j=0
        for (item in data1){
            stack.push(item)
            while (stack.isNotEmpty() && stack.peek() == data2[j]){
                stack.pop()
                j++
            }
        }
        return stack.isEmpty()
    }

    fun seq2(data1: IntArray,data2: IntArray): Boolean {
        if (data1.size != data2.size){
            return false
        }
        for (i in data1.indices){
            if (data1[i] != data2[data2.size - i - 1]){
                return false
            }
        }
        return true
    }
}