import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String tmp = "";
        for(int i=0;i<dartResult.length();i++){
            if(!Character.isDigit(dartResult.charAt(i))){
                if(tmp.length()>0){
                    stack.push(Integer.parseInt(tmp));
                    tmp = "";
                }
                if(dartResult.charAt(i)=='D'){
                    int peek = stack.pop();
                    int toPush = (int)(Math.pow(peek,2));
                    stack.push(toPush);
                }
                else if(dartResult.charAt(i)=='T'){
                    int peek = stack.pop();
                    int toPush = (int)(Math.pow(peek,3));
                    stack.push(toPush);
                }
                else if(dartResult.charAt(i)=='*'){
                    if(stack.size()>1){
                        int peek1 = stack.pop();
                        int peek2 = stack.pop();
                        stack.push(peek2*=2);
                        stack.push(peek1*=2);
                    }
                    else{
                        int peek = stack.pop();
                        stack.push(peek*=2);
                    }
                }
                else if(dartResult.charAt(i)=='#'){
                    int peek = stack.pop();
                    int toPush = peek*-1;
                    stack.push(toPush);
                }
            }
            else{
                tmp += dartResult.charAt(i);
            }
        }
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}