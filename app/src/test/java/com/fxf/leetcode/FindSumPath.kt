package com.fxf.leetcode

import java.util.*

class FindSumPath {

    /**
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径
     */
    fun findPath(treeNode: TreeNode, expectSum: Int){
        val list = LinkedList<Int>()

        findPath(treeNode,0,expectSum,list)
    }

    private fun findPath(treeNode: TreeNode?, currentSum: Int, expectSum: Int, result: LinkedList<Int>){
        var currentSum = currentSum
        treeNode?.let {
            currentSum+=it.`val`!!
            result.add(it.`val`!!)
            if (currentSum < expectSum){
                findPath(it.left,currentSum,expectSum,result)

                findPath(it.right,currentSum,expectSum,result)
            } else if (currentSum == expectSum){
                if (it.left == null && it.right == null){
                    println(result)
                }
            }
            result.remove(result.size - 1)
        }
    }
}