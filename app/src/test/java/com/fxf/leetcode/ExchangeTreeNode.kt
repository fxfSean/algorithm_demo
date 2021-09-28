package com.fxf.leetcode

import org.junit.Test

public class ExchangeTreeNode {

    @Test
    fun t0(){
        val root = TreeNode(1)
        root.left = TreeNode(3)
        root.left!!.right = TreeNode(2)
        recoverTree(root)
    }

    var pre :TreeNode? = null
    fun recoverTree(root: TreeNode?): Unit {
        if(root == null){
            return
        }
        recoverTree(root.left)
        val curr = root.`val`
        if(pre != null && curr < pre!!.`val`){
            val temp = pre!!.`val`
            pre!!.`val` = curr
            root.`val` = temp
        }
        pre = root
        recoverTree(root.right)
    }
}