class Solution {
    static int num1 = 0;
    static int num0 = 0;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int m = arr.length;
        dfs(0, 0, m, arr);
        answer[0] = num0;
        answer[1] = num1;
        return answer;
    }
    
    public static void dfs(int x, int y, int len, int[][] arr){
        if(check(x, y, len, arr)){
            if(arr[x][y] == 1) num1++;
            else num0++;
            return;
        }
        len/=2;
        dfs(x, y, len, arr);
        dfs(x, y+len, len, arr);
        dfs(x+len, y, len, arr);
        dfs(x+len, y+len, len, arr);
        
    }
    
    public static boolean check(int x, int y, int len, int[][] arr){
        int cri = arr[x][y];
        for(int i=x;i<x+len;i++){
            for(int j=y;j<y+len;j++){
                if(cri != arr[i][j]) return false;
            }
        }
        return true;
    }
    
}