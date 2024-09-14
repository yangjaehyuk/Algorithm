import java.util.*;
class Solution {
    static char[] path;
    static char[] cal = {'-', '+'};
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        path = new char[numbers.length];
        dfs(0, numbers, target);
        return answer;
    }
    
    public static void dfs(int lev, int[] numbers, int target){
        int level = numbers.length;
        if(lev == level){
            int sum = 0;
            for(int i=0;i<lev;i++){
                if(path[i]=='-') sum -= numbers[i];
                else sum += numbers[i];
            }
            if(sum == target) answer++;
            return;
        }
        
        for(int i=0;i<cal.length;i++){
            path[lev] = cal[i];
            dfs(lev+1, numbers, target);
        }
    }
}