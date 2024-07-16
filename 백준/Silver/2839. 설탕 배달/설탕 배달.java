
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int[] dp;
    // 3kg와 5kg 봉지
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        if(n >= 3){
            dp[3] = 1;
        }
        if(n >= 5){
            dp[5] = 1;
        }
        for(int i = 6; i <= n; i++){
            if(i % 5 == 0){
                dp[i] = dp[i - 5] + 1;
            }
            else if(i % 3 == 0){
                dp[i] = dp[i - 3] + 1;
            }
            else{
                if(dp[i - 3] != 0  && dp[i - 5] != 0) dp[i] = Math.min(dp[i - 5], dp[i - 3]) + 1;
            }
        }

        if(dp[n] == 0) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
