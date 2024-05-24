

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==1 || num==2) {
				System.out.println(1);
				continue;
			}
			long[] dp = new long[101];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			for(int j=3;j<num;j++) {
				dp[j] = dp[j-3] + dp[j-2];
			}
			
			System.out.println(dp[num-1]);
		}
	}
}
