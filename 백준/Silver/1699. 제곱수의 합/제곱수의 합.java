

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j * j<=i;j++){
                if(dp[i] == 0) dp[i] = dp[i - j * j] + 1;
                else dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
//        for(int i=1;i<=n;i++){
//            System.out.println(dp[i]);
//        }
        System.out.println(dp[n]);
    }


}
