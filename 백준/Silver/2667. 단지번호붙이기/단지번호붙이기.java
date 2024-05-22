
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int cnt = 0;
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,1,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		boolean[][] visited= new boolean[n][n];
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<tmp.length();j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int size=1;
				if(arr[i][j]!=0 && !visited[i][j]) {
					q.add(new Pair(i,j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && arr[nx][ny]==arr[x][y]) {
								size++;
								visited[nx][ny] = true;
								q.add(new Pair(nx,ny));
							}
						}
					}
					list.add(size);
					cnt++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(Integer item: list) {
			System.out.println(item);
		}
	}
	
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
