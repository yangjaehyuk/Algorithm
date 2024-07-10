import java.util.*;
class Solution {
    static int startx;
    static int starty;
    static int leverx;
    static int levery;
    static int endx;
    static int endy;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int[][] load;
    public int solution(String[] maps) {
        int answer = 0;
        boolean check1 = true;
        boolean check2 = true;
        map = new char[maps.length][maps[0].length()];
        load = new int[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    startx = i;
                    starty = j;
                }
                else if(map[i][j] == 'L'){
                    leverx = i;
                    levery = j;
                }
                else if(map[i][j] == 'E'){
                    endx = i;
                    endy = j;
                }
            }
        }
        bfs1(startx, starty);
        if(load[leverx][levery] == 0){
            answer = -1;
        }
        else{
            bfs2(leverx, levery);
            if(load[endx][endy] == 0) answer = -1;
            else answer = load[endx][endy];
        }
        return answer;
    }
    
    public static void bfs1(int startx, int starty){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startx, starty));
        boolean[][] visited = new boolean[map.length][map[0].length];
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            if(x == leverx && y == levery) return;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    load[nx][ny] = load[x][y] + 1;
                    
                }
            }
        }
    }
    
    public static void bfs2(int startx, int starty){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startx, starty));
        boolean[][] visited = new boolean[map.length][map[0].length];
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            if(x == endx && y == endy) return;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    load[nx][ny] = load[x][y] + 1;
                    
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