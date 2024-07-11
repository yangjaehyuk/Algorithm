
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		if(n == 0) {
			System.out.println(0);
			return;
		}
		else if(n == 1) {
			System.out.println(1);
			return;
		}
		else {
			dp[0] = 0;
			dp[1] = 1;
			for(int i=2;i<=n;i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			System.out.println(dp[n]);
		}
	}
}
