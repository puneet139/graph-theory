package com.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class MinTimeToCollectApples {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(hasApple==null || hasApple.size()==0){
            return 0;
        }
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(0,-1,adjList,hasApple);
    }

    private int dfs(int node,int parent,List<List<Integer>> adjList, List<Boolean> hasApple){
        int totalTime  = 0;
        int childTime = 0;

        for(int neighbour:adjList.get(node)){

            if(neighbour==parent){
                continue;
            }
            childTime = dfs(neighbour,node,adjList,hasApple);

            if(childTime>0 || hasApple.get(neighbour)){
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}
