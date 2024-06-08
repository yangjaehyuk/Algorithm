class Solution {
    static char[] arr = {'-','+'};
    static int[] path;
    static boolean[] visited;
    static int ans = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        path = new int[numbers.length];
        visited = new boolean[numbers.length];
        dfs(0, numbers.length, target, numbers);
        answer = ans;
        return answer;
    }
    
    public static void dfs(int lev, int level, int target, int[] numbers){
        if(lev == level){
            // System.out.println(lev);
            int tmp = 0;
            for(int i=0;i<lev;i++){
                // System.out.print((char)path[i]+" "+numbers[i]);
                if((char)path[i] == '-'){
                    tmp -= numbers[i];
                }
                else{
                    tmp += numbers[i];
                }
            }
            // System.out.println(tmp);
            if(tmp == target) ans++; 
            return;
        }
        for(int i=0;i<arr.length;i++){
                // System.out.println(path[lev]);
                path[lev] = arr[i];
                dfs(lev+1, level, target, numbers);
            }
        }
}