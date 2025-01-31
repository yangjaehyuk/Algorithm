import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        for(int i=0;i<weights.length;i++){
            if(!map.containsKey(weights[i]*1.0)) map.put(weights[i]*1.0, 1);
            else{
                int val = map.get(weights[i]*1.0);
                map.put(weights[i]*1.0, val+1);
            }
        }
        for(Double key: map.keySet()){
            if(map.get(key) > 1) answer += (long) map.get(key) * ((long) map.get(key) - 1) / 2;
        }
        for(int i=0;i<weights.length;i++){
            int now = weights[i];
            // 1 1/2 2/3 3/4
            if(map.containsKey(now*1.0/2)) answer+=map.get(now*1.0/2);
            if(map.containsKey(now*2.0/3)) answer+=map.get(now*2.0/3);
            if(map.containsKey(now*3.0/4)) answer+=map.get(now*3.0/4);
        }
        
        return answer;
    }
}