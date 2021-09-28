package com.fxf.leetcode.dynamic

import java.util.*
import kotlin.Comparator
import kotlin.math.max

class MaxLenSubArray {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

    子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp.fill(1)
        for (i in nums.indices){
            for (j in 0 until i){
                if (nums[i] > nums[j]){
                    dp[i] = max(dp[i],dp[j] + 1)
                }
            }
        }
        var res = 0
        for (element in dp){
            res = max(res, element)
        }
        return res
    }

    /**
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

    请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     */
    fun maxEnvelopes(envelopes: Array<IntArray>): Int{
        val n = envelopes.size
        Arrays.sort(envelopes
        ) { o1, o2 -> if (o1[0] == o2[0]) o2[1] - o1[1] else o1[0] - o2[0] }
        val height = IntArray(n)
        for (i in 0 until n){
            height[i] = envelopes[i][1]
        }
        return lengthOfLIS(height)
    }
}