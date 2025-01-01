import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }
            else{
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }
                else stack.add(s.charAt(i));
            }
        }
        if(stack.isEmpty()) answer = true;
        else answer = false;
        return answer;
    }
}