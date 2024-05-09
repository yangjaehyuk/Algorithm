
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr;
	public static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int target = Integer.parseInt(tmp[1]);
		arr = new int[n];
		boolean[] visited = new boolean[n];
		int[] path = new int[n];
		String[] docs = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(docs[i]);
		}
		for(int i=1;i<=n;i++) {
			dfs(0, 0, i, target, path, visited);
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int cri, int lev, int level, int target, int[] path, boolean[] visited) {
		if(lev==level) {
			int sum = 0;
			for(int i=0;i<lev;i++) {
				sum += path[i];
			}
			if(sum == target) {
				cnt++;
			}
			return;
		}
		
		
		for(int i=cri;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				path[lev] = arr[i];
				dfs(i+1, lev+1, level, target, path, visited);
				visited[i] = false;
			}
		}
	}
}
