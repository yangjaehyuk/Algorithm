import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static Character[] arr = {'A','E','I','O','U'};
    public int solution(String word) {
        int answer = 0;
        dfs(0,5,"",word);
        answer = list.indexOf(word);
        return answer;
    }
    
    public static void dfs(int lev, int level, String tmp, String word){
        list.add(tmp);
        if(lev==level){
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            dfs(lev+1, level, tmp+arr[i], word);
        }
    }
}