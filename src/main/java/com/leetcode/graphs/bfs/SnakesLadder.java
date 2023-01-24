package com.leetcode.graphs.bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesLadder {

        static class Pair{
            int key;
            int value;

            Pair(int k,int v){
                key = k;
                value = v;
            }
        }

        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            Pair[] cells = new Pair[(n*n) + 1];
            int[] dist = new int[(n*n)+1];
            Integer[] columns = new Integer[n];
            for(int i=0;i<n;i++){
                columns[i] = i;
            }
            int label = 1;
            for(int row=n-1;row>=0;row--){
                for(int cols:columns){
                    cells[label++] = new  Pair(row,cols);
                }
                Collections.reverse(Arrays.asList(columns));
            }

            for(int i=0;i<dist.length;i++){
                dist[i] = -1;
            }
            Queue<Integer> pairQueue = new LinkedList<>();
            pairQueue.add(1);
            dist[1] = 0;
            while(!pairQueue.isEmpty()){
                int p = pairQueue.poll();
                for(int next=p+1;next<=Math.min(p+6,n*n);next++){
                    int row = cells[next].key;
                    int col = cells[next].value;
                    int destination = (board[row][col]!=-1)?board[row][col]:next;
                    if(dist[destination]==-1){
                        dist[destination] = dist[p]+ 1;
                        pairQueue.add(destination);
                    }
                }

            }
            return dist[n*n];
        }
}
