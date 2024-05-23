

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int net = Integer.parseInt(br.readLine());
		boolean[][] computer = new boolean[com][com];
		boolean[] visited = new boolean[com];
		for(int i=0;i<net;i++) {
			String[] docs = br.readLine().split(" ");
			int front = Integer.parseInt(docs[0]);
			int back = Integer.parseInt(docs[1]);
			computer[front-1][back-1] = true;
			computer[back-1][front-1] = true;
		}
		
		dfs(0, computer, visited);
		System.out.println(cnt);
	}
	public static void dfs(int start, boolean[][] computer, boolean[] visited) {
		visited[start] = true;
		for(int i=0;i<computer.length;i++) {
			for(int j=0;j<computer.length;j++) {
				if(i==j) continue;
				if(computer[start][i] ==true && computer[i][start] == true && !visited[i]) {
					cnt++;
					visited[i] = true;
					dfs(i, computer, visited);
				}
			}
		}
	}
}
