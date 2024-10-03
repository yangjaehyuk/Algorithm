import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int[] dx = {1, 0, -1, 0, 0, 0};
    public static int[] dy = {0, 1, 0, -1, 0, 0};
    public static int[] dh = {0, 0, 0, 0, 1, -1};
    public static char[][][] arr;
    public static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] docs = br.readLine().split(" ");
            int m = Integer.parseInt(docs[0]);
            int n = Integer.parseInt(docs[1]);
            int l = Integer.parseInt(docs[2]);
            if(m == 0 && n == 0 && l == 0) break;
            arr = new char[m][n][l];
            int[][][] map = new int[m][n][l];
            visited = new boolean[m][n][l];
            int startx = 0;
            int starty = 0;
            int starth = 0;
            int endx = 0;
            int endy = 0;
            int endh = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    String tmp = br.readLine();
                    for(int k=0;k<tmp.length();k++){
                        arr[i][j][k] = tmp.charAt(k);
                        if(arr[i][j][k] == 'S'){
                            startx = j;
                            starth = i;
                            starty = k;
                            map[i][j][k] = 1;
                        }
                        else if(arr[i][j][k] == 'E'){
                            endx = j;
                            endh = i;
                            endy = k;
                        }
                    }
                }
				br.readLine();
            }
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(startx, starty, starth));
            visited[starth][startx][starty] = true;
            while(!q.isEmpty()){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                int h = p.h;
                
                for(int i=0;i<6;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nh = h + dh[i];
                    
                    if(nx >= 0 && ny >= 0 && nh >= 0 && nx < n && ny < l && nh < m && !visited[nh][nx][ny] && arr[nh][nx][ny] != '#'){
                        q.add(new Pair(nx, ny, nh));
                        visited[nh][nx][ny] = true;
                        map[nh][nx][ny] = map[h][x][y] + 1;
                    }
                }
            }
            
            if(!visited[endh][endx][endy]) System.out.println("Trapped!");
            else System.out.println("Escaped in "+(map[endh][endx][endy] - 1)+" minute(s).");
        }
        
    }
    
    public static class Pair{
        int x;
        int y;
        int h;
        Pair(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
