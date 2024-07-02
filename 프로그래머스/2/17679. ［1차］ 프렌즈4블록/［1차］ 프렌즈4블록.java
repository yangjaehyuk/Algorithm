import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int[] dx = {1,0,1,0};
        int[] dy = {0,1,1,0};
        int answer = 0;
        char[][] arr = new char[m][n];
        int step = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        while(true){
            step++;
            if(step==300) break;
            boolean[][] visited = new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    boolean flag = true;
                    int cnt = 0;
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx >=0 && nx < m && ny>=0 && ny<n){
                            if(arr[i][j] != arr[nx][ny] || arr[i][j] == ' '){
                                flag = false;
                                break;
                            }
                            else cnt++;
                        }
                    }
                    if(flag && cnt == 4){
                        for(int l=0;l<4;l++){
                            int nx = i+dx[l];
                            int ny = j+dy[l];
                            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j] == true){
                        answer++;
                        arr[i][j] = ' ';
                    }
                }
            }
            for(int i=m-1;i>=0;i--){
                for(int j=0;j<n;j++){
                    if(arr[i][j] == ' '){
                        for(int k=i-1;k>=0;k--){
                            if (arr[k][j] != ' ') {
                                    arr[i][j] = arr[k][j];
                                    arr[k][j] = ' ';
                                    break;
                            }
                        }
                    }
                }
            }
        }
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(arr[i][j]+" ");
//             }
//             System.out.println();
//         }
        return answer;
    }
}