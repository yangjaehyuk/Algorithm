import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            boolean flag = false;
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] > prices[j]) {
                    answer[i] = j - i;
                    flag = true;
                    break;
                }
            }
            if(!flag) answer[i] = prices.length - i - 1;
        }
        return answer;
    }
}