package com.fxf.leetcode.dynamic

import kotlin.math.max

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val c = s.toCharArray()
        val dp = Array(c.size){IntArray(c.size)}
        for(item in dp){
            item.fill(0)
        }
        for(i in 0 until dp.size){
            dp[i][i] = 1
        }
        for(i in c.size -2 ..0){
            for(j in i+1 ..c.size){
                if(c[i] == c[j]){
                    dp[i][j] = dp[i+1][j-1]+2
                } else {
                    dp[i][j] = max(dp[i+1][j],dp[i][j-1])
                }
            }
        }

        return dp[0][c.size-1]

    }
}