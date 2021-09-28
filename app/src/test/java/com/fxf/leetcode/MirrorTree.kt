package com.fxf.leetcode

class MirrorTree {

    /**
     * 请完成一个函数，输入...个二叉树，该函数输出它的镜像
     */
    fun mirror(tree: TreeNode?){
        if (tree == null){
            return
        }
        val temp = tree.left
        tree.left = tree.right
        tree.right = temp

        mirror(tree.left)
        mirror(tree.right)
    }
}