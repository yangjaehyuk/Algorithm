import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.add(arr[i]);
            }
            else{
                if(stack.peek() == arr[i]) continue;
                else stack.add(arr[i]);
            }
        }
        answer = new int[stack.size()];
        int idx = stack.size() - 1;
        while(!stack.isEmpty()){
            answer[idx] = stack.pop();
            idx--;
        }
        return answer;
    }
}