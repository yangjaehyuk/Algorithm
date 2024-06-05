import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            Stack<Character> stack = new Stack<>();
            for(int j=0;j<s.length();j++){
                if(stack.isEmpty()){
                    stack.add(s.charAt((i+j)%s.length()));
                }
                else{
                    if((stack.peek()=='[' && s.charAt((i+j)%s.length()) == ']') || (stack.peek()=='{' && s.charAt((i+j)%s.length())=='}') || (stack.peek()=='(' && s.charAt((i+j)%s.length())==')')){
                        stack.pop();
                        continue;
                    }
                    else stack.add(s.charAt((i+j)%s.length()));
                }
            }
            // System.out.println(stack.isEmpty());
            if(stack.isEmpty()) answer++;
            
        }
        return answer;
    }
}