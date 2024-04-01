import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] arr = new int[y+1];
        boolean[] visited = new boolean[y+1];
        Queue<Integer> q = new LinkedList<>();
        int check = 0;
        q.add(x);
        while(!q.isEmpty()){
            int front = q.poll();
            for(int i=0;i<3;i++){
                if(i==0){
                    int change = front+n;
                    if(change>y || visited[change] == true){
                        continue;
                    }
                    visited[change] = true;
                    arr[change] = arr[front] + 1;
                    q.add(change);
                }
                else{
                    int change = front*(i+1);
                    if(change>y || visited[change] == true){
                        continue;
                    }
                    visited[change] = true;
                    arr[change] = arr[front] + 1;
                    q.add(change);
                }
            }
        }
        if(x==y) return 0;
        if(arr[y] == 0) answer = -1;
        else answer = arr[y];
        return answer;
    }
}