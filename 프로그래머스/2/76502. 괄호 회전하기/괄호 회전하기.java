import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int idx = 0;
        while(true){
            if(idx == s.length()) break;
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                sb.append(arr[(idx+i) % s.length()]);
            }
            for(int j=0;j<sb.toString().length();j++){
                if(stack.size() == 0) stack.add(sb.toString().charAt(j));
                else{
                    if(stack.peek() == '(' && sb.toString().charAt(j) == ')'){
                        stack.pop();
                    }
                    else{
                        if(stack.peek() == '{' && sb.toString().charAt(j) == '}'){
                            stack.pop();
                        }
                        else if(stack.peek() == '[' && sb.toString().charAt(j) == ']'){
                            stack.pop();
                        }
                        else{
                            stack.add(sb.toString().charAt(j));
                        }
                    }
                }
            }
            if(stack.size() == 0) answer++;
            System.out.println(stack.size());
            idx++;
        }
        return answer;
    }
}
