
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] container;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		String[] tmp = br.readLine().split(" ");
		container = new int[n];
		for(int i=0;i<n;i++) {
			container[i] = Integer.parseInt(tmp[i]);
		}
		int[] path = new int[n];
		Arrays.sort(container);
		dfs(0,0,m,path);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int cri, int lev, int level, int[] path) {
		if(lev==level) {
			for(int i=0;i<lev;i++) {
				sb.append(path[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=cri;i<container.length;i++) {
			path[lev] = container[i];
			dfs(i+1, lev+1, level, path);
		}
		
	}

}
