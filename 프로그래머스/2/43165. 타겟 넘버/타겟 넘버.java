import java.util.*;
class Solution {
    static char[] arr = {'-', '+'};
    static char[] path;
    static int answer;
    public int solution(int[] numbers, int target) {
        path = new char[numbers.length];
        dfs(0, numbers.length, numbers, target);
        return answer;
    }
    
    public static void dfs(int lev, int level, int[] numbers, int target){
        if(lev == level){
            int sum = 0;
            for(int i=0;i<lev;i++){
                if(path[i] == '-'){
                    sum -= numbers[i];
                }
                else{
                    sum += numbers[i];
                }
            }
            if(sum == target) answer++;
            return;
        }
        
        for(int i=0;i<2;i++){
            path[lev] = arr[i];
            dfs(lev+1, level, numbers, target);
        }
    }
}