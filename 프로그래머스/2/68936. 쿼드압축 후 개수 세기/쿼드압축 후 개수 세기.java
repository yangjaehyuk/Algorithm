import java.util.*;
class Solution {
    static int one = 0;
    static int zero = 0;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        answer = new int[2];
        dfs(0, 0, arr.length, arr);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
    
    public static void dfs(int x, int y, int len, int[][] arr){
        if(check(x, y, len, arr)){
            if(arr[x][y] == 1) one++;
            else zero++;
            return;
        }
        len /= 2;
        dfs(x, y, len, arr);
        dfs(x+len, y, len, arr);
        dfs(x, y+len, len, arr);
        dfs(x+len, y+len, len, arr);
    }
    
    public static boolean check(int x, int y, int len, int[][] arr){
        int cri = arr[x][y];
        for(int i=x;i<x+len;i++){
            for(int j=y;j<y+len;j++){
                if(arr[i][j] != cri) return false;
            }
        }
        return true;
    }
}