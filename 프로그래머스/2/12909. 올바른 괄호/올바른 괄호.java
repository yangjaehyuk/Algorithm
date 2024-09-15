import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.peek() == '(' && s.charAt(i)==')'){
                    stack.pop();
                }
                else stack.push(s.charAt(i));
            }
        }
        // System.out.println(stack.size());
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}