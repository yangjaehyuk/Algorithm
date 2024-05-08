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
		arr = new int[n];
		int[] path = new int[n];

		String[] docs = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(docs[i]);
		}
		Arrays.sort(arr);
		dfs(0,m,path);
		System.out.print(sb.toString());
	}
	
	public static void dfs(int lev, int level, int[] path) {
		if(lev==level) {
			for(int i=0;i<lev;i++) {
				sb.append(path[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int recent = 0;
		for(int i=0;i<arr.length;i++) {
			if(recent != arr[i]) {
				path[lev] = arr[i];
				recent = path[lev];
				dfs(lev+1, level, path);	
			}
		}
	}

}
