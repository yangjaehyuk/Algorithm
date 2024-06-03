import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else{
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                    continue;
                }
                else stack.push(s.charAt(i));
            }
            
            
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(stack.size());
        if(stack.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }
}