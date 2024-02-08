import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int item: ingredient){
            if(stack.empty()){
                stack.push(item);
            }
            else{
                stack.push(item);
                if(stack.size()>3 && stack.elementAt(stack.size()-1)==1 && stack.elementAt(stack.size()-2)==3 && stack.elementAt(stack.size()-3)==2 && stack.elementAt(stack.size()-4)==1){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}