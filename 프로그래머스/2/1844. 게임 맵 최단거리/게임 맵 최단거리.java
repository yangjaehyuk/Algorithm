import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        Queue<Pair> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Pair(0, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && !visited[nx][ny] && maps[nx][ny] != 0){
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        if(visited[maps.length-1][maps[0].length-1]) answer=maps[maps.length-1][maps[0].length-1];
        else answer=-1;
        return answer;
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