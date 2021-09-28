package com.fxf.leetcode.dynamic

import org.junit.Test
import kotlin.math.min

class MinInstance {
    private lateinit var w1:CharArray
    private lateinit var w2:CharArray
    private lateinit var dp :Array<IntArray>

    @Test
    fun t(){
        val st1 = "horse"
        val st2 = "ros"
        val minDistance = minDistance("dinitrophenylhydrazine",
            "benzalphenylhydrazone")
        println(minDistance)
    }

    fun minDistance(word1: String, word2: String): Int {
        w1 = word1.toCharArray()
        w2 = word2.toCharArray()
        dp = Array(w1.size+1){IntArray(w2.size+1)}

        for (i in 1..w1.size){
            dp[i][0] = i
        }
        for (j in 1..w2.size){
            dp[0][j] = j
        }
        for (i in 1..w1.size){
            for (j in 1..w2.size){
                if (w1[i-1] == w2[j-1]){
                    dp[i][j] = dp[i -1][j-1]
                } else {
                    dp[i][j] = min(dp[i-1][j-1]+1, min(dp[i][j-1]+1,dp[i-1][j]+1))
                }
            }
        }
        return dp[w1.size][w2.size]
    }
}