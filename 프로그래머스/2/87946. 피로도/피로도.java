import java.util.*;
class Solution {
    static int maxi = 0;
    static int[] path;
    static boolean[] visited;
    static int[] arr;
    public int solution(int k, int[][] dungeons) {
        // "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다. 
        // "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, 
        // "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 
        // 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 
        // 던전을 탐험한 후에는 피로도 20이 소모됩니다.
        // k는 유저의 현재 필요도
        // 최소 필요 필요도, 소모 피로도가 담긴 2차원 배열
        int answer = -1;
        arr = new int[dungeons.length];
        for(int i=1;i<=dungeons.length;i++){
            arr[i-1] = i;
        }
        path = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        dfs(0, dungeons.length, dungeons, k);
        answer = maxi;
        return answer;
    }
    
    public static void dfs(int lev, int level, int[][] dungeons, int now){
        int cnt = 0;
        if(lev == level){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<lev;i++){
                // System.out.print(path[i]+" ");
                
                list.add(path[i]);
            }
            for(Integer i: list){
                int idx = i-1;
                if(now >= dungeons[idx][0]){
                    now -= dungeons[idx][1];
                    cnt++;
                }
                else break;
            }
            maxi = Math.max(maxi, cnt);
            // System.out.println();
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                path[lev] = arr[i];
                dfs(lev+1, level, dungeons, now);
                visited[i] = false;
                path[lev] = 0;
            }
        }
    }
}