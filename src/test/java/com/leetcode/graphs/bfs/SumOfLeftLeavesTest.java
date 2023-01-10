package com.leetcode.graphs.bfs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumOfLeftLeavesTest {

    SumOfLeftLeaves sumOfLeftLeaves;

    @Before
    public void setUp(){
        sumOfLeftLeaves = new SumOfLeftLeaves();
    }

    @After
    public void tearDown(){
        sumOfLeftLeaves = null;
    }

    @Test
    public void test1(){
        SumOfLeftLeaves.TreeNode root = new SumOfLeftLeaves.TreeNode(3);
        root.left = new SumOfLeftLeaves.TreeNode(9);
        root.right = new SumOfLeftLeaves.TreeNode(20);
        root.left.left=null;
        root.left.right=null;
        root.right.left = new SumOfLeftLeaves.TreeNode(15);
        root.right.right = new SumOfLeftLeaves.TreeNode(7);

        Assert.assertEquals(24,sumOfLeftLeaves.sumOfLeftLeaves(root));
    }

    @Test
    public void test2(){
        SumOfLeftLeaves.TreeNode root = new SumOfLeftLeaves.TreeNode(1);
        root.left = null;
        root.right = null;

        Assert.assertEquals(0,sumOfLeftLeaves.sumOfLeftLeaves(root));
    }
}
