import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answer = 0;
        if(k >= enemy.length){
            answer = enemy.length;
        }
        else{
            answer += k;
            for(int i=0;i<k;i++){
                q.offer(enemy[i]);
            }
            for(int i=k;i<enemy.length;i++){
                int num = q.peek();
                int comp = enemy[i];
                if(comp > num){
                    n -= num;
                    if(n < 0) return answer;
                    q.poll();
                    q.offer(comp);
                    answer ++;
                }
                else{
                    n -= comp;
                    if(n < 0) return answer;
                    answer++;
                }
            }
        }
        return answer;
    }
}