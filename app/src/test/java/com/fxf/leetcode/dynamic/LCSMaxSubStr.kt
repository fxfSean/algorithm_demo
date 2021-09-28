package com.fxf.leetcode.dynamic

import org.junit.Test
import kotlin.math.max

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度
 * 输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace"，它的长度为 3。
 */
public class LCSMaxSubStr {

    @Test
    fun t(){
        val st1 = "abcde"
        val st2 = "ace"
        val n = longestCommonSubsequence(st1, st2)
        println(n)
    }

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val c1 = text1.toCharArray()
        val c2 = text2.toCharArray()
        val arr = Array(c1.size+1){IntArray(c2.size+1)}
        for (i in 1.. c1.size){
            for (j in 1 .. c2.size){
                if (c1[i - 1] == c2[j - 1]){
                    arr[i][j] = arr[i -1][j-1] + 1
                } else {
                    arr[i][j] = max(arr[i -1][j],arr[i][j-1])
                }
            }
        }
        return arr[c1.size][c2.size]

    }
}