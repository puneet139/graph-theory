package com.leetcode.graphs.dfs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SmallestEquivalentStringTest {

    SmallestEquivalentString smallestEquivalentString;

    @Before
    public void setUp(){
        smallestEquivalentString = new SmallestEquivalentString();
    }

    @After
    public void tearDown(){
        smallestEquivalentString = null;
    }

    @Test
    public void test1(){
        String s1="parker";
        String s2="morris";
        String baseStr = "parser";
        Assert.assertEquals("makkek",smallestEquivalentString.smallestEquivalentString(s1,s2,baseStr));
    }

    @Test
    public void test2(){
        String s1="hello";
        String s2="world";
        String baseStr="hold";
        Assert.assertEquals("hdld",smallestEquivalentString.smallestEquivalentString(s1,s2,baseStr));
    }

    @Test
    public void test3(){
        String s1="leetcode";
        String s2="programs";
        String baseStr = "sourcecode";
        Assert.assertEquals("aauaaaaada",smallestEquivalentString.smallestEquivalentString(s1,s2,baseStr));
    }
}
