import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        arr = new int[maps.length][maps[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        visited[0][0]=true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && !visited[nx][ny] && maps[nx][ny] == 1){
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[x][y] + 1;
                }
            }
        }
        
        if(visited[maps.length-1][maps[0].length-1] == false) answer = -1;
        else answer = arr[maps.length-1][maps[0].length-1] + 1;
        return answer;
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