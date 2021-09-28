package com.fxf.leetcode

import org.junit.Test
import java.lang.Math.min

/**
 * 322 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1
 */
public class CoinChange {
    @Test
    fun t0(){
        var arr = arrayOf(1,2,5)
        val coinChange = coinChange(arr.toIntArray(), 11)
        println(coinChange)
    }
    fun coinChange(coins: IntArray, amount: Int): Int {
        return coinChange(coins,amount, IntArray(amount))
    }

    fun coinChange(coins: IntArray,amount: Int,count:IntArray): Int{
        if (amount == 0)return 0
        if (amount < 0) return -1
        if (count[amount-1] != 0){
            return count[amount-1]
        }
        var res = Int.MAX_VALUE
        for(item in coins){
            val subproblem = coinChange(coins,amount - item,count)
            if(subproblem == -1) {
                continue
            }
            res = min(res,subproblem+1)
        }
        count[amount-1]= if(res == Int.MAX_VALUE){
             -1
        } else{
             res
        }
        return count[amount -1]
    }
}