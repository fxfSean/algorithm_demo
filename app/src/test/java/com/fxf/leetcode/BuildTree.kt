package com.fxf.leetcode

class BuildTree {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树
     */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = HashMap<Int,Int>()
        for(i in inorder.indices){
            map[inorder[i]] = i
        }
        return buildTree(preorder,0,preorder.size-1,inorder,0,inorder.size-1,map)
    }
    fun buildTree(preorder: IntArray,preStart: Int,preEnd: Int,inorder: IntArray,inStart: Int,inEnd: Int,map: HashMap<Int,Int>): TreeNode?{
        if(preStart>preEnd || inStart > inEnd){
            return null
        }
        val root = TreeNode(preorder[preStart])
        val rootIndex = map[preorder[preStart]]!!
        val leftPreSize = rootIndex - inStart
        root.left =  buildTree(preorder,preStart+1,preStart+leftPreSize,inorder,inStart,rootIndex -1,map)
        root.right = buildTree(preorder,preStart+leftPreSize+1,preEnd,inorder,rootIndex+1,inEnd,map)
        return root
    }
}