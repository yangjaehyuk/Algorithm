import java.util.*;
class Solution {
    public int solution(int n) {
        // 가로의 길이2, 세로의 길이1인 타일
        // 세로의 길이2, 가로의 길이n
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        int answer = 0;
        for(int i=2;i<n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n-1];
    }
}