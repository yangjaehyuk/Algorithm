
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static List<Integer> ans = new ArrayList<Integer>();
	public static int INF = 999;
	public static int maxi = 0;
	public static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int human = Integer.parseInt(br.readLine());
		arr = new int[human+1][human+1];
		
		for(int i=0;i<=human;i++) {
			for(int j=0;j<=human;j++) {
				if(i==j) {
					arr[i][j] = 0;
					continue;
				}
				else {
					arr[i][j] = 999;
				}
			}
		}
		
		while(true) {
			String[] docs = br.readLine().split(" ");
			
			int first = Integer.parseInt(docs[0]);
			int second = Integer.parseInt(docs[1]);
			
			if(first==-1 && second==-1) break;
			
			arr[first][second] = 1;
			arr[second][first] = 1;
		}
		
		floyd(human);
//		for(int i=1;i<=human;i++) {
//			for(int j=1;j<=human;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i=1;i<=human;i++) {
			int tmpM = 0;
			for(int j=1;j<=human;j++) {
				if(arr[i][j] == 0) continue;
				tmpM = Math.max(tmpM, arr[i][j]);
			}
			tmp.add(tmpM);
		}
		for(Integer i: tmp) {
			INF = Math.min(i, INF);
		}
		int idx = 1;
		for(Integer i: tmp) {
			if(i==INF) {
				ans.add(idx);
			}
			idx++;
		}
		Collections.sort(ans);
		System.out.println(INF+" "+ans.size());
		for(Integer i: ans) {
			System.out.print(i+" ");
		}
		
	}
	
	public static void floyd(int n) {
		for(int k=1;k<=n;k++) {
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
	}
}
