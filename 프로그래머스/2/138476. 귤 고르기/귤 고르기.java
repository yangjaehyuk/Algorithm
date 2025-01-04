import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(map.get(tangerine[i]) == null) map.put(tangerine[i], 1);
            else{
                int val = map.get(tangerine[i]);
                map.put(tangerine[i], val + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer key: map.keySet()){
            list.add(map.get(key));
        }
        Collections.sort(list, Collections.reverseOrder());
        int tmp = 0;
        for(int i=0;i<list.size();i++){
            if(tmp < k){
                answer++;
                tmp += list.get(i);
            }
        }
        return answer;
    }
}