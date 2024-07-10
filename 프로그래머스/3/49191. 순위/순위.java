import java.util.*;
class Solution {
    static int[][] dist;
    public int solution(int n, int[][] results) {
        dist = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j) continue;
                for(int k=0;k<results.length;k++){
                    dist[results[k][0]][results[k][1]] = 1;
                    dist[results[k][1]][results[k][0]] = -1;
                }
            }
        }
        int answer = 0;
        floyd(n+1);
        for(int i=1;i<n+1;i++){
            int cnt = 0;
            for(int j=1;j<n+1;j++){
                if(dist[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }
    
    public static void floyd(int n){
        for(int k=1;k<n;k++){
            for(int i=1;i<n;i++){
                for(int j=1;j<n;j++){
                    if(i == j) continue;
                    if(dist[i][k] == 1 && dist[k][j] == 1){
                        dist[i][j] = 1;
                        dist[j][i] = -1;
                    }
                    if(dist[i][k] == -1 && dist[k][j] == -1){
                        dist[i][j] = -1;
                        dist[j][i] = 1;
                    }
                    
                }
            }
        }
    }
}