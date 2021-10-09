package com.fxf.leetcode.array

import org.junit.Test

class FindMedianInTwoSortedArr {

    @Test
    public fun t0() {
        val nums1 = intArrayOf(3, 4)
        val nums2 = intArrayOf()

        val findMedianSortedArrays = findMedianSortedArrays(nums1, nums2)
        println(findMedianSortedArrays)
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var m = nums1.size
        var n = nums2.size
        if(m == 0) {
            return if ((n and 1) == 0) {
                (nums2[n/2 -1] + nums2[n/2 ]).toDouble() / 2
            } else {
                nums2[n / 2].toDouble()
            }
        }
        if (n == 0) {
            return if ((m and 1) == 0) {
                (nums1[m/2 -1 ] + nums1[m/2]).toDouble() / 2
            } else {
                nums1[m / 2].toDouble()
            }
        }
        val nums = IntArray(m + n)

        /**
         * 伪代码
         * 遍历num1和num2
         * 合并排序后数组到nums
         * 找出nums中位数
         */
        var index1 = 0
        var index2 = 0
        for (i in nums.indices) {
            if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                nums[i] = nums1[index1++]
            } else {
                nums[i] = nums2[index2++]
            }
        }
        return if ((nums.size and 1) == 0) {
            (nums[nums.size / 2 - 1] + nums[nums.size /2]).toDouble()/2
        } else {
            nums[nums.size / 2].toDouble()
        }
    }
}