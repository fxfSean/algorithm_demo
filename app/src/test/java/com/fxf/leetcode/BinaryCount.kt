package com.fxf.leetcode

import org.junit.Test


class BinaryCount {

    /**
     * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
     * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2
     * @param n 待的数字
     * @return 数字中二进制表表的1的数目
     */
    fun countNum(n: Int): Int{
        var n = n
        var result = 0
        for (i in 0..31) {
            result += n and 1
            n = n ushr 1
        }
        return result

    }
    @Test
    fun test(){
        countNum(8)
    }
}