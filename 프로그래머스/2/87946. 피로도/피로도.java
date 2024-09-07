import java.util.*;
class Solution {
    static int[] path;
    static boolean[] visited;
    static int[] arr;
    static int answer = 0;
    static int maxi = 0;
    public int solution(int k, int[][] dungeons) {
        arr = new int[dungeons.length];
        path = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        for(int i=0;i<dungeons.length;i++){
            arr[i] = i;
        }
        dfs(k, 0, dungeons.length, dungeons);
        return answer;
    }
    static void dfs(int k, int lev, int level, int[][] dungeons){
        if(lev == level){
            int tmp = k;
            for(int j=0;j<lev;j++){
                if(tmp >= dungeons[path[j]][0]){
                    tmp -= dungeons[path[j]][1];
                    maxi++;
                }
            }
            if(maxi >= answer) {
                answer = maxi;
                maxi = 0;
            }
            else maxi = 0;
            
            System.out.println();
            return;
        }
        for(int i=0;i<level;i++){
            if(!visited[i]){
                path[lev] = arr[i];
                visited[i] = true;
                dfs(k, lev+1, level, dungeons);
                visited[i] = false;
                path[lev] = 0;
            }
        }
        
    }
}