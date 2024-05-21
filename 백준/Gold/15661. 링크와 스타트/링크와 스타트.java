
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][] arr;
	public static int mini = 999;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] docs = br.readLine().split(" ");
			for(int j=0;j<docs.length;j++) {
				arr[i][j]=Integer.parseInt(docs[j]);
			}
		}
		boolean[] visited = new boolean[n];
		for(int i=1;i<n;i++) {
			dfs(0, 0, i, visited);
			
		}
		System.out.println(mini);
		
	}
	
	public static void dfs(int cri, int lev, int level, boolean[] visited) {
		if(lev==level) {
			mini = Math.min(mini, diff(visited));
			if(mini==0) {
				System.out.println(0);
				System.exit(0);
			}
			return;
			
		}
		
		for(int i=cri;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, lev+1, level, visited);
				visited[i] = false;
			
			}
		}
	}
	
	public static int diff(boolean[] visited) {
		int start = 0;
		int link = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++){
				if(i==j) continue;
				if(visited[i] && visited[j]) start+=arr[i][j];
				else if(!visited[i] && !visited[j]) link+=arr[i][j];
			}
		}
		return Math.abs(link-start);
	}
}
