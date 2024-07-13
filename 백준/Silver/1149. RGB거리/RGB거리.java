
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] docs = br.readLine().split(" ");
            for(int j=0; j < 3; j++){
                arr[i][j] = Integer.parseInt(docs[j]);
            }
        }

        for(int i = 0; i < 3; i++){
            dp[0][i] = arr[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(j==k) continue;
                    if(dp[i][j] == 0) dp[i][j] = dp[i-1][k] + arr[i][j];
                    else dp[i][j] = Math.min(dp[i-1][k] + arr[i][j], dp[i][j]);
                }
            }
        }

//        for(int i = n-1; i < n; i++){
//            for(int j = 0; j < 3; j++){
//                System.out.print(dp[i][j] + " ");
//
//            }
//            System.out.println();
//        }

        int mini = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            mini = Math.min(mini, dp[n-1][i]);
        }
        System.out.println(mini);

    }

}
