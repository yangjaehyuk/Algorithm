import java.util.*;
class Solution {
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int mapX;
    public static int mapY;
    public static char[][] arr;
    public static int[][] road;
    public boolean lcheck = false;
    public boolean echeck = false;
    public void bfs(int x, int y, char goal){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x,y));
        while(!q.isEmpty()){
            pair p = q.poll();
            int nowx = p.x;
            int nowy = p.y;
            for(int i=0;i<4;i++){
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];
                if(nx >=0 && nx < mapX && ny >= 0 && ny < mapY){
                    if(!visited[nx][ny] && arr[nx][ny] == goal){
                        road[nx][ny] = road[nowx][nowy] + 1;
                        visited[nx][ny] = true;
                        if(goal == 'L') lcheck = true;
                        else echeck = true;
                        return;
                    }
                    else if(!visited[nx][ny] && arr[nx][ny] != 'X'){
                        road[nx][ny] = road[nowx][nowy] + 1;
                        visited[nx][ny] = true;
                        q.add(new pair(nx, ny));
                    }
                }
            }
        }
    }
    public int solution(String[] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length()];
        mapX = maps.length;
        mapY = maps[0].length();
        arr = new char[mapX][mapY];
        road = new int[mapX][mapY];
        int sx = 0;
        int sy = 0;
        int lx = 0;
        int ly = 0;
        int fx = 0;
        int fy = 0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                arr[i][j] = maps[i].charAt(j);
                road[i][j] = 0;
                if(maps[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                }
                if(maps[i].charAt(j) == 'L'){
                    lx = i;
                    ly = j;
                }
                if(maps[i].charAt(j) == 'E'){
                    fx = i;
                    fy = j;
                }
            }
        }
        visited[sx][sy] = true;
        // 시작점 -> 레버
        bfs(sx, sy, 'L');
        if(lcheck){
            for(int k=0;k<mapX;k++){
                for(int l=0;l<mapY;l++){
                    visited[k][l] = false;
                }
            }
            bfs(lx, ly, 'E');
            if(echeck){
                answer = road[fx][fy];
            }
            else return -1;
        }
        else return -1;
        return answer;
    }
    public static class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}