package com.fxf.leetcode

import org.junit.Test
import java.util.*
import kotlin.math.max

public class NQueue {
    val res = LinkedList<LinkedList<String>>()

    @Test
    fun t0(){
        val solveNQueens = solveNQueens(8)
        for (it in solveNQueens){
            for (item in it) {
                println(item.toString())
            }
            println()
        }
    }

    fun solveNQueens(n: Int): List<List<String>>{
        val board = Array<CharArray>(n){CharArray(n)}
        backtrack(board,n,0)
        return res
    }

    private fun backtrack(board: Array<CharArray>, n: Int, row: Int) {
        if (row == n){
            val list = LinkedList<String>()
            for (item in board){
                list.add(String(item))
            }
            res.add((list))
            return
        }
        for (col in 0 until n){
            if (!isValid(board,col,row)){
                continue
            }
            board[row][col] = 'Q'
            backtrack(board,n,row+1)
            board[row][col] = '.'
        }
    }

    fun isValid(board: Array<CharArray>, col: Int, row: Int): Boolean{
        for (i in 0 until row){
            if (board[i][col] == 'Q'){
                return false
            }
        }
        var i = row - 1
        var j = col +1
        while (i >= 0 && j < board.size){
            if (board[i][j] == 'Q'){
                return false
            }
            i--
            j++
        }
        i = row - 1
        j = col-1
        while (i>=0 && j >= 0){
            if (board[i][j] == 'Q'){
                return false
            }
            i--
            j--
        }
        return true
    }
}