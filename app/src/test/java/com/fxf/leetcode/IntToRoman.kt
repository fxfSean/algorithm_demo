package com.fxf.leetcode

import org.junit.Test
import java.lang.StringBuilder

/**
 * 12. 整数转罗马数字
 */
class IntToRoman {

    @Test
    fun t0() {
        val s = "IV"
        val romanToInt = romanToInt(s)
        println(romanToInt)
    }

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

    fun romanToInt(s: String): Int {
        val map = mapOf(Pair("I",1), Pair("V",5),Pair("X",10),
            Pair("L",50),Pair("C",100),Pair("D",500),Pair("M",1000))
        var res = 0
        var preNum = map[s.substring(0,1)]
        for (i in 1 until s.length) {
            var num = map[s.substring(i,i+1)]
            if (preNum!! < num!!) {
                res -= preNum
            } else {
                res += preNum
            }
            preNum = num
        }
        res += preNum!!
        return res

    }
}