package com.fxf.leetcode

/**
 * LeetCode
 * No.7. 整数反转
 */
class ReverseInt {

    fun reverse(x: Int): Int {
        var x = x
        var rev = 0
        while (x != 0) {
            if (rev < Int.MIN_VALUE / 10 || rev > Int.MAX_VALUE / 10) return 0
            val digit = x % 10
            x /= 10
            rev = rev * 10 + digit
        }
        return rev
    }
}