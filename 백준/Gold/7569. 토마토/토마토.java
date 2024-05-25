
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int maxi = 0;
	public static int[] dx = {1,-1,0,0,0,0};
	public static int[] dy = {0,0,1,-1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	public static int[][][] arr;
	public static boolean[][][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Pair> l = new ArrayList<Pair>();
		String[] temp = br.readLine().split(" ");
		int m = Integer.parseInt(temp[0]);
		int n = Integer.parseInt(temp[1]);
		int h = Integer.parseInt(temp[2]);
		arr = new int[h][n][m];
		visited = new boolean[h][n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				String[] docs = br.readLine().split(" ");
				for(int k=0;k<m;k++) {
					arr[i][j][k] = Integer.parseInt(docs[k]);
//					System.out.print(i+" "+j+" "+k+" ");
				}
			}
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(arr[i][j][k]==1) {
						l.add(new Pair(i,j,k));
					}
				}
			}
		}
		
		for(Pair p: l) {
			q.add(new Pair(p.z, p.y, p.x));
			visited[p.z][p.y][p.x] = true;
			
		}
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			int nop = p.z;
			int garo = p.x;
			int sero = p.y;
//			System.out.println(nop+" "+garo+" "+sero);
				for(int j=0;j<6;j++) {
					int nnop = nop+dz[j];
					int ngaro = garo+dx[j];
					int nsero = sero+dy[j];
					if(nnop>=0 && ngaro>=0 && nsero>=0 && nnop<h && ngaro<m && nsero<n && !visited[nnop][nsero][ngaro] && arr[nnop][nsero][ngaro] == 0) {
						arr[nnop][nsero][ngaro] = arr[nop][sero][garo] + 1;
						visited[nnop][nsero][ngaro] = true;
						q.add(new Pair(nnop, nsero, ngaro));
					}
				}
			
		}
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(arr[i][j][k]==0) {
						System.out.println(-1);
						System.exit(0);
					}
					else {
						maxi = Math.max(maxi, arr[i][j][k]);
					}
				}
			}
		}
		
		System.out.println(maxi-1);
		
	}
	public static class Pair{
		int z;
		int y;
		int x;
		Pair(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}
