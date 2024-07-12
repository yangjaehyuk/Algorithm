import java.util.*;
class Solution {
    static int[][] arr;
    static int[][] dp;
    static int not = 123456789;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        arr = new int[n][m];
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<puddles.length;k++){
                    arr[puddles[k][1] - 1][puddles[k][0] - 1] = not;
                }
            }
        }
        
        
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (arr[i][j] == not) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j-1];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
        
        answer = dp[n - 1][m - 1];
        return answer;
    }
}