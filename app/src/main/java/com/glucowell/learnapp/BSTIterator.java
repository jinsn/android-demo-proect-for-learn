package com.glucowell.learnapp;

import java.util.Stack;

public class BSTIterator {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

       Stack<MainActivity.TreeNode> stack=new Stack<>();

       public BSTIterator(MainActivity.TreeNode root) {
            pushAll(root);
        }

    private void pushAll(MainActivity.TreeNode root) {
            if(root!=null) stack.push(root);
            pushAll(root.getLeft());
    }


    /** @return the next smallest number */
        public int next() {
            if(hasNext()){
                MainActivity.TreeNode node=stack.pop();
                pushAll(node.getRight());
                return node.getVal();
            }
            else {
                return -1;

            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.isEmpty();
        }

}
