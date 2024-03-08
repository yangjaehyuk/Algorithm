import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            int now = truck_weights[i];
            while(true){
                if(q.size() == 0){
                    q.add(now);
                    time++;
                    sum += now;
                    break;
                }
                else if(q.size() == bridge_length){
                    sum -= q.poll();
                }
                else{
                    if(sum + now > weight){
                        q.add(0);
                        time++;
                    }
                    else{
                        q.add(now);
                        time++;
                        sum += now;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}