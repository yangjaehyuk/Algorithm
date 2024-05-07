
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] container;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		container = new int[n];
		String[] res = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			container[i] = Integer.parseInt(res[i]);
		}
		int[] path = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.sort(container);
		
		dfs(0,m,path, visited);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int lev, int level, int[] path, boolean[] visited) {
		if(lev==level) {
			for(int i=0;i<lev;i++) {
				sb.append(path[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<container.length;i++) {
			if(!visited[i]) {
				path[lev] = container[i];
				visited[i] = true;
				dfs(lev+1, level, path, visited);
				visited[i] = false;
			}
		}
		
	}

}
