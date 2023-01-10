package com.leetcode.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v){
            val = v;
            left = right = null;
        }

    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left!=null){
                if(n.left.left==null && n.left.right==null){
                    sum+= n.left.val;
                }
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
        return sum;
    }
}
