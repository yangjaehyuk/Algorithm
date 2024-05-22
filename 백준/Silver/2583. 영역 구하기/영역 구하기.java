

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static int cnt = 0;
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,1,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int m = Integer.parseInt(docs[0]);
		int n = Integer.parseInt(docs[1]);
		int k = Integer.parseInt(docs[2]);
		// 5 7 3
		int[][] arr = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<k;i++) {
			String[] temp = br.readLine().split(" ");
			int lx = Integer.parseInt(temp[0]);
			int ly = Integer.parseInt(temp[1]);
			int rx = Integer.parseInt(temp[2]);
			int ry = Integer.parseInt(temp[3]);
			for(int j=lx;j<rx;j++) {
				for(int z=ly;z<ry;z++) {
//					System.out.println(j+" "+z);
					arr[z][j] = 1;
				}
			}
		}
//			for(int j=0;j<m;j++) {
//				for(int z=0;z<n;z++) {
//					System.out.print(arr[j][z]+" ");
//				}
//				System.out.println();
//			}
			Queue<Pair> q= new LinkedList<Pair>();
			List<Integer> list = new ArrayList<Integer>();
			for(int j=0;j<m;j++) {
				for(int z=0;z<n;z++) {
					int size = 1;
					if(arr[j][z] == 0 && !visited[j][z]) {
						q.add(new Pair(j,z));
						visited[j][z] = true;
						while(!q.isEmpty()) {
							Pair p = q.poll();
							int x = p.x;
							int y = p.y;
							for(int u=0;u<4;u++) {
								int nx = x+dx[u];
								int ny = y+dy[u];
								if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny] && arr[nx][ny]==0) {
									size++;
									visited[nx][ny] = true;
									q.add(new Pair(nx,ny));
								}
							}
						}
//						System.out.println(size);
						list.add(size);
						
						cnt++;
					}
				}
			}

			System.out.println(cnt);
			Collections.sort(list);
			for(Integer item: list) {
				System.out.print(item+" ");
			}
			System.out.println();
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
