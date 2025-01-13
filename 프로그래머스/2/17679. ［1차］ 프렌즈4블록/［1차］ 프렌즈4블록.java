import java.util.*;
class Solution {
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        for(int i=0;i<500;i++){
            boolean[][] visited = new boolean[m][n];
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    char now = arr[j][k];
                    if(now == ' ' || now >= 'a' && now <= 'z') continue;
                    int cnt = 0;
                    for(int l=0;l<3;l++){
                        int nx = j + dx[l];
                        int ny = k + dy[l];
                        if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == now) cnt++;
                    }
                    if(cnt == 3){
                        visited[j][k] = true;
                        visited[j+1][k] = true;
                        visited[j+1][k+1] = true;
                        visited[j][k+1] = true;
                    }
                }
            }
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    // System.out.print(visited[j][k]+" ");
                    if(visited[j][k]){
                        answer++;
                        arr[j][k] = ' ';
                    }
                }
            }
            // for(int j=0;j<m;j++){
            //     for(int k=0;k<n;k++){
            //         System.out.print(arr[j][k]+" ");
            //     }
            //     System.out.println();
            // }
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(arr[j][k] == ' '){
                        for(int l=j;l>0;l--){
                            arr[l][k] = arr[l-1][k];
                            arr[l-1][k] = ' ';
                        }
                        
                    }
                }
            }
            // System.out.println("---------------------");
            // for(int j=0;j<m;j++){
            //     for(int k=0;k<n;k++){
            //         System.out.print(arr[j][k]+" ");
            //     }
            //     System.out.println();
            // }
            
        }
        return answer;
    }
}