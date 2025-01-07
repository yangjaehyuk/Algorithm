import java.util.*;
class Solution {
    static char[] arr = {'A','E','I','O','U'};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs(0,5,"",word);
        return list.indexOf(word);
    }
    
    public static void dfs(int lev, int level, String tmp, String target){
        list.add(tmp);
        if(lev == level){
            return;
        }
        
        for(int i=0;i<5;i++){
            dfs(lev+1, level, tmp+arr[i], target);
        }
        
        
        
    }
}