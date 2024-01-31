import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answerr = {};
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> answer = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        int[] path = new int[2];
        boolean[] visited = new boolean[list.size()];
        dfs(0, list, path, visited, answer);
        ans.addAll(answer);
        answerr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answerr[i]=ans.get(i);
        }
        return answerr;
    }
    public void dfs(int lev, List<Integer> list, int[] path, boolean[] visited, TreeSet<Integer> answer){
        int sum=0;
        if(lev==2){
            for(int i=0;i<lev;i++){
                sum+=path[i];
            }
            answer.add(sum);
            return;
        }
        
        for(int i=0;i<list.size();i++){
            if(visited[i]==false){
                visited[i]=true;
                path[lev]=list.get(i);
                dfs(lev+1, list, path, visited, answer);
                visited[i]=false;
            }
        }
    }
}