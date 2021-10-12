package com.fxf.leetcode

import org.junit.Test
import kotlin.math.max

/**
 * 11. 盛最多水的容器（双指针）
 */
class MaxWater {

    @Test
    fun t0() {
        val height = intArrayOf(1,8,6,2,5,4,8,3,7)
        val maxArea = maxArea(height)
        println(maxArea)
    }

    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var res = 0
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]))
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return res
    }
}