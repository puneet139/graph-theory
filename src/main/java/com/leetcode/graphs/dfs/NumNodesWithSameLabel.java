package com.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class NumNodesWithSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] answer = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0,-1,adjList,labels,answer);
        return answer;
    }

    private int[] dfs(int node, int parent, List<List<Integer>> adjList, String labels, int[] answer){
        int[] nodeCount = new int[26];
        for(int i=0;i<26;i++){
            nodeCount[labels.charAt(node)-'a'] = 1;
        }
        for(int neighbour:adjList.get(node)){
            if(neighbour==parent){
                continue;
            }

            int[] childCount = dfs(neighbour,node,adjList,labels,answer);
            for(int j=0;j<26;j++){
                nodeCount[j] += childCount[j];
            }
        }
        answer[node] = nodeCount[labels.charAt(node)-'a'];
        return nodeCount;
    }
}

