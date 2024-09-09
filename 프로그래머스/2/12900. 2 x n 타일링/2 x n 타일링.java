import java.util.*;
class Solution {
    static int big = 1000000007;
    public int solution(int n) {
        // n = 1 -> 1
        // n = 2 -> 2
        // n = 3 -> 3
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % big;
        }
        int answer = 0;
        answer = dp[n - 1];
        return answer;
    }
}