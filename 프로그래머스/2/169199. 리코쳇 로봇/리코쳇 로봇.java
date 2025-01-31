import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public int solution(String[] board) {
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        visited = new boolean[board.length][board[0].length()];
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j) == 'R'){
                    startx = i;
                    starty = j;
                }
                else if(board[i].charAt(j) == 'G'){
                    endx = i;
                    endy = j;
                }
            }
        }
        q.add(new Pair(startx, starty, 0));
        visited[startx][starty] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            if(x == endx && y == endy) {
                answer = cnt;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;
                while(true){
                    nx+=dx[i];
                    ny+=dy[i];
                    if(nx<0||ny<0||nx>=board.length||ny>=board[0].length()||board[nx].charAt(ny) == 'D'){
                        nx -= dx[i];
                        ny-=dy[i];
                        break;
                    }
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, cnt+1));
                }
                
            }
        }
        if(!visited[endx][endy]) answer = -1;
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