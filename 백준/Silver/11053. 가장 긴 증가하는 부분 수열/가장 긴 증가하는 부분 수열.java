import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] arr;
    static int maxi = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        arr = new int[n];
        dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        for(int i = 0; i < n + 1; i++){
            dp[i] = 1;
        }
        if(n == 1){
            System.out.println(1);
            return;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        System.out.println(maxi);
//        for(int i=0;i<n;i++){
//            System.out.print(dp[i]+" ");
//        }

    }
}
