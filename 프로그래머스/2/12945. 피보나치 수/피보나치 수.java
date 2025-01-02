import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        for(int j=2;j<=n;j++){
            dp[j] = (dp[j-1] + dp[j-2]) % 1234567;
        }
        answer = dp[n];
        return answer;
    }
}