package com.fxf.leetcode

import org.junit.Test
import java.lang.StringBuilder

class ConvertZ {

    @Test
    fun t0() {
        val s = "PAYPALISHIRING"
        val convert = convert(s, 3)
        val ret = "PAHNAPLSIIGYIR"
        assert(convert.equals(ret))
    }

    fun convert(s: String, numRows: Int): String {

        if (numRows == 1) return s

        val rows = ArrayList<StringBuilder>()
        for (i in 0..Math.min(s.length, numRows)) {
            rows.add(StringBuilder())
        }

        var currRow = 0
        var goingDown = false
        for (c in s.toCharArray()) {
            rows[currRow].append(c)
            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown
            if (goingDown) {
                currRow++
            } else {
                currRow--
            }
        }
        val ret = StringBuilder()
        for (item in rows) {
            ret.append(item.toString())
        }
        return ret.toString()
    }
}