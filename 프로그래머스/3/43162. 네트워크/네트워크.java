class Solution {
    static int[][] graph;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new int[computers.length][computers[0].length];
        visited = new boolean[computers.length];
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(computers[i][j] == 1 && computers[j][i] == 1 && i != j){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        
        
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int start){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(i==j) continue;
                if(graph[start][i] ==1 && graph[i][start]==1 && !visited[i]){
                    visited[i] = true;
                    dfs(i);
                }
            }
        }
    }
}