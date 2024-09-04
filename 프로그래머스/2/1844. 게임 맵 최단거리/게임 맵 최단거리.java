import java.util.*;
class Solution {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        Queue<Pair> q = new LinkedList();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int curx = p.x;
            int cury = p.y;
            if(curx == n-1 && cury == m-1) break;
            for(int k=0;k<4;k++){
                int nx = curx + dx[k];
                int ny = cury + dy[k];
                if(nx >= 0 && nx < n && ny >=0 && ny < m && !visited[nx][ny] && maps[nx][ny] != 0){
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[curx][cury] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        
        if(!visited[n-1][m-1]) return -1;
        else return maps[n-1][m-1];
        
    }
    
    public static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}