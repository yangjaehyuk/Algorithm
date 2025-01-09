import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n];
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else{
            dp[0] = 1;
            dp[1] = 2;
            for(int i=2;i<n;i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
        }
        answer = dp[n - 1];
        return answer;
    }
}