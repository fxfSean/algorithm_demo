package com.fxf.leetcode.tree

import com.fxf.leetcode.TreeNode
import java.lang.StringBuilder
import java.util.*

class PreSerializeJson {
    val sb = StringBuilder()
    val SEP = ","
    fun traverse(root: TreeNode?){
        if (root == null){
            sb.append("#").append(SEP)
            return
        }
        sb.append(root.`val`).append(SEP)
        traverse(root.left)
        traverse(root.right)
    }

    fun deserialize(data: String?): TreeNode?{
        if (data == null || data.isEmpty()){
            return null
        }
        val split = data.split(SEP)
        val nodes = LinkedList<String>()
        for (item in split){
            nodes.add(item)
        }
        return deserialize(nodes)
    }

    private fun deserialize(data: LinkedList<String>): TreeNode? {
        val node = data.removeFirst()
        if (node == "#"){
            return null
        }
        val treeNode = TreeNode(node.toInt())
        treeNode.left = deserialize(data)
        treeNode.right = deserialize(data)

        return treeNode
    }
}