package com.fxf.leetcode

import java.util.*

class MinTreeDepth {

    fun minDepth(root: TreeNode?): Int {
        if(root == null){
            return 0
        }
        val list: LinkedList<TreeNode> = LinkedList<TreeNode>()
        list.add(root)
        var dep = 1
        while(!list.isEmpty()){
            val sz = list.size
            for(i in 0 until sz){
                val node = list.removeFirst()
                if(node.left == null && node.right == null){
                    return dep
                }
                if(node.left != null){
                    list.add(node.left!!)
                }
                if(node.right != null){
                    list.add(node.right!!)
                }
            }

            dep++
        }
        return dep
    }
}