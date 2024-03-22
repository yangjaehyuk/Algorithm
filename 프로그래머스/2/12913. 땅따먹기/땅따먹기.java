import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length+1][land[0].length];
        for(int i=1;i<=land.length;i++){
            for(int j=0;j<land[0].length;j++){
                for(int k=0;k<land[0].length;k++){
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i - 1][j] + dp[i - 1][k]);
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        return answer;
    }
}