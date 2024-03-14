import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 원하는 제품 want
        // 원하는 제품의 수량 number
        // 할인하는 제품 discount
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<discount.length-9;i++){
            for(int j=0;j<want.length;j++){
                map.put(want[j], number[j]);
            }
            for(int j=i;j<i+10;j++){
                if(map.containsKey(discount[j])){
                    if(map.get(discount[j]) == 0) map.remove(discount[j]);
                    else {
                        map.put(discount[j], map.get(discount[j])-1);
                        if(map.get(discount[j]) == 0) map.remove(discount[j]);
                    }
                }
            }
            if(map.size() == 0){
                answer++;
            }
        }
        return answer;
    }
}