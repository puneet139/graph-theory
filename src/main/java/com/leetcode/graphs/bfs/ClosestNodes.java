package com.leetcode.graphs.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ClosestNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int numNodes = edges.length;
        int[] dist1 = new int[numNodes];
        int[] dist2 = new int[numNodes];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(node1, dist1, edges);
        bfs(node2, dist2, edges);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;

        for (int i = 0; i < numNodes; i++) {
            if (minDistTillNow > Math.max(dist1[i], dist2[i])) {
                minDistNode = i;
                minDistTillNow = Math.max(dist1[i], dist2[i]);
            }
        }
        return minDistNode;
    }

    private void bfs(int node1, int[] dist, int[] edges) {
        boolean[] visited = new boolean[edges.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(node1);
        visited[node1] = true;
        dist[node1] = 0;
        while (!q.isEmpty()) {
            int n = q.poll();
            int neighbour = edges[n];
            if (neighbour != -1 && !visited[neighbour]) {
                visited[neighbour] = true;
                dist[neighbour] = dist[n] + 1;
                q.add(neighbour);
            }
        }
    }
}

