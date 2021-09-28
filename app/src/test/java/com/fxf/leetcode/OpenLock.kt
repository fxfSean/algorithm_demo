package com.fxf.leetcode

import org.junit.Test
import java.util.*
import kotlin.collections.HashSet

/**
 * lico 752. 打开转盘锁
 */
class OpenLock {

    @Test
    fun t0(){
        val deadends = arrayOf("0201","0101","0102","1212","2002")
        val target = "0202"
        println(openLc(deadends,target))

    }

    private fun turnUp(str: String, index: Int): String{
        val charArray = str.toCharArray()
        if (charArray[index] == '9'){
            charArray[index] = '0'
        } else {
            charArray[index]++
        }
        return String(charArray)
    }
    private fun turnDown(str: String, index: Int): String{
        val charArray = str.toCharArray()
        if (charArray[index] == '0'){
            charArray[index] = '9'
        } else {
            charArray[index]--
        }
        return String(charArray)
    }


    /**
     * 经典解法
     */
    fun openLock(deadends: Array<String>, target: String): Int {
        val list = LinkedList<String>()
        val sets = HashSet<String>()
        for (item in deadends){
            sets.add(item)
        }
        list.add("0000")
        var step = 0
        while (list.isNotEmpty()){
            val size = list.size
            for (j in 0 until size) {
                val first = list.poll()
                if (first == target){
                    return step
                }
                for (i in first.indices) {
                    val turnUp = turnUp(first, i)
                    if (!sets.contains(turnUp)) {
                        list.add(turnUp)
                        sets.add(turnUp)
                    }
                    val turnDown = turnDown(first, i)
                    if (!sets.contains(turnDown)) {
                        list.add(turnDown)
                        sets.add(turnDown)
                    }
                }
            }
            step++
        }
        return -1
    }

    fun openLc(deadends: Array<String>, target: String): Int{
        val deads = HashSet<String>()
        var q1 = HashSet<String>()
        var q2 = HashSet<String>()
        val visited = HashSet<String>()
        for (item in deadends){
            deads.add(item)
        }
        if (deads.contains("0000")){
            return -1
        }
        q1.add("0000")
        q2.add(target)
        var step = 1
        while (q1.isNotEmpty() && q2.isNotEmpty()){
            var temp = HashSet<String>()
            if (q1.size > q2.size){
                temp = q1
                q1 = q2
                q2 = temp
            }
            for (item in q1){
                if (deads.contains(item)){
                    continue
                }
                if (q2.contains(item)){
                    return step
                }
                visited.add(item)
                for (i in 0 until 4) {
                    val turnUp = turnUp(item, i)
                    if (!visited.contains(turnUp)) {
                        temp.add(turnUp)
                    }
                    val turnDown = turnDown(item, i)
                    if (!visited.contains(turnDown)) {
                        temp.add(turnDown)
                    }
                }
            }
            step++
            q1 = q2
            q2 = temp
        }
        return -1
    }
}