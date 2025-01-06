import java.util.*;
class Solution {
    static char[] path;
    static boolean[] visited;
    static char[] arr = {'+', '-'};
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        path = new char[numbers.length];
        visited = new boolean[numbers.length];
        dfs(0, numbers.length, target, numbers);
        return answer;
    }
    public static void dfs(int lev, int level, int target, int[] numbers){
        if(lev == level){
            int sum = 0;
            for(int i=0;i<lev;i++){
                if(path[i]=='+'){
                    sum+=numbers[i];
                }
                else sum-=numbers[i];
            }
            if(target == sum) answer++;
            return;
        }
        for(int i=0;i<2;i++){
            path[lev] = arr[i];
            dfs(lev+1, level, target, numbers);
        }
    }
}