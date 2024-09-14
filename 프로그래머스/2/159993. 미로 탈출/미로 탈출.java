import java.util.*;
class Solution {
    static boolean[][] visited;
    static char[][] arr;
    static int[][] ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int startx = 0;
        int starty = 0;
        int rebelx = 0;
        int rebely = 0;
        int endx = 0;
        int endy = 0;
        ans = new int[n][m];
        arr = new char[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S'){
                    startx = i;
                    starty = j;
                }
                else if(maps[i].charAt(j) == 'L'){
                    rebelx = i;
                    rebely = j;
                }
                else if(maps[i].charAt(j) == 'E'){
                    endx = i;
                    endy = j;
                }
            }
        }
        boolean checkRebel = false;
        boolean checkEnd = false;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startx, starty));
        visited[startx][starty] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x == rebelx && y == rebely) {
                checkRebel = true;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 'X'){
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    ans[nx][ny] = ans[x][y] + 1;
                }
            }
        }
        if(checkRebel){
            while(!q.isEmpty()) q.poll();
            q.add(new Pair(rebelx, rebely));
            boolean[][] visited2 = new boolean[n][m];
            visited2[rebelx][rebely] = true;
            while(!q.isEmpty()){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                if(x == endx && y == endy) {
                    checkEnd = true;
                    break;
                }
                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited2[nx][ny] && arr[nx][ny] != 'X'){
                        q.add(new Pair(nx, ny));
                        visited2[nx][ny] = true;
                        ans[nx][ny] = ans[x][y] + 1;
                    }
                }
            }
        }
        else return -1;
        int answer = 0;
        if(checkEnd) answer = ans[endx][endy];
        else return -1;
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