import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int n = N;
        int[][] arr = new int[n+1][n+1];

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                if(k == i){
                    arr[k][i] = 0;
                    continue;
                }
                arr[k][i] = 123456789;
            }
        }
        
        for(int k=0;k<road.length;k++){
            arr[road[k][0]][road[k][1]] = Math.min(arr[road[k][0]][road[k][1]], road[k][2]);
            arr[road[k][1]][road[k][0]] = Math.min(arr[road[k][0]][road[k][1]], road[k][2]);
        }
        
        
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(arr[1][i] <= K) answer++;
        }
        return answer;
    }
}