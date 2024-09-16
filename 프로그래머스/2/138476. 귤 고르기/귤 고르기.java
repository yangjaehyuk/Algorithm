import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(!map.containsKey(tangerine[i])){
                map.put(tangerine[i], 1);
            }
            else{
                int value = map.get(tangerine[i]) + 1;
                map.put(tangerine[i], value);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer item: map.keySet()){
            list.add(map.get(item));
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        int cnt = 0;
        if(list.get(0)>=k) return 1;
        else {
            for(int j=0;j<list.size();j++){
                cnt+=list.get(j);
                if(cnt<k) answer++;
                else {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}