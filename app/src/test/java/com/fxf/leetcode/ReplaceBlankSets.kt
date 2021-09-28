package com.fxf.leetcode

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则
输出“We%20are%20happy.”
 */
class ReplaceBlankSets {
    fun replaceBlank(string: CharArray?, usedLength: Int): Int {
        if (string == null || string.size < usedLength){
            return -1
        }
        var spaceCount = 0
        for (char in string){
            if (char == ' '){
                spaceCount++
            }
        }
        var targetLen = spaceCount * 2 + usedLength
        val temp = targetLen
        if (targetLen > string.size ){
            return -1
        }

        if (targetLen == 0){
            return usedLength
        }

        var usedLength = usedLength
        usedLength--
        targetLen--
        while (usedLength in 0 until targetLen){
            if (string[usedLength] == ' '){
                string[targetLen--] = '0'
                string[targetLen--] = '2'
                string[targetLen--] = '%'
            } else {
                string[targetLen--] = string[usedLength]
            }
            usedLength--
        }
        return temp
    }

}