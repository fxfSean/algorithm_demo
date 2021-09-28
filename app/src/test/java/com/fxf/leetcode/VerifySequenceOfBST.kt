package com.fxf.leetcode

class VerifySequenceOfBST {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则
     * 返回true。否则返回false。假设输入的数组的任意两个数字都互不相同
     */
    fun verify(array: IntArray): Boolean {
        if (array.isEmpty()){
            return false
        }

        return verifySequenceOfBST(array,0,array.size -1)
    }

    private fun verifySequenceOfBST(array: IntArray, start: Int, end: Int): Boolean {
        if (start >= end)
            return true
        var index = start
        while (index < end -1 && array[index] < array[end]){
            index++
        }
        var right = index
        while (index < end -1 && array[index] > array[end]){
            index++
        }
        if (index != end){
            return false
        }

        return verifySequenceOfBST(array,start,right - 1) && verifySequenceOfBST(array,right, end - 1)
    }
}