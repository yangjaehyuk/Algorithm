import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.add(s.charAt(i));
            if(stack.size()>1){
                if(stack.peek()==')' && stack.get(stack.size()-2)=='('){
                    stack.pop();
                    stack.pop();
                }
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        if(stack.size()==0) answer=true;
        else answer=false;

        return answer;
    }
}