package com.fxf.leetcode.slidingwindow

import org.junit.Test

public class MaxLenSubStr {

    @Test
    fun t(){
        val s = "abcabcbb"
        val len = lengthOfLongestSubstring(s)
        println(len)
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val window = HashMap<Char,Int>()
        var right = 0
        var left = 0
        var maxLen = 0
        var len = 0
        val t = s.toCharArray()
        while(right < s.length){
            val c = t[right]
            right++
            if(window.containsKey(c)){
                while(window.containsKey(c)){
                    val d = t[left]
                    left++
                    window.remove(d)
                    len--
                }
            }
            window[c] = (window[c]?:0).plus(1)
            len++
            if(len > maxLen){
                maxLen = len
            }
        }
        return maxLen
    }
}