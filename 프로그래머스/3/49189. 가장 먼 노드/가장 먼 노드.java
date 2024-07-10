import java.util.*;
class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] map;
    static int maxi = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            int x = edge[i][0];
            int y = edge[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        bfs(1, n);
        for(int i=2;i<=n;i++){
            maxi = Math.max(map[i], maxi);
        }
        for(int i=2;i<=n;i++){
            if(maxi == map[i]) answer++;
        }
        return answer;
    }
    
    public static void bfs(int start, int n){
        Queue<Integer> q = new LinkedList<>();
        map = new int[n+1];
        q.add(start);
        boolean[] visited = new boolean[n + 1];
        while(!q.isEmpty()){
            int p = q.poll();
            for(int next: list.get(p)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    map[next] = map[p] + 1;
                }
            }
        }
        
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