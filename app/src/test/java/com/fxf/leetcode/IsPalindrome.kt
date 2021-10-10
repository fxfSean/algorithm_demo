package com.fxf.leetcode

/**
 * LeetCode
 * No.9. 回文数
 */
class IsPalindrome {

    fun isPalindrome(x: Int): Boolean {
        var x = x
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false
        }

        var rev = 0
        while (x > rev) {
            rev = rev * 10 + x % 10
            x /= 10
        }

        return x == rev || x == rev / 10
    }
}