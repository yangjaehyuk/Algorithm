import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int tmp = sequence[0];
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<sequence.length;i++){
            if(sequence[i] == k) {
                answer[0] = i;
                answer[1] = i;
                return answer;
            }
        }
        while(right < sequence.length){
            if(tmp == k) {
                int diff = right - left;
                if(mini == diff){
                    if(left < answer[0]){
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                else if(mini > diff){
                    answer[0] = left;
                    answer[1] = right;
                    mini = diff;
                }
                tmp -= sequence[left];
                left++;
            }
            else{
                if(tmp < k){
                    right++;
                    if (right < sequence.length) {
                        tmp += sequence[right];
                    }
                }
                else {
                    tmp-=sequence[left];
                    left++;
                }
            }
        }
        return answer;
    }
}