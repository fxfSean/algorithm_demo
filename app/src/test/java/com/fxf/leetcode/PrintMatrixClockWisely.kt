package com.fxf.leetcode

class PrintMatrixClockWisely {
    fun printMatrixClockWisely(numbers: Array<IntArray>){
        if (numbers.isEmpty() || numbers[0].isEmpty()){
            return
        }
        var x = 0
        var y = 0

        while (x*2 < numbers.size && y*2< numbers[0].size){
            printMatrixCircle(numbers,x,y)
            x++
            y++
        }

    }

    private fun printMatrixCircle(numbers: Array<IntArray>, x: Int, y: Int) {
        var rows = numbers.size
        var cols = numbers[0].size
        for (i in y until cols-y){
            print(numbers[x][i])
        }
        if (rows -x-1 > x){
            for (i in x+1 until rows-x) {
                print(numbers[i][cols - y -1])
            }
        }

        if (rows - x-1> x && cols-y-1> y){
            for (i in cols-y-2 downTo y){
                print(numbers[rows-x-1][i])
            }
        }

        if (cols-1-y>y && rows-1-x>x+1){
            for (i in rows - x -2 downTo x+1){
                print(numbers[i][y])
            }
        }

    }
}