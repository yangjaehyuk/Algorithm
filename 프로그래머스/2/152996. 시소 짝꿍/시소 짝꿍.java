import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        for(Integer i: weights){
            double num1 = (double)i*1.0/2.0;
            double num2 = (double)i*2.0/3.0;
            double num3 = (double)i*3.0/4.0;
            double num4 = (double)i*1.0/1.0;
            
            if(map.containsKey(num1)) answer+=map.get(num1);
            if(map.containsKey(num2)) answer+=map.get(num2);
            if(map.containsKey(num3)) answer+=map.get(num3);
            if(map.containsKey(num4)) answer+=map.get(num4);
            
            map.put(i*1.0, map.getOrDefault(i*1.0,0)+1);
            
            
        }
        
        return answer;
    }
}