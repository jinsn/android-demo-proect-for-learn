package com.glucowell.learnapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */



    public boolean isValidBST(TreeNode root) {
        boolean a=true;
        List<Integer> all=inOrder(root);
        if(all.size()==1){
            return true;
        }
        for (int i=0;i<all.size()-1;i++){
            if(all.get(i)>all.get(i+1)){a=false;}
        }
        return a;
    }

    public List<Integer> inOrder(TreeNode root){
        if(root==null){
            return null;
        }
        List<Integer> a =new ArrayList<>();
        if(root.getLeft()!=null){
            a.addAll(inOrder(root.getLeft()));
        }  if(root.getRight()!=null){
            a.addAll(inOrder(root.getRight()));
        }
        return a;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


}
