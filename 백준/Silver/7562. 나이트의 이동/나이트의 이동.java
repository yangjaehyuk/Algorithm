
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int[] dx = {2,2,-2,-2,1,-1,1,-1};
	public static int[] dy = {1,-1,1,-1,2,2,-2,-2};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			Queue<Pair> q = new LinkedList<Pair>();
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			boolean[][] visited = new boolean[size][size];
			String[] start = br.readLine().split(" ");
			int startX = Integer.parseInt(start[0]);
			int startY = Integer.parseInt(start[1]);
//			arr[startX][startY] = 1;
			String[] end = br.readLine().split(" ");
			int endX = Integer.parseInt(end[0]);
			int endY = Integer.parseInt(end[1]);
			q.add(new Pair(startX, startY));
			visited[startX][startY] = true;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				if(x == endX && y == endY) break;
				for(int j=0;j<8;j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					if(nx>=0 && ny>=0 && nx<size && ny<size && !visited[nx][ny] && arr[nx][ny] == 0) {
						arr[nx][ny] = arr[x][y]+1;
						visited[nx][ny] = true;
						q.add(new Pair(nx,ny));
					}
				}
			}
			System.out.println(arr[endX][endY]);
		}
	}
	
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y) {
			this.x= x;
			this.y = y;
		}
	}
}
