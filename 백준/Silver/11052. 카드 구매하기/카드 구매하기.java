
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		arr = new int[n + 1];
		dp = new int[n + 1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(tmp[i - 1]);
		}
		for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }
		
		System.out.println(dp[n]);
	}

}
