import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        int val = 0;
        for(int i=numbers.length-1;i>=0;i--){
            if(i == numbers.length - 1) {
                answer[i] = -1;
                stack.add(numbers[i]);
            }
            else{
                if(stack.isEmpty()){
                    answer[i] = -1;
                    stack.add(numbers[i]);
                }
                else{
                    while(!stack.isEmpty()){
                        if(numbers[i] >= stack.peek()){
                            stack.pop();
                        }
                        else break;
                    }
                    if(stack.isEmpty()) {
                        answer[i] = -1;
                        stack.add(numbers[i]);
                    } 
                    if(numbers[i] < stack.peek()){
                        answer[i] = stack.peek();
                        stack.add(numbers[i]);
                    }
                }
            }
        }
        return answer;
    }
}