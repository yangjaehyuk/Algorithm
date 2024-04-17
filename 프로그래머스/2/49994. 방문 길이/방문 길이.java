import java.util.*;
class Solution {
    public static int[] dirx = {1,-1,0,0};
    public static int[] diry = {0,0,1,-1};
    public int solution(String dirs) {
        boolean[][][][] visited = new boolean[11][11][11][11];
        int answer = 0;
        int x = 5;
        int y = 5;
        char[] arr = dirs.toCharArray();
        for(char str: arr){
            boolean check = false;
            if(str=='U'){
                int dx = x + dirx[2];
                int dy = y + diry[2];
                if(dx>=0 && dx<11 && dy>=0 && dy<11){
                    answer+=visited[y][x][dy][dx]?0:1;
                    visited[y][x][dy][dx] = true;
                    visited[dy][dx][y][x] = true;
                    x = dx;
                    y = dy;
                }
            }
            else if(str=='L'){
                int dx = x + dirx[1];
                int dy = y + diry[1];
                if(dx>=0 && dx<11 && dy>=0 && dy<11){
                    answer+=visited[y][x][dy][dx]?0:1;
                    visited[y][x][dy][dx] = true;
                    visited[dy][dx][y][x] = true;
                    x = dx;
                    y = dy;
                }
            }
            else if(str=='D'){
                int dx = x + dirx[3];
                int dy = y + diry[3];
                if(dx>=0 && dx<11 && dy>=0 && dy<11){
                    answer+=visited[y][x][dy][dx]?0:1;
                    visited[y][x][dy][dx] = true;
                    visited[dy][dx][y][x] = true;
                    x = dx;
                    y = dy;
                }
            }
            else{
                int dx = x + dirx[0];
                int dy = y + diry[0];
                if(dx>=0 && dx<11 && dy>=0 && dy<11){
                    answer+=visited[y][x][dy][dx]?0:1;
                    visited[y][x][dy][dx] = true;
                    visited[dy][dx][y][x] = true;
                    x = dx;
                    y = dy;
                }
            }
        }
        return answer;
    }
}