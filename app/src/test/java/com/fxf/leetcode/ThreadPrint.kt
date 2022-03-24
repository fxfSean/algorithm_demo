package com.fxf.leetcode

import org.junit.Test

class ThreadPrint {
    var len = 20
    var index = 0
    var flag = false

    @Test
    fun print() {
        var runnable = Runnable {
            while (index < len) {
                synchronized(
                    flag
                ) {
                    if (!flag) {
                        println(index++)
                        flag = !flag
                    }
                }

            }
        }
        var thread1 = Thread(runnable)
        thread1.start()

        var runnable2 = Runnable {
            while (index < len) {
                synchronized(flag) {
                    if (flag) {
                        println(index++)
                        flag = !flag
                    }
                }
            }
        }
        var thread2 = Thread(runnable2)
        thread2.start()


    }
}