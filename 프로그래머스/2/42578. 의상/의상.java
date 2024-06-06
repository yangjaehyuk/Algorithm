import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                int val = map.get(clothes[i][1]);
                map.put(clothes[i][1], val+1);
            }
            else{
                map.put(clothes[i][1], 1);
            }
            // System.out.println(map.containsKey(clothes[i][1]));
            
        }
        // System.out.println(map.size());
        if(map.size()==1){
            return map.get(clothes[0][1]);
        }
        else{
            int sum = 0;
            for(String s: map.keySet()){
                int tmp = 0;
                tmp += map.get(s)+1;
                if(sum == 0){
                    sum = tmp;
                }
                else{
                    sum *= tmp;
                }
            }
            answer = sum - 1;
        }
        return answer;
    }
}