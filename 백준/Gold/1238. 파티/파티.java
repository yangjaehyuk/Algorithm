
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int maxi = 0;
	public static int[][] arr;
	public static int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int n = Integer.parseInt(docs[0]);
		int m = Integer.parseInt(docs[1]);
		int x = Integer.parseInt(docs[2]);
		arr = new int[n+1][n+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==j) {
					arr[i][j]=0;
					continue;
				}
				arr[i][j] = INF;
			}
		}
		for(int i=0;i<m;i++) {
			String[] tmps = br.readLine().split(" ");
			int start = Integer.parseInt(tmps[0]);
			int end = Integer.parseInt(tmps[1]);
			int weight = Integer.parseInt(tmps[2]);
			if(arr[start][end]>weight) {
				arr[start][end] = weight;
			}
		}
		
		floyd(n);
		for(int i=1;i<=n;i++) {
			int sum = 0;
			for(int j=1;j<=n;j++) {
				if(j==x) {
					sum+=arr[i][j];
					sum+=arr[j][i];
				}
			}
			maxi = Math.max(sum, maxi);
			
		}
		System.out.println(maxi);
	}
	
	public static void floyd(int n) {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(arr[i][k]==INF) continue;
				for(int j=1;j<=n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
	}
	
}
