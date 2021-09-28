package com.fxf.leetcode


class MoveArray {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。 *
     * @param arr 输入的数组
     */
    fun reOrderOddEven(arr: IntArray?){
        if (arr == null || arr.size < 2)
            return

        var start = 0
        var end = arr.size - 1

        while (start < end){
            // 找偶数
            while (start < end && arr[start] % 2 != 0){
                start++
            }

            while (start < end && arr[end] % 2 == 0){
                end--
            }

            val temp = arr[start]
            arr[start] = arr[end]
            arr[end] = temp
        }
    }
}