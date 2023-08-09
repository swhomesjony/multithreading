package com.sjony.study.suanfa;

import java.util.ArrayList;
import java.util.List;

public class TreeMid {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public void mid(TreeNode root) {
        if(root.left != null) {
            mid(root.left);
        }
        System.out.println(root.val);
        if(root.right != null) {
            mid(root.left);
        }
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
}
