import java.util.*;
class Solution {
    public static final int[] dx={0,1,-1};
    public static final int[] dy={1,0,-1};
    // 대각선 위, 아래, 오른
    public int[] solution(int n) {
        int[] answer = {};
        int tmp = 1;
        for(int i=1;i<=n;i++){
            tmp+=i;
        }
        int num = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        answer = new int[tmp-1];
        if(n==1){
            answer[0] = 1;
            return answer;
        }
        int[][] arr = new int[n][n];
        while(true){
            arr[y][x] = num++;
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx == n || ny == n || arr[ny][nx] != 0){
                d = (d+1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(arr[ny][nx] != 0 || nx == n || ny == n) break;
            }
            y = ny;
            x = nx;
        }
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] != 0){
                    answer[idx] = arr[i][j];
                    idx++;
                }
            }
        }
        return answer;
    }
}