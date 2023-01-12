package com.leetcode.graphs.dfs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumNodesWithSameLabelTest {

    NumNodesWithSameLabel numNodesWithSameLabel;

    @Before
    public void setUp(){
        numNodesWithSameLabel = new NumNodesWithSameLabel();
    }

    @After
    public void tearDown(){
        numNodesWithSameLabel = null;
    }

    @Test
    public void test1(){
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        String labels = "abaedcd";
        Assert.assertEquals(2,numNodesWithSameLabel.countSubTrees(n,edges,labels)[0]);
    }

    @Test
    public void test2(){
        int n =4;
        int[][] edges = {{0,1},{1,2},{0,3}};
        String labels = "bbbb";
        Assert.assertEquals(4,numNodesWithSameLabel.countSubTrees(n,edges,labels)[0]);
    }

    @Test
    public void test3(){
        int n=5;
        int[][] edges = {{0,1},{0,2},{1,3},{0,4}};
        String labels = "aabab";
        Assert.assertEquals(3,numNodesWithSameLabel.countSubTrees(n,edges,labels)[0]);
    }
}

