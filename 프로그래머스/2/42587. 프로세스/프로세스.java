import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<priorities.length;i++){
            pq.add(priorities[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<priorities.length;i++){
            map.put(i, priorities[i]);
        }
        int idx = 0;
        while(true){
            idx %= priorities.length;
            if(pq.peek() == map.get(idx)){
                if(location == idx){
                    break;
                }
                answer++;
                pq.poll();
                map.remove(idx);
            }
            idx++;
        }
        return answer + 1;
    }
}