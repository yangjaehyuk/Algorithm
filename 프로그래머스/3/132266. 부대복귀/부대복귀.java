import java.util.*;
class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] map;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        map = new int[n + 1];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int x = roads[i][0];
            int y = roads[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        visited = new boolean[n + 1];
        bfs(destination, n);
        int idx = 0;
        // for(int i=0;i<map.length;i++){
        //     System.out.println(map[i]+" "+i);
        // }
        for(int i=0;i<sources.length;i++){
            answer[idx++] = map[sources[i]];
        }
        return answer;
    }
    
    public static void bfs(int start, int len){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        Arrays.fill(map, -1);
        map[start] = 0;
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next: list.get(now)){
                if (!visited[next]) {
                    visited[next] = true;
                    map[next] = map[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}