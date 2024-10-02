import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static char[][] arr;
    public static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        h = Integer.parseInt(tmp[0]);
        w = Integer.parseInt(tmp[1]);
        arr = new char[h][w];
        visited = new boolean[h][w];
       
         for(int i=0;i<h;i++) {
			String docs = br.readLine();
			for(int j=0;j<w;j++) {
				arr[i][j] = docs.charAt(j);
			}
		}
        int res = bfs();
        if(res == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(res + 1);
        
    }
    
   public static int bfs() {
		Queue<Pair> personQ = new LinkedList<Pair>();
		Queue<Pair> fireQ = new LinkedList<Pair>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]=='F') {
					fireQ.add(new Pair(i,j,0));
					visited[i][j] = true;
				}
				else if(arr[i][j]=='J') {
					personQ.add(new Pair(i,j,0));
					visited[i][j] = true;
				}
			}
		}
		while(!personQ.isEmpty()) {
			int fireSize = fireQ.size();
			int personSize = personQ.size();
			for(int j=0;j<fireSize;j++) {
				Pair pair = fireQ.poll();
				int fx = pair.x;
				int fy = pair.y;
				for(int k=0;k<4;k++) {
					int nfx = fx+dx[k];
					int nfy = fy+dy[k];
					if(nfx>=0 && nfy>=0 && nfx<h && nfy<w && arr[nfx][nfy]=='.') {
						arr[nfx][nfy] = 'F';
						visited[nfx][nfy] = true;
						fireQ.add(new Pair(nfx, nfy, 0));
					}
				}
			}
			for(int k=0;k<personSize;k++) {
				Pair p = personQ.poll();
				int px = p.x;
				int py = p.y;
				if(px==0 || px==h-1 || py==0 || py==w-1) {
					return p.cnt;
				}
				for(int j=0;j<4;j++) {
					int npx = px+dx[j];
					int npy = py+dy[j];
					if(npx>=0 && npy>=0 && npx<h && npy<w && !visited[npx][npy] && arr[npx][npy]=='.') {
						visited[npx][npy] = true;
						personQ.add(new Pair(npx, npy, p.cnt+1));
					}
				}
			}
		}
		
		return -1;
		
	}
    
    
    public static class Pair{
        int x;
        int y;
        int cnt;
        
        Pair(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
}
