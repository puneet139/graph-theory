package com.leetcode.graphs.bfs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SnakesLadderTest {

    SnakesLadder snakesLadder;

    @Before
    public void setUp(){
        snakesLadder = new SnakesLadder();
    }

    @After
    public void tearDown(){
        snakesLadder = null;
    }

    @Test
    public void test1(){
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        Assert.assertEquals(4,snakesLadder.snakesAndLadders(board));
    }

    @Test
    public void test2(){
        int[][] board = {{-1,-1},{-1,3}};
        Assert.assertEquals(1,snakesLadder.snakesAndLadders(board));
    }
}

