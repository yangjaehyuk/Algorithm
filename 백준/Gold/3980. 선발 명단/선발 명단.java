
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int maxi = -1;
	public static boolean[] visited;
	public static int[][] arr;
	public static int[] path;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			path = new int[11];
			arr = new int[11][11];
			visited = new boolean[11];
			for(int j=0;j<11;j++) {
				String[] temp = br.readLine().split(" ");
				for(int k=0;k<temp.length;k++) {
					arr[j][k] = Integer.parseInt(temp[k]);
				}
			}
			dfs(0);
			System.out.println(maxi);
			maxi = -1;
		}
	}
	
	public static void dfs(int lev) {
		if(lev==11) {
			int sum = 0;
			for(int i=0;i<11;i++) {
				sum += path[i];
			}
			maxi = Math.max(maxi, sum);
		}
		
		for(int i=0;i<11;i++) {
			if(!visited[i] && arr[lev][i]!=0) {
				visited[i] = true;
				path[lev] = arr[lev][i];
				dfs(lev+1);
				visited[i] = false;
			}
		}
		
	}
}
