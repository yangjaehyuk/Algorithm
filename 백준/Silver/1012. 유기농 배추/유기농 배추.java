
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,1,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			int cnt = 0;
			Queue<Pair> q = new LinkedList<Pair>();
			String[] docs = br.readLine().split(" ");
			int m = Integer.parseInt(docs[0]);
			int n = Integer.parseInt(docs[1]);
			int l = Integer.parseInt(docs[2]);
			int[][] arr = new int[n][m];
			boolean[][] visited = new boolean[n][m];
			for(int j=0;j<l;j++) {
				String[] tmp = br.readLine().split(" ");
				int x = Integer.parseInt(tmp[0]);
				int y = Integer.parseInt(tmp[1]);
				arr[y][x] = 1;
			}
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(arr[j][k]==1 && !visited[j][k]) {
						q.add(new Pair(j,k));
						visited[j][k] = true;
						while(!q.isEmpty()) {
							Pair p = q.poll();
							int x = p.x;
							int y = p.y;
							for(int z=0;z<4;z++) {
								int nx = x+dx[z];
								int ny = y+dy[z];
								if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && arr[nx][ny]==1) {
									visited[nx][ny] = true;
									q.add(new Pair(nx,ny));
								}
							}
						}
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
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
