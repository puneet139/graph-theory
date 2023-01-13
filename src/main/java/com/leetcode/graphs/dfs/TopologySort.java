package com.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class TopologySort {

    static class Graph {
         int numVertices;

         List<List<Integer>> adjList;

         Graph(int n){
             numVertices = n;
             adjList = new ArrayList<>();
             for(int i=0;i<numVertices;i++){
                 adjList.add(new ArrayList<>());
             }
         }

         public void addEdge(int u,int v){
             adjList.get(u).add(v);
         }

         public int[] topologicalSort(boolean[] visited,int numVertices,List<List<Integer>> adjList){
             int[] ordering = new int[numVertices];
             for(int i=0;i<numVertices;i++){
                 if(!visited[i]){
                     dfs(i,visited,adjList,ordering);
                 }
             }
             return ordering;
         }

         private int dfs(int start,boolean[] visited,List<List<Integer>> adjList,int[] ordering){
             visited[start] = true;
             for(int neighbour:adjList.get(start)){
                 if(!visited[neighbour]){
                     this.numVertices = dfs(neighbour,visited,adjList,ordering);
                 }
             }
             ordering[--numVertices] = start;
             return numVertices;
         }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 4);
        boolean[] visited = new boolean[g.numVertices];
        int[] ans = g.topologicalSort(visited,g.numVertices,g.adjList);
        for(int a:ans){
            System.out.print(a+" ");
        }
    }

}
