

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split("");
			for(int j=0;j<tmp.length;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.print('(');
		dfs(0, 0, n);	
		
	}
	
	public static void dfs(int x, int y, int len) {
		if(check(x,y,len)) {
			if(arr[x][y] == 1) {
				
				System.out.print(1);
			}
			else {
				System.out.print(0);
			}
			return;
		}
		
		len/=2;
		System.out.print('(');
		dfs(x, y,len);
		dfs(x,y+len,len);
		dfs(x+len,y,len);
		dfs(x+len,y+len,len);
		System.out.print(')');
		
		
		
	}
	
	public static boolean check(int x, int y, int len) {
		int num = arr[x][y];
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(arr[i][j]!=num) return false;
			}
		}
		return true;
	}
}
