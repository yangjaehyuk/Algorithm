
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static long[][] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new long[n][n];
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		dp[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i + arr[i][j] < n && arr[i][j] != 0)
					dp[i + arr[i][j]][j] += dp[i][j];
				if(j + arr[i][j] < n && arr[i][j] != 0)
					dp[i][j + arr[i][j]] += dp[i][j];
			}
		}
		System.out.println(dp[n - 1][n - 1]);	
		
		
	}

}
