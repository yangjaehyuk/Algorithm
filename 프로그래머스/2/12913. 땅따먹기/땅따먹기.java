class Solution {
    static int maxi = 0;
    int solution(int[][] land) {
        int answer = 0;
        int m = land.length;
        int n = land[0].length;
        int idx = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<n;i++){
            dp[0][i] = land[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i-1][k] + land[i][j], dp[i][j]);
                }
                
            }
            
            
        }
        for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    maxi = Math.max(maxi, dp[j][k]);
                }
            }
        return maxi;
    }
}