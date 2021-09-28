package com.fxf.leetcode

import org.junit.Test
import kotlin.math.max

public class TreeMaxSumPath {


    @Test
    fun t0(){
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        val maxPathSum = maxPathSum(root)
        println(maxPathSum)
    }

    var ans = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        maxPath(root)
        return ans
    }
    fun maxPath(root: TreeNode?): Int{
        if(root == null){
            return 0
        }
        val left = max(0,maxPath(root!!.left))
        val right = max(0,maxPath(root.right))
        ans = max(ans,left + right + root.`val`)
        return max(left,right) + root.`val`
    }
}