package com.fxf.leetcode

import org.junit.Test
import java.util.*

class SubSets {

    @Test
    fun t(){
        val arr = intArrayOf(1,2,3)
        val subSets = subSets(arr)
        subSets.forEach{
            println(it)
        }
    }

    //子集问题
    val res = LinkedList<LinkedList<Int>>()
    fun subSets(arr: IntArray): List<LinkedList<Int>>{
        val trace = LinkedList<Int>()
        findSub(arr,0,trace)
        return res
    }

    private fun findSub(arr: IntArray, start: Int, trace: LinkedList<Int>) {
        res.push(LinkedList(trace))
        for (i in start until arr.size){
            trace.push(arr[i])
            findSub(arr,i+1,trace)
            trace.pop()
        }
    }

    @Test
    fun t2(){
        val subSets = combine(4,2)
        subSets.forEach{
            println(it)
        }
    }

    //组合问题
    val ret = LinkedList<LinkedList<Int>>()
    fun combine(n: Int,k: Int):List<LinkedList<Int>>{
        val trace= LinkedList<Int>()
        backtrack(n,k,1,trace)
        return ret
    }

    private fun backtrack(n: Int, k: Int, start: Int, trace: LinkedList<Int>) {
        if (trace.size == k){
            ret.push(LinkedList(trace))
        }
        for (i in start.. n){
            trace.push(i)
            backtrack(n,k,i+1,trace)
            trace.pop()
        }
    }

}