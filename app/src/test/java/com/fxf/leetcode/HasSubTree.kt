package com.fxf.leetcode

class HasSubTree {

    /**
     * 判断A中是否包含B子树
     */
    fun hasSubTree(root1: TreeNode?,root2: TreeNode?): Boolean {
        if (root1 == root2){
            return true
        }
        if (root1 == null){
            return false
        }
        if (root2 == null){
            return true
        }
        var result = false
        if (root1.`val` == root2.`val`){
            result = match(root1,root2)
        }
        if (result){
            return true
        }
        return hasSubTree(root1.left,root2) || hasSubTree(root1.right,root2)
    }

    fun match(root1: TreeNode?,root2: TreeNode?): Boolean{
        if (root1 == root2){
            return true
        }
        if (root2 == null){
            return true
        }
        if (root1 == null){
            return false
        }
        if (root1.`val` == root2.`val`){
            return match(root1.left,root2.left) && match(root1.right, root2.right)
        }
        return false
    }
}