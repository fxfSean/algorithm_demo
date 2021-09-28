package com.fxf.leetcode.tree

import com.fxf.leetcode.TreeNode
import java.lang.StringBuilder
import java.util.*

class LayerOrderSeriJson {
    val sb = StringBuilder()
    val SP = ","

    fun traverse(node: TreeNode){
        val list = LinkedList<TreeNode?>()
        list.add(node)
        while (!list.isEmpty()){
            val poll = list.poll()
            if (poll == null){
                sb.append("#").append(SP)
                continue
            } else {
                sb.append(poll.`val`).append(SP)
            }
            list.add(poll.left)
            list.add(poll.right)
        }
    }

    fun deserialize(data: String): TreeNode?{
        if (data.isEmpty())return null
        val split = data.split(SP)
        val parent = TreeNode(split[0].toInt())
        var j=0
        for (i in split.indices){
            val left = split[j++]
            if (left != "#") {
                parent.left = TreeNode(left.toInt())
            } else {
                parent.left = null
            }
            val right = split[j++]
            if (right != "#"){
                parent.right = TreeNode(right.toInt())
            } else {
                parent.right = null
            }
        }
        return parent
    }
}