import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int tmp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<tangerine.length;i++){
            if(map.containsKey(tangerine[i])){
                int val = map.get(tangerine[i]) + 1;
                map.put(tangerine[i], val);
            }
            else map.put(tangerine[i], 1);
        }
        for(Integer i: map.keySet()){
            list.add(map.get(i));
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int item: list){
            tmp += item;
            if(tmp < k){
                answer++;
            }
            else break;
        }
        return answer + 1;
    }
}