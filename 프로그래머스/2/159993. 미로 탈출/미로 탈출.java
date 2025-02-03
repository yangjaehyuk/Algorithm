
import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public int solution(String[] maps) {
        int answer = 0;
        char[][] arr = new char[maps.length][maps[0].length()];
        int startx = 0;
        int starty = 0;
        int lebelx = 0;
        int lebely = 0;
        int endx = 0;
        int endy = 0;
        boolean check1 = false;
        int tmp = 0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                arr[i][j] = maps[i].charAt(j);
                if(arr[i][j] == 'S'){
                    startx = i;
                    starty = j;
                }
                else if(arr[i][j] == 'L'){
                    lebelx = i;
                    lebely = j;
                }
                else if(arr[i][j] == 'E'){
                    endx = i;
                    endy = j;
                }
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startx, starty, 0));
        visited[startx][starty] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            if(arr[x][y] == 'L') {
                check1 = true;
                tmp = cnt;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length() && arr[nx][ny] != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, cnt + 1));
                }
            }
        }
        if(!check1) return -1;
        else{
            while(!q.isEmpty()) q.poll();
            q.add(new Pair(lebelx, lebely, tmp));
            visited = new boolean[maps.length][maps[0].length()];
            visited[lebelx][lebely] = true;
            while(!q.isEmpty()){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                int cnt = p.cnt;
                if(arr[x][y] == 'E') {
                    return cnt;
                }
                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length() && arr[nx][ny] != 'X' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny, cnt + 1));
                    }
                }
            }
        }
        
        if(!visited[endx][endy]) return -1;
        return answer;
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