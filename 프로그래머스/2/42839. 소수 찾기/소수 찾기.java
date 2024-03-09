import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=numbers.length();i++){
            int[] path = new int[numbers.length()];
            boolean[] visited = new boolean[numbers.length()];
            dfs(numbers, 0, i, path, visited, list);
        }
        HashSet<Integer> hash = new HashSet<>(list);
        List<Integer> ans = new ArrayList<>(hash);
        for(Integer item: ans){
            boolean[] prime = new boolean[item+1];
            for(int i=0;i<item+1;i++) prime[i] = true;
            if(item == 1 || item == 0){
                continue;
            }
            else{
                for(int i=2;i<=Math.sqrt(item);i++){
                    if(prime[i] == true){
                        for(int j=i*i;j<=item;j+=i){
                            prime[j] = false;
                        }
                    }
                }
                if(prime[item]) answer++;
            }
        }
        return answer;
    }
    public void dfs(String numbers, int lev, int level, int[] path, boolean[] visited, List<Integer> list){
        
        if(lev == level){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<lev;i++){
                sb.append(path[i]);
            }
            String tmp = sb.toString();
            int tmpV = Integer.parseInt(tmp);
            list.add(tmpV);
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(visited[i] == false){
                visited[i] = true;
                path[lev] = numbers.charAt(i)-'0';
                dfs(numbers, lev+1, level, path, visited, list);
                visited[i] = false;
            }
        }
    }
}