import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(stack.empty()) stack.push(arr[i]);
            else{
                if(stack.peek()=='(' && arr[i]==')'){
                    stack.pop();
                    continue;
                }
                else stack.push(arr[i]);
            }
        }
        if(stack.size()>0) answer=false;
        return answer;
    }
}