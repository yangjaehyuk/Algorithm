import java.util.*;
class Solution {
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new int[n][n];
        visited = new boolean[n];
        
        
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(i==j) continue;
                if(computers[i][j] == 1 && computers[i][j] == computers[j][i]){
                    graph[i][j] = 1;
                    graph[j][i] = graph[i][j];
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public static void dfs(int start){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(i==j) continue;
                if(graph[start][i] == 1 && graph[i][start] == 1 && !visited[i]){
                    visited[i] = true;
                    dfs(i);
                }
            }
        }
    }
}