
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int maxi = -1;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[][] arr;
	public static boolean[][][] visited;
	public static int sero = 0;
	public static int garo = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		sero = Integer.parseInt(docs[0]);
		garo = Integer.parseInt(docs[1]);
		arr = new int[sero][garo];
		visited = new boolean[sero][garo][2];
		for(int i=0;i<sero;i++) {
			String temp = br.readLine();
			for(int j=0;j<garo;j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		int num = bfs();
		System.out.println(num);
		
	}
	public static int bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,1,0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int s = p.sero;
			int g = p.garo;
			int w = p.wall;
			int c = p.cnt;
			if(s==sero-1 && g==garo-1) {
				return c;
			}
			for(int i=0;i<4;i++) {
				int ns = s+dx[i];
				int ng = g+dy[i];
				if(ns>=0 && ng>=0 && ns<sero && ng<garo) {
					if(arr[ns][ng] == 1) {
						// 한 번도 부순적이 없으면 부수고 큐에 넣기
						if(w==0 && !visited[ns][ng][1]) {
							visited[ns][ng][w] = true;
							arr[ns][ng] = arr[s][g] + 1;
							q.add(new Pair(ns, ng, c+1,1));
						}
					}
					else {
						if(!visited[ns][ng][w]) {
							visited[ns][ng][w] = true;
							arr[ns][ng] = arr[s][g] + 1;
							q.add(new Pair(ns, ng, c+1, w));
						}
						
					}
				}
				
			}
		}
		return -1;
		
		
	}
	
	public static class Pair{
		int sero;
		int garo;
		int wall;
		int cnt;
		Pair(int sero, int garo, int cnt, int wall){
			this.sero = sero;
			this.garo = garo;
			this.wall = wall;
			this.cnt = cnt;
		}
		
	}
}
