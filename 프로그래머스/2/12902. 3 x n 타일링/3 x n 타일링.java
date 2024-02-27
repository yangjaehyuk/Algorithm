class Solution {
    public long solution(int n) {
        if(n%2!=0) return 0;
        else{
            long[] dp = new long[n+1];
            dp[0] = 3;
            dp[1] = 11;
            for(int i=2;i<=n/2+1;i++){
                dp[i] = (dp[i-1] * 4 - dp[i-2]) % 1000000007L;
                if(dp[i]<0) dp[i]+=1000000007L;
            }
            return dp[n/2-1];
        }
        
    }
}