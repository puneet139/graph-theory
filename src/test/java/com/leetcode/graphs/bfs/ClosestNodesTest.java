package com.leetcode.graphs.bfs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClosestNodesTest {

    ClosestNodes closestNodes;

    @Before
    public void setUp(){
        closestNodes = new ClosestNodes();
    }

    @After
    public void tearDown(){
        closestNodes = null;
    }

    @Test
    public void test1(){
        int[] edges = {2,2,3,-1};
        int node1 = 0;
        int node2 = 1;
        Assert.assertEquals(2,closestNodes.closestMeetingNode(edges,node1,node2));
    }

    @Test
    public void test2(){
        int[] edges = {1,2,-1};
        int node1 = 0;
        int node2 = 2;
        Assert.assertEquals(2,closestNodes.closestMeetingNode(edges,node1,node2));
    }
}
