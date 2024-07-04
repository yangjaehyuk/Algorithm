import java.util.*;
class Solution {
    static int[][] ans;
    static int m;
    static int n;
    static int startx;
    static int starty;
    static int finalx;
    static int finaly;
    static char[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String[] board) {
        int answer = 0;
        m = board.length;
        n = board[0].length();
        arr = new char[m][n];
        ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = board[i].charAt(j);
                ans[i][j] = 123456789;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 'R'){
                    startx = i;
                    starty = j;
                }
                
                else if(arr[i][j] == 'G'){
                    finalx = i;
                    finaly = j;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startx, starty));
        ans[startx][starty] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                while(true){
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] != 'D'){
                        nx += dx[i];
                        ny += dy[i];
                    }
                    else{
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if(ans[nx][ny] > ans[x][y] + 1){
                    ans[nx][ny] = ans[x][y] + 1;
                    q.add(new Pair(nx, ny));    
                }
            }
            
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(ans[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        if(ans[finalx][finaly] == 123456789) return -1;
        else return ans[finalx][finaly];
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