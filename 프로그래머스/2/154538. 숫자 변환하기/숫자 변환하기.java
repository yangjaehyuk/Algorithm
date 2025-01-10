import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int x, int y, int n) {
        int answer = 0;
        visited = new boolean[1000001];
        // bfs
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int tmp = p.x;
            int cnt = p.cnt;
            if(tmp == y){
                answer = cnt;
                return answer;
            }
            if(tmp + n <= y && !visited[tmp + n]){
                q.add(new Pair(tmp + n, cnt + 1));
                visited[tmp + n] = true;
            }
            if(tmp * 2 <= y && !visited[tmp * 2]){
                q.add(new Pair(tmp * 2, cnt + 1));
                visited[tmp * 2] = true;
            }
            if(tmp * 3 <= y && !visited[tmp * 3]){
                q.add(new Pair(tmp * 3, cnt + 1));
                visited[tmp * 3] = true;
            }
        }
        return -1;
    }
    
    public static class Pair{
        int x;
        int cnt;
        Pair(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
}