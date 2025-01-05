import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(!map.containsKey(clothes[i][1])) map.put(clothes[i][1], 1);
            else {
                int val = map.get(clothes[i][1]);
                map.put(clothes[i][1], val + 1);
            }
        }
        if(map.size() == 1) {
            for(String key: map.keySet()){
                answer = map.get(key);
                break;
            }
        }
        else{
            int tmp = 1;
            for(String key: map.keySet()){
                tmp *= map.get(key) + 1;
            }
            answer = tmp - 1;
        }
        return answer;
    }
}