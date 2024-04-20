import java.util.*;
class Solution {
    public Queue<pair> q = new LinkedList<>();
    public int n;
    public int m;
    public char[][] arr;
    public int[][] score;
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,1,-1};
    public int sx = 0;
    public int sy = 0;
    public int fx = 0;
    public int fy = 0;
    
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        arr = new char[n][m];
        score = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = board[i].charAt(j);
                score[i][j] = 0;
                if(board[i].charAt(j) == 'R'){
                    sx = i;
                    sy = j;
                }
                else if(board[i].charAt(j) == 'G'){
                    fx = i;
                    fy = j;
                }
            }
        }
        q.add(new pair(sx,sy));
        score[sx][sy] = 1;
        while(!q.isEmpty()){
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                while(true){
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 'D'){
                        nx += dx[i];
                        ny += dy[i];
                    }
                    else{
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if(score[nx][ny] == 0){
                    score[nx][ny] = score[x][y] + 1;
                    q.add(new pair(nx,ny));
                }
            }
        }
        
        if(score[fx][fy] == 0) answer = -1;
        else answer = score[fx][fy] - 1;
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