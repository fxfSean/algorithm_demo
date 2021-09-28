package com.fxf.leetcode

class ReverseArray {
    fun reverse(nums: IntArray){
        var left = 0
        var right = nums.size - 1
        var temp = 0
        while (left < right){
            temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }
}