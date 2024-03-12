import java.util.*;
class Solution {
    public static int[] path;
    public static boolean[] visited;
    public static int can = 0;
    public int solution(int k, int[][] dungeons) {
        // k는 현재 피로도
        // dungeons[0]은 최소 필요 피로도
        // dungeons[1]은 소모 피로도
        path = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        int answer = -1;
        dfs(0, dungeons.length, k, dungeons);
        answer = can;
        return answer;
    }
    public void dfs(int lev, int level, int k, int[][] dungeons){
        if(lev == level){
            int check = 0;
            for(int item: path){
                if(k >= dungeons[item][0]){
                    k-=dungeons[item][1];
                    check++;
                }
            }
            if(check > can) can = check;
            return;
        }
        for(int i=0;i<level;i++){
            if(visited[i] == false){
                path[lev] = i;
                visited[i] = true;
                dfs(lev+1, level, k, dungeons);
                visited[i] = false;
            }
        }
        
    }
}