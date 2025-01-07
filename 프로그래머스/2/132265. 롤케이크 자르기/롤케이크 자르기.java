
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> bigbro = new HashMap<>();
        Map<Integer, Integer> littlebro = new HashMap<>();
        for(int i=0;i<topping.length;i++){
            if(!bigbro.containsKey(topping[i])){
                bigbro.put(topping[i], 1);
            }
            else{
                int val = bigbro.get(topping[i]) + 1;
                bigbro.put(topping[i], val);
            }
        }
        // 동생이 하나 씩 뺏기
        for(int i=0;i<topping.length;i++){
            if(!littlebro.containsKey(topping[i])){
                littlebro.put(topping[i], 1);
            }
            else{
                int val = littlebro.get(topping[i]) + 1;
                littlebro.put(topping[i], val);
            }
            int val = bigbro.get(topping[i]) - 1;
            bigbro.put(topping[i], val);
            if(bigbro.get(topping[i]) == 0) bigbro.remove(topping[i]);
            int lenbig = bigbro.size();
            int lenlittle = littlebro.size();
            if(lenbig == lenlittle) answer++;
        }
        return answer;
    }
}