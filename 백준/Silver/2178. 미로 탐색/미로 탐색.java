
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,1,-1,0};
	public static int[][] arr;
	public static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int n = Integer.parseInt(docs[0]);
		int m = Integer.parseInt(docs[1]);
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<tmp.length();j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && ny>=0 && nx<n  && ny<m && !visited[nx][ny] && arr[nx][ny]>0) {
					arr[nx][ny] = arr[x][y]+1;
					visited[nx][ny] = true;
					q.add(new Pair(nx,ny));
				}
			}
		}
		System.out.println(arr[n-1][m-1]);
		
	}
	
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
