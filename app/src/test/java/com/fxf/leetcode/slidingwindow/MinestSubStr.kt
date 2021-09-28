package com.fxf.leetcode.slidingwindow

import org.junit.Test
import kotlin.math.min

public class MinestSubStr {

    @Test
    fun t0(){
        val s = "ADOBECODEBANC"
        val t = "ABC"
        val minWindow = minWindow(s, t)
        println(minWindow)
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。
     * 返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     */
    fun minWindow(s: String, t: String): String {
        var left=0
        var right = 0
        var valid = 0
        var len = Int.MAX_VALUE
        var start = 0
        var need = HashMap<Char,Int>()
        var window = HashMap<Char,Int>()
        val tArray = t.toCharArray()
        for (item in tArray){
            need[item] = (need[item]?:0).plus(1)
        }
        val sArray = s.toCharArray()
        while (right < s.length){
            var r = sArray[right]
            right++
            if (need.containsKey(r)){
                window[r] = (window[r]?:0).plus(1)
                if (window[r] == need[r]){
                    valid++
                }
            }
            while (valid == need.size){
                if (right - left < len){
                    start = left
                    len = right - left
                }
                val c = sArray[left]
                left++
                if (need.containsKey(c)){
                    if (window[c] == need[c]){
                        valid--
                    }
                    window[c] = window[c]!!.minus(1)
                }
            }
        }

        return if (len == Int.MAX_VALUE) "" else s.substring(start,start + len)
    }
}