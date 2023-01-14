package com.leetcode.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class SmallestEquivalentString {

    int minChar;


    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Integer[][] adjacencyMatrix = new Integer[26][26];
        boolean[] visited = new boolean[26];

        for(int i=0;i<s1.length();i++){
            adjacencyMatrix[s1.charAt(i)-'a'][s2.charAt(i)-'a']=1;
            adjacencyMatrix[s2.charAt(i)-'a'][s1.charAt(i)-'a']=1;
        }

        int[] mappingChar = new int[26];

        for(int i=0;i<26;i++){
            if(!visited[i]){
                List<Integer> component = new ArrayList<>();
                minChar = 27;
                dfs(i,visited,adjacencyMatrix,component);

                for(int c:component){
                    mappingChar[c] = minChar;
                }
            }
        }
        String ans="";
        for(char cd:baseStr.toCharArray()){
            ans += (char)(mappingChar[cd-'a']+'a');
        }
        return ans;
    }

    private void dfs(int src,boolean[] visited,Integer[][] adjacencyMatrix,List<Integer> component){
        visited[src] = true;

        component.add(src);

        minChar=Math.min(minChar,src);

        for(int i=0;i<26;i++){
            if(adjacencyMatrix[src][i]!=null && !visited[i]){
                dfs(i,visited,adjacencyMatrix,component);
            }
        }
    }
}
