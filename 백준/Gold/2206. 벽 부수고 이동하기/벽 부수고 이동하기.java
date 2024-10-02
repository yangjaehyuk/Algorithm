import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] arr;
    public static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        h = Integer.parseInt(docs[0]);
        w = Integer.parseInt(docs[1]);
        arr = new int[h][w];
        visited = new boolean[h][w][2];
        for(int i=0;i<h;i++){
            String tmp = br.readLine();
            for(int j=0;j<w;j++){
                arr[i][j] = tmp.charAt(j)-'0';
            }
        }
        int res = bfs();
        System.out.println(res);
        
    }
    
    
    public static int bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1, 0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            int wall = p.wall;
            
            if(x == h-1 && y == w-1) return cnt;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(arr[nx][ny] == 1){
                        if(wall == 0 && !visited[nx][ny][1]){
                            q.add(new Pair(nx, ny, cnt + 1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                    else{
                        if(!visited[nx][ny][wall]){
                             q.add(new Pair(nx, ny, cnt + 1, wall));
                             visited[nx][ny][wall] = true;
                        }
                        
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
        int wall;
        Pair(int x, int y, int cnt, int wall){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}
