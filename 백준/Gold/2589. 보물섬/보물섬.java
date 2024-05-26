
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int maxi = 0;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[][] arrr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int h = Integer.parseInt(docs[0]);
		int w = Integer.parseInt(docs[1]);
		arr = new char[h][w];
		for(int i=0;i<h;i++) {
			String tmp = br.readLine();
			for(int j=0;j<w;j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]=='L') bfs(h,w,i,j);
			}
		}
		System.out.println(maxi);
	}
	
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y= y;
		}
	}
	
	public static void bfs(int h, int w, int start, int end) {
		Queue<Pair> q = new LinkedList<Pair>();
		visited = new boolean[h][w];
		arrr = new int[h][w];
		q.add(new Pair(start, end));
		visited[start][end] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int px = p.x;
			int py = p.y;
			for(int k=0;k<4;k++) {
				int nx = px+dx[k];
				int ny = py+dy[k];
				if(nx>=0 && ny>=0 && nx<h && ny<w && !visited[nx][ny] && arr[nx][ny]=='L') {
					arrr[nx][ny] = arrr[px][py]+1;
					visited[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arrr[i][j]> maxi) {
					maxi = arrr[i][j];
				}
			}
		}
	}
}
