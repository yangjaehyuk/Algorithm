
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[][] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n][10];
		int idx = 1;
		for(int i=0;i<10;i++) {
			dp[0][i] = idx++;
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<10;j++) {
				if(j == 0) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
				}
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<10;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(1 + 3 + 6 + 10 + 15 + 21 + 28 + 36 + 45 + 55);
		System.out.println(dp[n - 1][9]);
		
	}
}
