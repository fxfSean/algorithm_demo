package com.fxf.leetcode

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
 * 输入一个 递增排序的数组的一个旋转， 输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2 }为 { 1,2,3,4,5}的一个旋转，该数组的最小值为1
 *
 */
class RotateNumber {

    fun findMin(array: IntArray?): Int{
        if (array == null || array.size == 0){
            throw RuntimeException("Invalid")
        }
        var lo = 0
        var hi = array.size - 1
        var mi = lo
        while (array[lo] >= array[hi]){
            if (hi - lo == 1){
                return array[hi]
            }
            mi = lo + (hi - lo shr 1)
            if (array[lo] == array[mi] && array[mi] == array[hi]){
                return minInorder(array,lo,hi)
            }
            if (array[mi] >= array[lo]){
                lo = mi
            } else if (array[mi] <= array[hi]){
                hi = mi
            }
        }

        return array[mi]

    }

    private fun minInorder(array: IntArray, lo: Int, hi: Int): Int {
        var result = array[0]
        for (i in lo+1..hi){
            if (result > array[i]){
                result = array[i]
            }
        }
        return result
    }
}