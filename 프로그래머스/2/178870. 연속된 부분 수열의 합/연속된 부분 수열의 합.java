import java.util.*;
class Solution {
    public static int right = 0;
    public static int sum = 0;
    public static int cnt = 0;
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        if(sequence[0] == k){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        for(int i=0;i<sequence.length;i++){
            while(right<sequence.length && sum < k){
                sum += sequence[right];
                right++;
            }
            if(sum == k){
                cnt++;
                int end = right-1;
                if(answer[0] == 0 && answer[1] == 0){
                    answer[0] = i;
                    answer[1] = end;
                }
                else{
                    if(end - i < answer[1] - answer[0]){
                        answer[0] = i;
                        answer[1] = end;
                    }
                }
                
            }
            sum -= sequence[i];
        }
        return answer;
    }
}