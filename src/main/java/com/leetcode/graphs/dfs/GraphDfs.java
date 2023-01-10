package com.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphDfs {

    private int vertices;

    private boolean[] visited;

    List<List<Integer>> adjList;

    GraphDfs(int v){
        vertices = v;
        visited = new boolean[v];
        adjList = new ArrayList<>(v);
        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public List<Integer> dfs(){
        List<Integer> verticesList = new ArrayList<>();
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                dfsRec(i,verticesList);
            }
        }
        return verticesList;
    }

    private void dfsRec(int start,List<Integer> verticesList){
        visited[start] = true;
        verticesList.add(start);
        for(int neighbour:adjList.get(start)){
            if(!visited[neighbour]){
                dfsRec(neighbour,verticesList);
            }
        }
    }


    public static void main(String[] args) {
        GraphDfs g = new GraphDfs(5);
        g.addEdge(0,4);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(1,2);


        List<Integer> ans = g.dfs();
        for(int v:ans){
            System.out.print(v+" ");
        }
    }
}
