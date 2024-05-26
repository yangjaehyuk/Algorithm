
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[] dx = {1,0,-1,0,0,0};
	public static int[] dy = {0,1,0,-1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	public static int l = 0;
	public static int r = 0;
	public static int c = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] temp = br.readLine().split(" ");
			char[][][] arr;
			boolean[][][] visited;
			
			l = Integer.parseInt(temp[0]);
			r = Integer.parseInt(temp[1]);
			c = Integer.parseInt(temp[2]);
			
			if(l==0 && r==0 && c==0) break;
			arr = new char[l][r][c];
			visited = new boolean[l][r][c];
			for(int i=0;i<l;i++) {
				for(int j=0;j<r;j++) {
					String tmp = br.readLine();
					for(int k=0;k<c;k++) {
						arr[i][j][k] = tmp.charAt(k);
//						System.out.println(tmp.charAt(k));
					}
				}
				br.readLine();
			}
			
			int cnt = bfs(arr, visited);
			if(cnt==-1) {
				System.out.println("Trapped!");
			}
			else {
				System.out.println("Escaped in "+cnt+" minute(s).");
			}
		}
		
	}
	
	public static class Pair{
		int z;
		int x;
		int y;
		int cnt;
		Pair(int z, int x, int y, int cnt){
			this.z = z;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static int bfs(char[][][] arr, boolean[][][] visited) {
		Queue<Pair> q = new LinkedList<Pair>();
		int finalx = 0;
		int finaly = 0;
		int finalz = 0;
		for(int i=0;i<l;i++) {
			for(int j=0;j<r;j++) {
				for(int k=0;k<c;k++) {
					if(arr[i][j][k] == 'S') {
						q.add(new Pair(i,j,k,0));
						visited[i][j][k] = true;
					}
					else if(arr[i][j][k]=='E') {
						finalz = i;
						finalx = j;
						finaly = k;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int nopi = p.z;
			int sero = p.x;
			int garo = p.y;
//			System.out.println(nopi+" "+sero+" "+garo);
			if(nopi==finalz && sero==finalx && garo==finaly) {
				return p.cnt;
			}
			
			for(int i=0;i<6;i++) {
				int nnopi = nopi+dz[i];
				int nsero = sero+dx[i];
				int ngaro = garo+dy[i];
				
				if(nnopi>=0 && nsero>=0 && ngaro>=0 && nnopi<l && nsero<r && ngaro<c && !visited[nnopi][nsero][ngaro] && (arr[nnopi][nsero][ngaro]=='.' || arr[nnopi][nsero][ngaro] == 'E')) {
					visited[nnopi][nsero][ngaro] = true;
					q.add(new Pair(nnopi, nsero, ngaro, p.cnt+1));
				}
			}
		}
		return -1;
	}
}
