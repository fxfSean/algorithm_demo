package com.fxf.leetcode

class Fibonacci {
    /**
     * 写一个函数，输入n，求斐波那契(Fibonacci) 数列的第n项
     * @param n Fibonacci数的项数
     *
     * 动态规划，自底向上
     */
    fun fibonacci(n: Int):Int{
        if (n <= 0){
            return 0
        }
        if (n == 1||n==2){
            return 1
        }
        var ppre=1
        var pre=1
        var current=2
        for (i in 3..n){
            current = pre + ppre
            ppre = pre
            pre = current
        }
        return current
    }

    /**
     * 备忘录，自顶向下
     */
    fun fib(n: Int): Int {
        val map = HashMap<Int,Int>()

        return fib(map,n)
    }
    fun fib(map: HashMap<Int,Int>,n: Int): Int{
        if(n==0)return 0
        if(n==1 || n==2)return 1
        if(map[n] != null)return map[n]!!
        map[n] = fib(map,n-1) + fib(map,n-2)
        return map[n]!!
    }

}