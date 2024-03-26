import java.util.*;
class Solution {
    public static int cnt = 1;
//     public void dfs(int lev, int level, List<Integer> list, int[] path, boolean[] visited){
//         int tmp = 1;
//         if(lev == level){
//             for(int i=0;i<lev;i++){
//                 tmp *= path[i];
//             }
//             cnt += tmp;
//             return;
//         }
//         for(int i=lev;i<list.size();i++){
//             if(visited[i] == false){
//                 visited[i] = true;
//                 path[lev] = list.get(i);
//                 dfs(lev+1, level, list, path, visited);
//                 visited[i] = false;
//             }
//         }        
        
//     }
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        // int[] path = new int[31];
        // boolean[] visited = new boolean[31];
        // List<Integer> list = new ArrayList<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
            else map.put(clothes[i][1], 1);
        }
        for(Integer key: map.values()){
            // list.add(key);
            cnt *= key+1;
        }
        // for(int i=1;i<=list.size();i++){
        //     dfs(0, i, list, path, visited);
        // }
        
        return cnt - 1;
    }
}