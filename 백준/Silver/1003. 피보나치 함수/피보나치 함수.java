
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<41;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) System.out.println(1+" "+dp[num]);
			else System.out.println(dp[num-1]+" "+dp[num]);
		}
	}
}
