package com.fxf.leetcode

import java.util.*

class PrintTreeFromTopToBottom {

    /**
     * 从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印
     */
    fun printToBottom(tree: TreeNode){
        val list = LinkedList<TreeNode>()
        list.add(tree)
        while (list.isNotEmpty()){
            val node = list.removeAt(0)
            println(node.`val`)
            node.left?.let {
                list.add(it)
            }

            node.right?.let {
                list.add(it)
            }
        }

    }
}