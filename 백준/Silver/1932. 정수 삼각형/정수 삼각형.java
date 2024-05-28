
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int maxi = 0;
	public static int[][] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] docs = br.readLine().split(" ");
			for(int j=0;j<docs.length;j++) {
				arr[i][j] = Integer.parseInt(docs[j]);
			}
		}
		
		int[][] dp = new int[n][n];
		dp[0][0] = arr[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j>0) {
					// 대각선
					if(Math.max(arr[i-1][j-1], dp[i-1][j-1])+arr[i][j]>dp[i][j]) {
						dp[i][j] = Math.max(arr[i-1][j-1], dp[i-1][j-1])+arr[i][j];
					}
					
				}
				if (Math.max(arr[i-1][j],dp[i-1][j])+arr[i][j]>dp[i][j]) {
					dp[i][j] = Math.max(arr[i-1][j],dp[i-1][j])+arr[i][j];
				}
				
				
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				maxi = Math.max(maxi, dp[i][j]);
			}
		
		}
		System.out.println(maxi);
	}
}
