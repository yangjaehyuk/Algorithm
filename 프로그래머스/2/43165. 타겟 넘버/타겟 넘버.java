import java.util.*;
class Solution {
    static int[] calc = {-1, 1};
    static int[] path = new int[21];
    static int ans = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(0, numbers.length, target, numbers);
        answer = ans;
        return answer;
    }
    public void dfs(int lev, int level, int target, int[] numbers){
        int sum = 0;
        if(lev == level){
            for(int i=0;i<lev;i++){
                sum += path[i] * numbers[i];
            }
            if(sum == target) ans++;
            return;
        }
        for(int i=0;i<2;i++){
            path[lev] = calc[i];
            dfs(lev+1, level, target, numbers);
        }
    }
}