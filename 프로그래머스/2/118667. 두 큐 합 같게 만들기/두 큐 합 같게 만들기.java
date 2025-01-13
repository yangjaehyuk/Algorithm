import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        boolean flag = false;
        if(sum % 2 != 0) return -1;
        for(int i=0;i<queue1.length;i++){
            sum += queue1[i];
            sum1 += queue1[i];
            q1.add(queue1[i]);
        }
        for(int i=0;i<queue2.length;i++){
            sum += queue2[i];
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        long cri = sum / 2;
        for(int i=0;i<queue1.length * 10;i++){
            if(sum1 == cri && sum2 == cri) {
                flag = true;
                break;
            }
            if(sum2 > cri){
                int top = q2.poll();
                sum2 -= top;
                sum1 += top;
                q1.add(top);
                answer++;
            }
            else{
                int top = q1.poll();
                sum1 -= top;
                sum2 += top;
                q2.add(top);
                answer++;
            }
        }
        if(flag) return answer;
        else return -1;
    }
}