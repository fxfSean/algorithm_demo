package com.fxf.leetcode.dynamic

import java.util.*
import kotlin.math.min

class MinInsertToPalindrome {

    fun minInsertions(s: String): Int{
        val c = s.toCharArray()
        val dp = Array(c.size){IntArray(c.size)}
        for (i in c.indices){
            dp[i].fill(0)
        }
        val n = c.size
        for (i in n-2..0){
            for (j in i+1 until n){
                if (c[i] == c[j]){
                    dp[i][j] = dp[i+1][j-1]
                } else {
                    dp[i][j] = min(dp[i+1][j],dp[i][j-1])+1
                }
            }
        }
        return dp[0][n-1]
    }

    fun minInsert(s: String): Int{
        var c = s.toCharArray()
        val n = c.size
        val dp = IntArray(n)
        val list = LinkedList<Int>()
        list.toIntArray()
        dp.fill(0)
        var pre = 0
        for (i in n-2..0){
            for (j in i+1 until n){
                val temp = dp[j]
                if (c[i] == c[j]){
                    dp[j] = pre
                }else{
                    dp[j] = min(dp[j],dp[j-1])+1
                }
                pre = temp
            }
        }
        return dp[n-1]
    }
}