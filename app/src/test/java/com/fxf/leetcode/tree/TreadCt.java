package com.fxf.leetcode.tree;

import org.junit.Test;

public class TreadCt {

    @Test
    public void main(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    public void flatten(TreeNode root) {
        if(root == null)return;

        TreeNode head = node;
        backtrack(root);
        print(head.right);
    }
    private TreeNode node = new TreeNode();
    private void print(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val);
        print(node.left);
        print(node.right);
    }

    private void backtrack(TreeNode root){
        if(root == null){
            return;
        }
        node.right = new TreeNode(root.val);
        node.left = null;
        node = node.right;
        backtrack(root.left);
        backtrack(root.right);
    }
}
