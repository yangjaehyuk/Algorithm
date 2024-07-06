import java.util.*;
class Solution {
    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: scoville) pq.add(i);
        while(true){
            if(pq.size() == 1) break;
            if(pq.peek() >= K) break;
            else{
                answer++;
                int now = pq.poll();
                int sub = pq.poll();
                pq.add(now + sub * 2);
            }
        }
        int now = pq.poll();
        if(now >= K) return answer;
        else return -1;
    }
}