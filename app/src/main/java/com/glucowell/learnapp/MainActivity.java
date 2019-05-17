package com.glucowell.learnapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.utils.ImageUtils;

import static me.goldze.mvvmhabit.utils.Utils.getContext;

public class MainActivity extends AppCompatActivity {

    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MV)findViewById(R.id.v)).start();
            ImagePicker.getInstance().setMultiMode(true);
            ImagePicker.getInstance().setImageLoader(new GlideImageLoader());
            ImagePicker.getInstance().setSelectLimit(4);
            Intent intent = new Intent(this, ImageGridActivity.class);
            startActivityForResult(intent,2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 2) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                Toast.makeText(this, "数据"+images.size(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */


    /*找节点的子节点和父节点可以利用简单的算术计算它们在数组中的索引值

设某个节点索引值为index,则节点的左子节点索引为:

2*index+1

右子节点索引为:

2*index+2

父节点索引为:

(index-1)/2

*/


    public List<Integer> preorderTraversal(TreeNode root) {

        if(root==null){
            return null;
        }
        //recursive
        List<Integer> result=new ArrayList<>();
        result.add(root.getVal());
        if(root.getLeft()!=null){
            result.addAll(preorderTraversal(root.getLeft()));
        }if(root.getRight()!=null){
            result.addAll(preorderTraversal(root.getRight()));
        }
        return result;
    }




    public static  class MyCircularQueue {

        int head;int rail;

        int[] a;

        int size;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            a=new int[k];
            head=rail=-1;
            size=k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(head==-1){
                head++;
                rail++;
                a[head]=value;
                return true;
            }
            else {
                if(isFull()){
                    return false;
                }
                else {
                    if(rail!=size-1){
                        rail++;
                        a[rail]=value;
                    }else {
                        rail=0;
                        a[rail]=value;
                    }
                    return true;
                }
            }
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            else {
                int tmp=head;
                if(head==size-1){
                    head=0;
                }else {
                    head++;
                }
                if(rail==tmp){
                    head=rail=-1;
                }
                return true;
            }
        }

        /** Get the front item from the queue. */
        public int Front() {
            return (isEmpty()? -1 : a[head]);
    }

        /** Get the last item from the queue. */
        public int Rear() {
            return (isEmpty()? null : a[rail]);
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return (head==-1);
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {

            int railAfter=(rail+1)%size;
            return railAfter==head;

        }
    }



    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x; }


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

    /**
     * Return the length of the shortest path between root and target node.
     */

}
