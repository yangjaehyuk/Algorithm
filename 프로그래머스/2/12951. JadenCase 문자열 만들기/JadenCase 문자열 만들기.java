import java.util.*;
class Solution {
    public String solution(String s) {
        String lowerS = s.toLowerCase();
        String answer = "";
        Stack<Character> stack = new Stack();
        for(int j=0;j<s.length();j++){
            if(lowerS.charAt(j) != ' '){
                if(stack.isEmpty()){
                    stack.add(Character.toUpperCase(lowerS.charAt(j)));
                    answer+=stack.peek();
                }
                else answer+=lowerS.charAt(j);
            }
            else{
                while(true){
                    if(stack.isEmpty()) break;
                    stack.pop();
                }
                answer+=' ';
            }
        }
        return answer;
    }
}