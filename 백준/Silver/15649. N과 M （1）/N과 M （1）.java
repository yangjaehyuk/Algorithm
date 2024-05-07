
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n];
		int[] path = new int[n];
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		dfs(0,m,path,visited);
	}
	
	public static void dfs(int lev, int level, int[] path, boolean[] visited) {
		if(lev == level) {
			for(int i=0;i<lev;i++) {
				System.out.print(path[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				path[lev] = arr[i];
				dfs(lev+1, level, path, visited);
				visited[i] = false;
			}
		}
		
	}

}
