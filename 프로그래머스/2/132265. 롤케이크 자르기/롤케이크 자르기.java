import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<len;i++){
            if(map1.containsKey(topping[i])){
                int val = map1.get(topping[i]);
                map1.put(topping[i], val+1);
            }
            else{
                map1.put(topping[i], 1);
            }
        }
        for(int i=0;i<len;i++){
            int cnt = 0;
            int now = topping[i];
            if(map1.containsKey(now)){
                int val = map1.get(now);
                map1.put(now, val-1);
            }
            if(map1.get(now) <= 0){
                map1.remove(now);
            }
            if(map2.containsKey(topping[i])){
                int val = map2.get(topping[i]);
                map2.put(topping[i], val+1);
            }
            else{
                map2.put(topping[i], 1);
            }
            // System.out.println(map1.size()+" "+map2.size());
            if(map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}