package com.fxf.leetcode

import java.lang.RuntimeException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

class MinStack {

    private val stack: Stack<Int> = Stack()
    private val minStack = Stack<Int>()

    fun push(data: Int){
        stack.push(data)
        if (minStack.isEmpty() || data < minStack.peek()){
            minStack.push(data)
        } else{
            minStack.add(minStack.peek())
        }
        val ar = ArrayList<Int>()


    }

    fun pop(): Int{
        if (stack.isEmpty()){
            throw RuntimeException("null")
        }
        val pop = stack.pop()
        minStack.pop()

        return pop
    }

    fun min(): Int{
        if (minStack.isEmpty()){
            throw RuntimeException()
        }
        return minStack.peek()
    }
}