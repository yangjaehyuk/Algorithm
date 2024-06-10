import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        // 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
        // Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때
        // 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i: works) pq.add(i);
        // while(!pq.isEmpty()) System.out.println(pq.poll());
        while(n>0){
            pq.add(pq.poll()-1);
            n--;
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(x <= 0) continue;
            else{
                System.out.println(answer+=(int)Math.pow(x,2));
            }
        }
        return answer;
    }
    
}