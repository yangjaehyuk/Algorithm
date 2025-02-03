import java.util.*;
class Solution {
    static int dx[] = {1, 0, -1, 0, 2, -2, 0, 0, 1, 1, -1, -1};
    static int dy[] = {0, 1, 0, -1, 0, 0, 2, -2, -1, 1, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];
        for(int i=0;i<places.length;i++){
            char[][] arr = new char[places[i].length][places[i][0].length()];
            Queue<Pair> q = new LinkedList<>();
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    arr[j][k] = places[i][j].charAt(k);
                }
            }
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    if(arr[j][k] == 'P') q.add(new Pair(j, k));
                }
            }
            boolean flag = false;
            while(!q.isEmpty()){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                for(int l=0;l<dx.length;l++){
                    int nx = x + dx[l];
                    int ny = y + dy[l];
                    if(nx >= 0 && ny >= 0 && nx < places[i].length && ny < places[i][0].length()){
                        // 맨해튼 거리 1
                        if(l == 0 || l == 1 || l == 2 || l == 3){
                            if(arr[nx][ny] == 'P'){
                                flag = true;
                                answer[i] = 0;
                                break;
                            }
                        }
                        // 맨해튼 거리 2 -> 위 2번, 아래 2번 등
                        else if(l == 4 || l == 5 || l == 6 || l == 7){
                            if(arr[nx][ny] == 'P'){
                                if(arr[(x + nx) / 2][(y + ny) / 2] == 'O'){
                                    flag = true;
                                    answer[i] = 0;
                                    break;
                                }
                            }
                        }
                        // 맨해튼 거리 2 -> 사선
                        else{
                            if(arr[nx][ny] == 'P'){
                                if(arr[x][ny] == 'O' || arr[nx][y] == 'O'){
                                    flag = true;
                                    answer[i] = 0;
                                    break;
                                }
                            }
                            
                        }
                    }
                }
                if(flag) break;
            }
            if(flag == false) answer[i] = 1;
            
            
        }
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