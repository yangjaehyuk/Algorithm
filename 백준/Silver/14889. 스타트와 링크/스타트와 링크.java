
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int mini = 9999;
	public static int[][] arr;
	public static int[] array;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		arr = new int[n][n];
		int[] path = new int[n];
		boolean[] visited = new boolean[n];
		array = new int[n];
		for(int j=0;j<n;j++) {
			array[j] = j;
		}
		for(int i=0;i<n;i++) {
			String[] docs = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(docs[j]);
			}
		}
		dfs(0,0,n/2,path,visited);
		System.out.println(mini);
	}
	
	public static void dfs(int cri, int lev, int level, int[] path, boolean[] visited) {
		if(lev == level) {
			mini = Math.min(mini, diff(path, visited));
			
			return;
		}
		
		for(int i=cri;i<array.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				path[lev] = array[i];
				dfs(i+1,lev+1, level, path, visited);
				visited[i] = false;
			}
		}
	}
	
	public static int diff(int[] path, boolean[] visited) {
		int start = 0;
		int link = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) continue;
				if(visited[i] && visited[j]) start+=arr[i][j];
				if(!visited[i] && !visited[j]) link+=arr[i][j];
			}
		}
		return Math.abs(link-start);
		
	}

}
