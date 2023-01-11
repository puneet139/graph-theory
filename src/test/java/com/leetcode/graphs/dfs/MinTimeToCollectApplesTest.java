package com.leetcode.graphs.dfs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MinTimeToCollectApplesTest {

    MinTimeToCollectApples minTimeToCollectApples;

    @Before
    public void setUp(){
        minTimeToCollectApples = new MinTimeToCollectApples();
    }

    @After
    public void tearDown(){
        minTimeToCollectApples = null;
    }

    @Test
    public void test1(){
        int n=7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApples = new ArrayList<>();
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(true);
        hasApples.add(false);
        hasApples.add(true);
        hasApples.add(true);
        hasApples.add(false);
        Assert.assertEquals(8,minTimeToCollectApples.minTime(n,edges,hasApples));
    }

    @Test
    public void test2(){
        int n=7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApples = new ArrayList<>();
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(true);
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(true);
        hasApples.add(false);
        Assert.assertEquals(6,minTimeToCollectApples.minTime(n,edges,hasApples));
    }

    @Test
    public void test3(){
        int n=7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApples = new ArrayList<>();
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(false);
        Assert.assertEquals(0,minTimeToCollectApples.minTime(n,edges,hasApples));
    }
}
