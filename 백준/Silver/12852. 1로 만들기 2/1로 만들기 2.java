
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}

		System.out.println(dp[n]);
		while(n > 1) {
			list.add(n);
			if(n % 6 == 0) {
				int cur = Math.min(dp[n - 1], Math.min(dp[n / 3], dp[n / 2]));
				if(cur == dp[n - 1]) {
					n--;
				}
				else if(cur == dp[n / 3]) {
					n /= 3;
				}
				else if(cur == dp[n / 2]) {
					n /= 2;
				}
			}
			else if(n % 3 == 0) {
				int cur = Math.min(dp[n - 1], dp[n / 3]);
				if(cur == dp[n - 1]) {
					n--;
				}
				else {
					n /= 3;
				}
			}
			else if(n % 2 == 0) {
				int cur = Math.min(dp[n - 1], dp[n / 2]);
				if(cur == dp[n - 1]) {
					n--;
				}
				else {
					n /= 2;
				}
			}
			else {
				n--;
			}
		}
		list.add(1);
		for(Integer item: list) {
			System.out.print(item+" ");
		}
	}

}
