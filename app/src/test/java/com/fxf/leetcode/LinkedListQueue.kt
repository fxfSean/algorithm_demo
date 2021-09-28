package com.fxf.leetcode

import java.util.*

class LinkedListQueue {

    inner class LinkedQueue<T> {
        private var stackIn: Stack<T>? = null
        private var stackOut: Stack<T>? = null
        init {
            stackIn = Stack()
            stackOut = Stack()
        }
        fun appendTail(t: T){
            stackIn!!.push(t)
        }

        fun deleteHead(): T{
            if (stackOut!!.isEmpty()){
                while (!stackIn!!.isEmpty()){
                    stackOut!!.push(stackIn!!.pop())
                }
            }

            if (stackOut!!.isEmpty()){
                throw RuntimeException("No Data")
            }
            return stackOut!!.pop()
        }
    }

    fun twoLinkedListMakeOfQueue() {

    }
}