
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] path = new int[n];
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		dfs(0,0,m,path);
		System.out.print(sb.toString());
	}
	
	public static void dfs(int cri, int lev, int level, int[] path) {
		if(lev == level) {
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
