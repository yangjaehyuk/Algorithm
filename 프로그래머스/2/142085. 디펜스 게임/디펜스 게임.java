import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(k > len) return len;
        else{
            for(int i=0;i<len;i++){
                pq.add(enemy[i]);
                n -= enemy[i];
                
                if(n >= 0) answer++;
                else{
                    if(k > 0){
                        n += pq.poll();
                        k--;
                        answer++;
                    }
                    else break;
                }
            }
        }
        
        return answer;
    }
}