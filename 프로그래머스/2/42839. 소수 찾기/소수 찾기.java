import java.util.*;
class Solution {
    static char[] path;
    static boolean[] visit;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        for(int i=1;i<=numbers.length();i++){
            path = new char[i];
            visit = new boolean[numbers.length()];
            dfs(0, i, numbers);
        }
        for(Integer inte: set){
            if(inte == 0 || inte == 1) continue;
            else{
                // System.out.println(inte+" "+isPrime(inte));
                if(isPrime(inte)) answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int lev, int level, String numbers){
        if(lev == level){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<level;i++){
                sb.append(path[i]);
            }
            int number = Integer.parseInt(sb.toString());
            set.add(number);
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(!visit[i]){
                visit[i] = true;
                path[lev] = numbers.charAt(i);
                dfs(lev+1, level, numbers);
                visit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number){
        boolean[] visited = new boolean[number + 1];
        for(int i=0;i<number+1;i++){
            visited[i] = true;
        }
        visited[0] = false;
        visited[1] = false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(visited[i]){
                for(int j=i*i;j<=number;j+=i){
                    visited[j] = false;
                }
            }
        }
        // for(int i=0;i<visited.length;i++){
        //     System.out.print(visited[i]+" ");
        // }
        return visited[number];
    }
}