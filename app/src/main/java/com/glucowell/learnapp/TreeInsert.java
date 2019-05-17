package com.glucowell.learnapp;

public class TreeInsert {

    public MainActivity.TreeNode insertIntoBST(MainActivity.TreeNode root, int val) {
        MainActivity.TreeNode original=root;
        insert(root,val);
        return root;

    }

    public void insert(MainActivity.TreeNode root, int val){
        if (root == null) {
            root=new MainActivity.TreeNode(val);
        }
        insertIntoBST(root.getVal()>val? root.getLeft()
                :root.getRight(),val);
    }
}
