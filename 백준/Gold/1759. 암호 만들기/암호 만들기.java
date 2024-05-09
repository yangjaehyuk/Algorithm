

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	// 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
	// 알파벳이 암호에서 증가하는 순서로 배열
	// bac는 안됨
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static int[] aeiou = {97, 101, 105, 111, 117};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		String[] docs = br.readLine().split(" ");
		arr = new int[m];
		int[] path = new int[m];
		boolean[] visited = new boolean[m];
		for(int i=0;i<m;i++) {
			arr[i] = docs[i].charAt(0);
		}
		Arrays.sort(arr);
		dfs(0,0,n,path,visited);
		System.out.print(sb.toString());
	}
	
	public static void dfs(int cri,int lev, int level, int[] path, boolean[] visited) {
		int cnt1 = 0;
		int cnt2 = 0;
		if(lev == level) {
			for(int i=0;i<lev;i++) {
				boolean flag = true;
				for(int j=0;j<aeiou.length;j++) {
					if(aeiou[j] == path[i]) {
						cnt1++;
						flag = false;
						break;
					}
				}
				if(flag) cnt2++;
			}
			// 검사 통과하면 append
			if(cnt1 >= 1 && cnt2 >= 2){
				for(int i=0;i<lev;i++) {
					sb.append((char)(path[i]));
				}
				sb.append("\n");
			}
			
			return;
		}
		
		int recent = 0;
		
		for(int i=cri;i<arr.length;i++) {
			if(!visited[i] && recent < arr[i]) {
//				
				visited[i] = true;
				path[lev] = arr[i];
				recent = path[lev];
				dfs(i+1, lev+1, level, path, visited);
				visited[i] = false;
			}
		}
	}

}
