
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		String[] docs = br.readLine().split(" ");
		arr = new int[n];
		int[] path = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(docs[i]);
		}
		Arrays.sort(arr);
		dfs(0,0,m, path);
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
		for(int i=cri;i<arr.length;i++) {
			path[lev] = arr[i];
			dfs(i, lev+1, level, path);
		}
	}
}
