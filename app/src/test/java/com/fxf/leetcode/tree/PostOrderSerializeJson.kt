package com.fxf.leetcode.tree

import com.fxf.leetcode.TreeNode
import java.lang.StringBuilder
import java.util.*

class PostOrderSerializeJson {
    val sb = StringBuilder()
    val SEP = ","

    fun traverse(root: TreeNode?){
        if (root == null){
            sb.append("#").append(SEP)
            return
        }
        traverse(root.left)
        traverse(root.right)
        sb.append(root.`val`).append(SEP)
    }

    fun deserialize(data: String?): TreeNode?{
        if (data == null || data.isEmpty()){
            return null
        }
        val split = data.split(SEP)
        val list = LinkedList<String>()
        for (item in split){
            list.add(item)
        }
        return deserialize(list)
    }

    private fun deserialize(data: LinkedList<String>): TreeNode? {
        if (data.isEmpty())return null
        val removeLast = data.removeLast()
        if (removeLast == "#")return null
        val treeNode = TreeNode(removeLast.toInt())
        treeNode.right = deserialize(data)
        treeNode.left  = deserialize(data)
        return treeNode
    }
}