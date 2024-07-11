

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n + 1];
		if(n == 1) {
			System.out.print(1);
			return;
		}
		else if(n == 2) {
			System.out.print(1);
			return;
		}
		else {
			dp[0] = 1;
			dp[1] = 1;
			for(int i=2;i<n;i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			System.out.print(dp[n-1]);
			return;
		}
		
	}
}
