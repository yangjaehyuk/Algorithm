import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int cur = 0;
        int idx = 0;
        while(true){
            if(idx == truck_weights.length) break;
            if(q.size() == bridge_length){
                cur -= q.poll();
            }
            else if(cur + truck_weights[idx] > weight){
                q.add(0);
                answer++;
            }
            else{
                q.add(truck_weights[idx]);
                cur += truck_weights[idx];
                idx++;
                answer++;
            }
            
        }
        return answer + bridge_length;
    }
}