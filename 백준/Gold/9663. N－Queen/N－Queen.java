
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n = 0;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		boolean[] visited1 = new boolean[n];
		boolean[] visited2 = new boolean[n+n];
		boolean[] visited3 = new boolean[n+n];
		dfs(0,n,visited1,visited2,visited3);
		System.out.println(cnt);
	}
	
	public static void dfs(int lev, int level, boolean[] visited1, boolean[] visited2, boolean[] visited3) {
		if(lev == level) {
			cnt ++;
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			if(visited1[i] || visited2[lev+i] || visited3[lev-i+n-1]) {
				continue;
			}
			visited1[i] = true;
			visited2[i+lev] = true;
			visited3[lev-i+n-1] = true;
			dfs(lev+1, level, visited1, visited2, visited3);
			visited1[i] = false;
			visited2[i+lev] = false;
			visited3[lev-i+n-1] = false;
		}
	}
}
