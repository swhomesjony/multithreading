package com.sjony.study.suanfa;

import java.util.ArrayList;
import java.util.List;

public class TreePre {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        pre(root, result);
        return result;
    }

    public void pre(TreeNode root, List<Integer> add) {
        if(root != null) {
            add.add(root.val);
        }
        if(root.left != null) {
            pre(root.left, add);
        }
        if(root.right != null) {
            pre(root.left, add);
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
