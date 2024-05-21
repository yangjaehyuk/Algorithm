
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int sum1 = 0;
	public static int sum2 = 0;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static char[][] arr1;
	public static char[][] arr2;
	public static boolean[][] visited1;
	public static boolean[][] visited2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr1 = new char[n][n];
		arr2 = new char[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<tmp.length();j++) {
				arr1[i][j] = tmp.charAt(j);
				if(tmp.charAt(j) == 'G') {
					arr2[i][j] = 'R';
				}
				else arr2[i][j] = tmp.charAt(j);
			}
		}
		
		Queue<Pair> q1 = new LinkedList<Pair>();
		Queue<Pair> q2 = new LinkedList<Pair>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr1[i][j]=='G' && !visited1[i][j]) {
					q1.add(new Pair(i,j));
					visited1[i][j] = true;
					while(!q1.isEmpty()) {
						Pair p1 = q1.poll();
						int x = p1.x;
						int y = p1.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n && !visited1[nx][ny] && arr1[nx][ny]=='G') {
								visited1[nx][ny] = true;
								q1.add(new Pair(nx,ny));
							}
						}
					}
					sum1++;
				}
				else if(arr1[i][j]=='R' && !visited1[i][j]) {
					q1.add(new Pair(i,j));
					visited1[i][j] = true;
					while(!q1.isEmpty()) {
						Pair p1 = q1.poll();
						int x = p1.x;
						int y = p1.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n && !visited1[nx][ny] && arr1[nx][ny]=='R') {
								visited1[nx][ny] = true;
								q1.add(new Pair(nx,ny));
							}
						}
					}
					sum1++;
					
				}
				else if(arr1[i][j]=='B' && !visited1[i][j]) {
					q1.add(new Pair(i,j));
					visited1[i][j] = true;
					while(!q1.isEmpty()) {
						Pair p1 = q1.poll();
						int x = p1.x;
						int y = p1.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n && !visited1[nx][ny] && arr1[nx][ny]=='B') {
								visited1[nx][ny] = true;
								q1.add(new Pair(nx,ny));
							}
						}
					}
					sum1++;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr2[i][j]=='R' && !visited2[i][j]) {
					q2.add(new Pair(i,j));
					visited2[i][j] = true;
					while(!q2.isEmpty()) {
						Pair p2 = q2.poll();
						int x = p2.x;
						int y = p2.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n && !visited2[nx][ny] && arr2[nx][ny]=='R') {
								visited2[nx][ny] = true;
								q2.add(new Pair(nx,ny));
							}
						}
					}
					sum2++;
				}
				
				else if(arr2[i][j]=='B' && !visited2[i][j]) {
					q2.add(new Pair(i,j));
					visited2[i][j] = true;
					while(!q2.isEmpty()) {
						Pair p2 = q2.poll();
						int x = p2.x;
						int y = p2.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n && !visited2[nx][ny] && arr2[nx][ny]=='B') {
								visited2[nx][ny] = true;
								q2.add(new Pair(nx,ny));
							}
						}
					}
					sum2++;
				}
			}
		}
		System.out.println(sum1+" "+sum2);
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
