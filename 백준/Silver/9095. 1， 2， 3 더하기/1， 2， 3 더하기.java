
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==1) {
				System.out.println(1);
				continue;
			}
			else if(num==2) {
				System.out.println(2);
				continue;
			}
			else if(num==3) {
				System.out.println(4);
				continue;
			}
			else {
				int[] dp = new int[num];
				dp[0]=1;
				dp[1]=2;
				dp[2]=4;
				for(int j=3;j<num;j++) {
					dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
				}
				System.out.println(dp[num-1]);
			}
		}
	}
}
