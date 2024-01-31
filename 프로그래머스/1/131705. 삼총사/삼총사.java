import java.util.*;
class Solution {
    int res=0;
    public int solution(int[] number) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<number.length;i++){
            list.add(number[i]);
        }
        int[] path = new int[3];
        boolean[] visited = new boolean[list.size()];
        dfs(0, list, path, visited, 0);
        return res;
    }
    public void dfs(int lev, List<Integer> list, int[] path, boolean[] visited, int cri){
        int sum=0;
        if(lev==3){
            for(int i=0;i<lev;i++){
                sum+=path[i];
            }
            if(sum==0){
                 res++;
            }
            return;
        }
        for(int i=cri;i<list.size();i++){
            if(visited[i]==false){
                visited[i]=true;
                path[lev]=list.get(i);
                dfs(lev+1, list, path, visited, i+1);
                visited[i]=false;
            }
        }
    }
}