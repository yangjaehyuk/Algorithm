import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        boolean flag = false;
        while(true){
            if(pq.peek() >= K) {
                flag = true;
                break;
            }
            if(pq.size() < 2) break;
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (2 * second);
            pq.add(newScoville);
            answer++;
        }
        if(flag) return answer;
        else return -1;
    }
}