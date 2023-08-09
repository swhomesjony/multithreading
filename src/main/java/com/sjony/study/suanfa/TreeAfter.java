package com.sjony.study.suanfa;

import java.util.ArrayList;
import java.util.List;

public class TreeAfter {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public void after(TreeNode root) {
        if(root.left != null) {
            after(root.left);
        }
        if(root.right != null) {
            after(root.left);
        }
        System.out.println(root.val);
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
