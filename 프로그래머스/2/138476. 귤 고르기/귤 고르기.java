import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(map.containsKey(tangerine[i]) == false){
                map.put(tangerine[i],1);
            }
            else{
                int v = map.get(tangerine[i]);
                map.put(tangerine[i], v+1);
            }
        }
        // for(Integer i: map.keySet()){
        //     System.out.println(i+" "+map.get(i));
        // }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>(){
            
        
             @Override
            public int compare(Integer a, Integer b) {
                return map.get(b)-map.get(a);
            }
        });
        int sum = 0;
        for(Integer i: list){
            // System.out.println(map.get(i));
            sum+=map.get(i);
            answer++;
            if(sum>=k) break;
            
        }
        return answer;
    }
}