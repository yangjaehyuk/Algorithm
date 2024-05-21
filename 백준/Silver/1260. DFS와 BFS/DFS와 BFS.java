
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int n;
	public static int m;
	public static int v;
	public static boolean[][] graph;
	public static boolean[] dfsV;
	public static boolean[] bfsV;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		n = Integer.parseInt(docs[0]);
		m = Integer.parseInt(docs[1]);
		v = Integer.parseInt(docs[2]);
		graph = new boolean[n+1][n+1];
		dfsV = new boolean[n+1];
		bfsV = new boolean[n+1];
		for(int i=0;i<m;i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			graph[a][b] = true;
			graph[b][a] = graph[a][b];
		}
		System.out.print(v+" ");
		dfs(v);
		System.out.println();
		bfs(v);
	}
	
	public static void dfs(int start) {
		dfsV[start] = true;
		for(int i=0;i<=n;i++) {
			if(i==start) continue;
			if(graph[start][i] & graph[i][start] && !dfsV[i]) {
				dfsV[i] = true;
				System.out.print(i+" ");
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		bfsV[start] = true;
		System.out.print(start+" ");
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0;i<=n;i++) {
				if(i==start) continue;
				if(graph[x][i] && graph[i][x] && !bfsV[i]) {
					bfsV[i] = true;
					q.add(i);
					System.out.print(i+" ");
				}
			}
		}
	}
}
