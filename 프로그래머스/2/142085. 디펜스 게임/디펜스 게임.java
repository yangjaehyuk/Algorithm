import java.util.*;
class Solution {
    // 병사는 n명
    // k번 무적권 가능
    // 무적권 쓰면 병사를 소모없이 라운드 치룸
    // 남은 병사 수 보다 현재 라운드의 적의 수가 더 많으면 겜 종료
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<enemy.length;i++){
            pq.offer(enemy[i]);
            if(k == 0 && n - enemy[i] < 0) break;
            if(k > 0 && n - enemy[i] < 0){
                n+=pq.poll();
                k--;
            }
            n-=enemy[i];
            answer++;
        }
        return answer;
    }
}