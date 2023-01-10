package com.leetcode.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBfs {

    private int vertices;

    private boolean[] visited;

    List<List<Integer>> adjList;

    GraphBfs(int v){
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

    public List<Integer> bfs(){
        List<Integer> verticesList = new ArrayList<>();
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                bfsRec(i,verticesList);
            }
        }
        return verticesList;
    }

    private void bfsRec(int start,List<Integer> verticesList){
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            verticesList.add(q.poll());
            for(int neighbour:adjList.get(start)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }


    public static void main(String[] args) {
        GraphBfs g = new GraphBfs(5);
        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(2,3);
        g.addEdge(2,4);


        List<Integer> ans = g.bfs();
        for(int v:ans){
            System.out.print(v+" ");
        }
    }

}
