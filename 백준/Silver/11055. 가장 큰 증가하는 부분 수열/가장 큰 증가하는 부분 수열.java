

import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] dp;
    static int maxi = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        dp = new int[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        dp[1] = arr[1];
        for(int i=2;i<=n;i++){
            dp[i] = arr[i];
            for(int j=1;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            maxi = Math.max(maxi, dp[i]);
        }
//        System.out.println();
        System.out.println(maxi);
    }
}
