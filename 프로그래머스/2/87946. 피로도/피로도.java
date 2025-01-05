import java.util.*;
class Solution {
    static int[] path;
    static boolean[] visited;
    static int maxi = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        path = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        int myhp = k;
        dfs(0, dungeons.length, dungeons, myhp);
        answer = maxi;
        return answer;
    }
    
    public static void dfs(int lev, int level, int[][] dungeons, int myhp){
        if(lev == level){
            int tmp = 0;
            for(int i=0;i<path.length;i++){
                if(dungeons[path[i]][0] <= myhp){
                    myhp -= dungeons[path[i]][1];
                    tmp++;
                }
                else break;
            }
            if(tmp >= maxi) maxi = tmp;
            return;
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]){
                visited[i] = true;
                path[lev] = i;
                dfs(lev+1, level, dungeons, myhp);
                visited[i] = false;
            }
        }
    }
}