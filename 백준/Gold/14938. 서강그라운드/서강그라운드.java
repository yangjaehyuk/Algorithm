

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n;
	static int m;
	static int r;
	static List<Integer> itemL = new ArrayList<Integer>();
	static int[][] arr;
	static int INF = 987654321;
	static int maxi = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		n = Integer.parseInt(docs[0]);
		m = Integer.parseInt(docs[1]);
		r = Integer.parseInt(docs[2]);
		String[] items = br.readLine().split(" ");
		for(String i: items) {
			itemL.add(Integer.parseInt(i));
		}
		arr = new int[n+1][n+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==j) {
					arr[i][j] = 0;
					continue;
				}
				arr[i][j] = INF;
			}
		}
		for(int i=0;i<r;i++) {
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			int weight = Integer.parseInt(tmp[2]);
			arr[start][end] = weight;
			arr[end][start] = weight;
		}
		floyd();
		
		for(int i=1;i<=n;i++) {
			int sum = 0;
			for(int j=1;j<=n;j++) {
				if(arr[j][i] <= m ) {
					sum+=itemL.get(j-1);
				}
			}
//			System.out.println();
			maxi = Math.max(sum, maxi);
		}
		
		System.out.println(maxi);
	}
	
	public static void floyd() {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(arr[i][k] == INF) continue;
				for(int j=1;j<=n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
	}
}
