
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int[] dp;
    static int maxi = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        arr = new int[n + 1];
        dp = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(tmp[i - 1]);
        }
        for(int i = 0; i < n + 1; i++){
            dp[i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            maxi = Math.max(maxi, dp[i]);
        }
        System.out.println(maxi);
    }
}
