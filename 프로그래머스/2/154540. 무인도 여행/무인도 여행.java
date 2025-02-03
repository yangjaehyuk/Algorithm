import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        int[] answer = {};
        char[][] arr = new char[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(!visited[i][j] && arr[i][j] != 'X'){
                    int tmp = 0;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));
                    tmp += arr[i][j] - '0';
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int x = p.x;
                        int y = p.y;
                        for(int k=0;k<4;k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length() && arr[nx][ny] != 'X' && !visited[nx][ny]){
                                tmp += arr[nx][ny] - '0';
                                q.add(new Pair(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    list.add(tmp);
                }
            }
        }
        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
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