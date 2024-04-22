import java.util.*;
class Solution {
    public static int[] dx = {1,0,1};
    public static int[] dy = {1,1,0};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        while(true){
            boolean[][] visited = new boolean[m][n];
            boolean flag = false;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length();j++){
                    int cnt = 0;
                    for(int k=0;k<3;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[i].length()){
                            if(arr[nx][ny] != ' ' && arr[nx][ny] == arr[i][j]){
                                cnt++;
                                if(cnt == 3){
                                    visited[i][j] = true;
                                    for(int l=0;l<3;l++){
                                        int nowx = i+dx[l];
                                        int nowy = j+dy[l];
                                        visited[nowx][nowy] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j]) arr[i][j] = ' ';
                }
            }
            for (int i = board.length - 1; i >= 0; i--) {
                for (int j = 0; j < board[i].length(); j++) {
                    if (arr[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (arr[k][j] != ' ') {
                                arr[i][j] = arr[k][j];
                                arr[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j] == true){
                        flag = true;
                        break;
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j]) answer++;
                }
            }
            if(flag == false) break;
        }
        return answer;
    }
}