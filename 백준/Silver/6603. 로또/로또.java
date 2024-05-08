
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringBuilder sb = new StringBuilder();
			String[] tmp = br.readLine().split(" ");
			int len = Integer.parseInt(tmp[0]);
			int[] path = new int[len];
			int[] arr = new int[len];
			boolean[] visited = new boolean[len];
			if(len == 0) break;
			else {
				for(int i=1;i<=len;i++) {
					arr[i-1] = Integer.parseInt(tmp[i]);
				}
				Arrays.sort(arr);
				dfs(0,0,6,sb,path,arr,visited);
				System.out.print(sb.toString());
				System.out.println();
			}
		}
	}
	
	public static void dfs(int cri, int lev, int level, StringBuilder sb, int[] path, int[] arr, boolean[] visited) {
		if(lev==level) {
			for(int i=0;i<lev;i++) {
					sb.append(path[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=cri;i<arr.length;i++) {
			if(!visited[i]) {
				path[lev] = arr[i];
				visited[i] = true;
				dfs(i+1,lev+1, level, sb, path, arr, visited);
				visited[i] = false;
			}
			
		}
	}
	
	
}
