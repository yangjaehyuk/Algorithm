import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        for(int i=0;i<discount.length - 9;i++){
            Map<String, Integer> map1 = new HashMap<>();
            for(int j=i;j<10+i;j++){
                if(map1.get(discount[j]) == null){
                    map1.put(discount[j], 1);
                }
                else{
                    int val = map1.get(discount[j]);
                    map1.put(discount[j], val + 1);
                }
            }
            boolean flag = map.equals(map1);
            if(flag) answer++;
        }
        return answer;
    }
}