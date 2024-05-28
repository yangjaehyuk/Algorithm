
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 1 1
		// 2 3
		// 3 5
		// 4 11
		
		int[] dp = new int[n+1];
		if(n==1) {
			System.out.println(1);
			return;
		}
		else if(n==2) {
			System.out.println(3);
			return;
		}
		else {
			dp[1] = 1;
			dp[2] = 3;
			for(int i=3;i<=n;i++) {
				dp[i] = (dp[i-1]+2*dp[i-2])%10007;
			}
			System.out.println(dp[n]);
		}
		
		
	}
}
