
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        if(n == 1){
            System.out.println(3);
            return;
        }
        dp[0] = 3;
        dp[1] = 7;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] * 2 + dp[i-2];
            if(dp[i] > 9901) dp[i] %= 9901;
        }
        System.out.println(dp[n-1]);

    }
}
