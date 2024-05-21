
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,1,-1,0};
	public static int numberOf = 0;
	public static int maxi = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int n = Integer.parseInt(docs[0]);
		int m = Integer.parseInt(docs[1]);
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<tmp.length;j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int temp = 0;
				if(map[i][j] == 1 && !visited[i][j]) {
					q.add(new Pair(i,j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int nx = p.x;
						int ny = p.y;
						for(int k=0;k<4;k++) {
							int nnx = nx+dx[k];
							int nny = ny+dy[k];
							if(nnx>=0 && nny>=0 && nnx<n && nny<m && map[nnx][nny] == 1 && !visited[nnx][nny]) {
								visited[nnx][nny] = true;
								q.add(new Pair(nnx,nny));
							}
						}
						temp++;
					}
					maxi = Math.max(temp, maxi);
					numberOf++;
				}
			}
		}
		System.out.println(numberOf);
		System.out.println(maxi);
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
