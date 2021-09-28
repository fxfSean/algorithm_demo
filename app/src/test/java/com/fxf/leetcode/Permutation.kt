package com.fxf.leetcode

import org.junit.Test
import kotlin.math.max


public class Permutation {

    @Test
    public fun t0(){
        val chars = "abc".toCharArray()
        permutation(chars)

    }

    fun permutation(chars: CharArray?){
        if (chars == null || chars.isEmpty()){
            return
        }
        permutation(chars,0)
    }

    private fun permutation(chars: CharArray, begin: Int) {
        if (chars.size-1 == begin){
            println(String(chars))
        } else {
            var temp: Char
            for (i in begin until chars.size){
                temp = chars[begin]
                chars[begin] = chars[i]
                chars[i] = temp
                println("i: $i begin: $begin char: ${chars[i]}")

                permutation(chars,begin+1)

                temp = chars[i];
                chars[i] = chars[begin];
                chars[begin] = temp;
            }
        }
    }
}