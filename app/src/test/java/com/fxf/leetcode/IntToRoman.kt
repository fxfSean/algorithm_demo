package com.fxf.leetcode

import java.lang.StringBuilder

/**
 * 12. 整数转罗马数字
 */
class IntToRoman {

    fun intToRoman(num: Int): String {
        var num = num
        val nums = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val stringBuilder = StringBuilder()

        var index = 0
        while (index < 13) {
            while (num > nums[index]) {
                stringBuilder.append(romans[index])
                num -= nums[index]
            }
            index++
        }
        return stringBuilder.toString()
    }
}