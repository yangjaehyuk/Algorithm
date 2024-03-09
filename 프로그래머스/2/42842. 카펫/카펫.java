import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        // br ye
        // 10 2 [4,3]
        // 8 1 [3,3]
        // 24 24 [8,6]
        // 12 3 [5,3]
        // 14 4 [6,3]
        int[] answer = new int[2];
        int plus = brown + yellow;
        for(int i=3; i<=plus; i++){
            if(plus % i == 0){
                int width = plus / i;
                if((i - 2) * (width - 2) == yellow){
                    answer[0] = i;
                    answer[1] = plus / i;
                }
            }
        }
        return answer;
    }
}