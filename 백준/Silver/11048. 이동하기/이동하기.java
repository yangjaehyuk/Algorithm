
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {1,0,1};
	static int[] dy = {0,1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int n = Integer.parseInt(docs[0]);
		int m = Integer.parseInt(docs[1]);
		arr = new int[n][m];
		dp = new int[n + 1][m + 1];
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
  			}
		}
		int startx = 0;
		int starty = 0;
		dp[0][0] = arr[0][0];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {

				startx = i;
				starty = j;
				for(int k=0;k<3;k++) {
					int nx = startx + dx[k];
					int ny = starty + dy[k];
					if(nx < n && ny < m) {
						dp[nx][ny] = Math.max(dp[nx][ny], arr[nx][ny] + dp[startx][starty]);
						
					}
				}
			}
			
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[n-1][m-1]);
	}
}
