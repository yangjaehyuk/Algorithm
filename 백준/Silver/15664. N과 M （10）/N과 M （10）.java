

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		String[] docs = br.readLine().split(" ");
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(docs[i]);
		}
		int[] path = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.sort(arr);
		dfs(0,0,m,path,visited);
		System.out.print(sb.toString());
	}
	
	public static void dfs(int cri, int lev, int level, int[] path, boolean[] visited) {
		if(lev==level) {
			for(int i=0;i<lev;i++) {
				sb.append(path[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int recent = 0;
		for(int i=cri;i<arr.length;i++) {
			if(!visited[i] && recent!=arr[i]) {
//				System.out.println(recent+" "+arr[i]+" "+path[lev]+" ");
				path[lev] = arr[i];
				recent = path[lev];
				visited[i] = true;
				dfs(i+1, lev+1, level, path, visited);
				visited[i] = false;
			}
		}
	}

}
