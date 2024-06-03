
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] graph;
	static int node;
	static int e;
	static int INF = 987654321;
	static int mini = INF;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		node = Integer.parseInt(docs[0]);
		e = Integer.parseInt(docs[1]);
		graph = new int[node+1][node+1];
		for(int i=0;i<node+1;i++) {
			for(int j=0;j<node+1;j++) {
				if(i==j) {
					graph[i][j] = 0;
					continue;
				}
				graph[i][j] = INF;
			}
		}
		for(int i=0;i<e;i++) {
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			int wei = Integer.parseInt(tmp[2]);
			graph[start][end] = wei;
		}
		floyd();
		for(int i=1;i<=node;i++) {
			for(int j=1;j<=node;j++) {
				if(graph[i][j]!=INF && graph[j][i]!=INF && i!=j) {
					mini = Math.min(graph[i][j]+graph[j][i], mini);
//					System.out.print(graph[i][j]+" "+graph[j][i]+" ");
				}
			}
//			System.out.println();
		}
		if(mini==INF) System.out.println(-1);
		else System.out.println(mini);
	}
	
	public static void floyd() {
		for(int k=1;k<=node;k++) {
			for(int i=1;i<=node;i++) {
				if(graph[i][k] == INF) continue;
				for(int j=1;j<=node;j++) {
					if(graph[i][j]>graph[i][k]+graph[k][j]) graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
	}
	
}
