package com.glucowell.learnapp;

public class Search {

    public MainActivity.TreeNode searchBST(MainActivity.TreeNode root, int val) {

        if(root==null){
            return null;
        }
        if(root.getVal()==val){
            return root;
        }
        return searchBST(root.getVal()>val? root.getLeft()
                :root.getRight(),val);


    }
}
