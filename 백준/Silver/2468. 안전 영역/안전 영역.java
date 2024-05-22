import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int maxiCnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxi = 0;

		int[][] arr = new int[n][n];
		int[][] tempArr = new int[n][n];
		for(int j=0;j<n;j++) {
			String[] tmp = br.readLine().split(" ");
			for(int k=0;k<tmp.length;k++) {
				arr[j][k] = Integer.parseInt(tmp[k]);
//				System.out.println(tmp[k]);
				maxi = Math.max(maxi, arr[j][k]);
			}
		}
		for(int i=0;i<=maxi;i++) {
			Queue<Pair> q = new LinkedList<Pair>();
			boolean[][] visited = new boolean[n][n];
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(arr[j][k]<=i && !visited[j][k]) {
						tempArr[j][k] = 1;
						q.add(new Pair(j,k));
						visited[j][k] = true;
						while(!q.isEmpty()) {
							Pair p = q.poll();
							int x = p.x;
							int y = p.y;
							for(int l=0;l<4;l++) {
								int nx = x+dx[l];
								int ny = y+dy[l];
								if(nx>=0 && ny>=0 && ny<n && nx<n && !visited[nx][ny] && arr[nx][ny] <= i) {
									tempArr[nx][ny] = 1;
									visited[nx][ny] = true;
									q.add(new Pair(nx, ny));
								}
							}
						}
					}
				}
			}
//			for(int j=0;j<n;j++) {
//				for(int k=0;k<n;k++) {
//					System.out.print(tempArr[j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			Queue<Pair> nq = new LinkedList<Pair>();

			int tmpCnt = 0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(tempArr[j][k] == 0 && !visited[j][k]) {
						tmpCnt++;
						nq.add(new Pair(j,k));
						visited[j][k] = true;
						
						while(!nq.isEmpty()) {
							Pair p = nq.poll();
							int x = p.x;
							int y = p.y;
							for(int l=0;l<4;l++) {
								int nx = x+dx[l];
								int ny = y+dy[l];
								if(nx>=0 && ny>=0 && nx<n && ny<n && tempArr[nx][ny] == 0 && !visited[nx][ny]) {
									visited[nx][ny] = true;
									nq.add(new Pair(nx, ny));
								}
							}
						}
					}
				}
			}
			maxiCnt = Math.max(maxiCnt, tmpCnt);
		}
		System.out.println(maxiCnt);
	}
	
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
}
