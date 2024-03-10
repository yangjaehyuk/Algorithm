import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                q.add(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int start = q.poll();
                    for(int j=0;j<n;j++){
                        if(visited[j] == false && computers[start][j] == 1){
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
                answer++;
            }
            
        }
        return answer;
    }
}