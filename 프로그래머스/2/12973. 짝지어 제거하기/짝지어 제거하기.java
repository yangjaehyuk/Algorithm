import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        int idx = 0;
        Stack<Character> stack = new Stack<>();
        while(true){
            if(stack.isEmpty()){
                stack.add(s.charAt(idx));
            }
            else{
                if(stack.peek() == s.charAt(idx)){
                    stack.pop();
                }
                else stack.add(s.charAt(idx));
            }
            idx++;
            if(s.length() == idx) break;
        }
        if(stack.isEmpty()) answer = 1;
        else answer = 0;
        return answer;
    }
}