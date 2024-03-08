import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<prices.length-1;i++){
            Stack<Integer> stack = new Stack<>();
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] <= prices[j]){
                    stack.add(prices[j]);
                }
                else{
                    stack.add(prices[j]);
                    break;
                }
            }
            if(stack.size() == 0) ans.add(1);
            else ans.add(stack.size());
        }
        ans.add(0);
        for(int i=0;i<prices.length;i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}