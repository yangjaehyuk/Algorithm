import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int[] path = new int[list.size()];
        boolean[] visited = new boolean[list.size()];
        dfs(0,3,path,visited,list,0);
        return answer;
    }
    
    public void dfs(int lev, int level, int[] path, boolean[] visited, List<Integer> list, int cri){
        int sum=0;
        if(lev==level){
            for(int i=0;i<level;i++){
                sum+=path[i];
            }
            if(isPrime(sum)) answer++;
            return;
        }
        for(int i=cri;i<list.size();i++){
            if(!visited[i]){
                visited[i]=true;
                path[lev]=list.get(i);
                dfs(lev+1, 3, path, visited, list, i+1);
                visited[i]=false;
            }
        }
    }
    
    public boolean isPrime(int num){
        boolean[] eratos = new boolean[num+1];
        eratos[0]=false;
        eratos[1]=false;
        for(int i=2;i<=num;i++){
            eratos[i]=true;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(eratos[i]){
                for(int j=i*i;j<=num;j+=i){
                    eratos[j]=false;
                }
            }
        }
        return eratos[num];
    }
}