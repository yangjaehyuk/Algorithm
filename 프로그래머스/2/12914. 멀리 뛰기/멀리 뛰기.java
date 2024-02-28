import java.util.*;
class Solution {
    // int[] arr = {1,2};
    long answer = 0;
    public long solution(int n) {
        // 한 번에 1칸, 또는 2칸
        // int[] path = new int[n];
        // for(int i=1;i<=n;i++){
        //     dfs(0, i, n, path);
        // }
        if(n==1) return 1;
        else if(n==2) return 2;
        else{
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3;i<=n;i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
                if(dp[i] < 0) dp[i] += 1234567;
            }
            return dp[n];
        }
        
    }
//     public void dfs(int lev, int level, int n, int[] path){
//         if(lev==level){
//             int sum = 0;
//             for(int i=0;i<level;i++){
//                 sum += path[i];
//             }
//             if(sum == n) answer++;
//             return;
//         }
        
//         for(int i=0;i<2;i++){
//             path[lev] = arr[i];
//             dfs(lev+1, level, n, path);
//         }
//     }
    
}