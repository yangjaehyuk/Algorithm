
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int maxi = 0;
	public static int[][] arr;
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,-1,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int n = Integer.parseInt(docs[0]);
		int m = Integer.parseInt(docs[1]);
		List<Pair> list = new ArrayList<Pair>();
		arr = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<temp.length;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 1) {
					list.add(new Pair(i,j));
				}
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		for(Pair p: list) {
			q.add(new Pair(p.x, p.y));
			visited[p.x][p.y] = true;
		}
		while(!q.isEmpty()) {
			Pair pa = q.poll();
			int x = pa.x;
			int y = pa.y;
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && ny>=0 && nx<m & ny<n && !visited[nx][ny] && arr[nx][ny] == 0) {
					arr[nx][ny] = arr[x][y]+1;
					visited[nx][ny] = true;
					q.add(new Pair(nx,ny));
				}
			}
		}
		
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				else maxi = Math.max(maxi, arr[i][j]);
			}
		}
		System.out.println(maxi-1);
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
