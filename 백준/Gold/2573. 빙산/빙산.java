
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int year = 0;
	public static int h;
	public static int w;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static int[][] arr;
	public static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		h = Integer.parseInt(docs[0]);
		w = Integer.parseInt(docs[1]);
		arr = new int[h][w];
		for(int i=0;i<h;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<w;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		while(true) {
			if(checking() == false) {
				int cnt = bfs();
				if(cnt>1) {
					System.out.println(year);
					break;
				}
				cleaning();
//				for(int i=0;i<h;i++) {
//					for(int j=0;j<w;j++) {
//						System.out.print(arr[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				year++;
			}
			else {
				System.out.println(0);
				break;
			}
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
	
	public static boolean checking() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void cleaning() {
		visited = new boolean[h][w];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]>0) {
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && ny>=0 && nx<h && ny<w && arr[nx][ny]==0 && !visited[nx][ny]) {
							if(arr[i][j]>0) {
								arr[i][j] -= 1;
								if(arr[i][j]==0) {
									visited[i][j] = true;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static int bfs(){
		int cnt = 0;
		visited = new boolean[h][w];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]>0 && !visited[i][j]) {
					cnt++;
					q.add(new Pair(i,j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int px = p.x;
						int py = p.y;
						for(int k=0;k<4;k++) {
							int npx = px+dx[k];
							int npy = py+dy[k];
							if(npx>=0 && npy>=0 && npx<h && npy<w && arr[npx][npy]>0 && !visited[npx][npy]) {
								visited[npx][npy] = true;
								q.add(new Pair(npx, npy));
							}
						}
					}
				}
			}
		}
		return cnt;
		
	}

}
