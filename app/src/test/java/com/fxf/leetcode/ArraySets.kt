package com.fxf.leetcode

import org.junit.Test

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到 下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断 数组中是否含有该整数
 */
class ArraySets {

    fun find(matrix: Array<IntArray>?, number: Int): Boolean {
        if (matrix == null || matrix.size < 1 || matrix[0].size < 1) {
            return false
        }
        val rows = matrix.size
        val cols: Int = matrix[0].size
        var row = 0
        var col = cols - 1
        while (row < rows && col >= 0) {
            if (matrix[row][col] == number) {
                return true
            } else if (matrix[row][col] < number) {
                row++
            } else {
                col--
            }
        }
        return false
    }
}


class TwoSum {
    @Test
    fun test() {
        val arr = intArrayOf(1,4,5)
        twoSum(arr, 6)

    }

    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val map: HashMap<Int, Int> = HashMap()
        for (index in nums.indices) {
            if (map[target - nums[index]] != null) {
                return intArrayOf(index, map[target - nums[index]]!!)
            }
            map[nums[index]] = index
        }
        return null
    }
}