import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            Stack<Character> stack = new Stack<>();
            for(int j=i;j<s.length()+i;j++){
                if(stack.isEmpty()) stack.add(s.charAt(j % s.length()));
                else{
                    if(stack.peek() == '[' && s.charAt(j % s.length()) == ']' || stack.peek() == '(' && s.charAt(j % s.length()) == ')' || stack.peek() == '{' && s.charAt(j % s.length()) == '}') stack.pop();
                    else stack.add(s.charAt(j % s.length()));
                }
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}