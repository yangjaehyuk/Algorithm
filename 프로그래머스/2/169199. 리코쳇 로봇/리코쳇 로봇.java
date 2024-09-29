import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String[] board) {
        int answer = 0;
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
        int[][] graph = new int[board.length][board[0].length()];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                graph[i][j] = 123456789;
            }
        }
        graph[startx][starty] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startx, starty));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int j=0;j<4;j++){
                int nx = x;
                int ny = y;
                while(true){
                    if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length() && board[nx].charAt(ny) != 'D'){
                        nx += dx[j];
                        ny += dy[j];
                    }
                    else{
                        nx -= dx[j];
                        ny -= dy[j];
                        break;
                    }
                }
                if (graph[x][y] + 1 < graph[nx][ny]) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
                
            }
        }
        if(graph[endx][endy] == 123456789) answer= -1;
        else answer = graph[endx][endy];
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