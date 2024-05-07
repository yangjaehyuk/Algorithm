

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int cnt = 0;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// a번째 탑의 가장 위에 있는 원판을 b번째 탑의 가장 위로 옮김
		dfs(n,1,2,3);
		System.out.println(cnt);
		System.out.print(sb.toString());
	}
	public static void dfs(int now, int from, int tmp, int to) {
		if(now==1) {
			sb.append(from).append(" ").append(to).append("\n");
			cnt++;
		}
		else {
			dfs(now-1,from,to,tmp);
			sb.append(from).append(" ").append(to).append("\n");
			cnt++;
			dfs(now-1,tmp,from,to);
		}
		
		
	}
}
