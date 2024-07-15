
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    static int[] dx = {0, 0,1,-1};
    static int[] dy = {1 , -1,0,0};
    static int[][] arr;
    static boolean[][] visited;
    static int[][] map;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] docs = br.readLine().split(" ");
        n = Integer.parseInt(docs[0]);
        m = Integer.parseInt(docs[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        map = new int[n][m];
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
                if(arr[i][j] == 2){
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    map[i][j] = -   1;
                }
            }
        }
        bw.flush();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int thisx = p.x;
            int thisy = p.y;
            for(int i=0;i<4;i++){
                int nx = thisx + dx[i];
                int ny = thisy + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == 1){
                    map[nx][ny] = map[thisx][thisy] + 1;
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
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
}
