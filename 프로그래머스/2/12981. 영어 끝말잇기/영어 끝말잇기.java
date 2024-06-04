import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Stack<String> stack = new Stack<>();
        
        for(String s: words){
            if(stack.isEmpty()) stack.push(s);
            else{
                if(s.length()==1) stack.push(s);
                else{
                    if(s.charAt(0) == stack.peek().charAt(stack.peek().length()-1) && stack.search(s) == -1 && stack.peek().length()>1) {
                    stack.push(s);
                    }
                    else if(stack.peek().length()>1) {
                        // 당첨
                        // 앞글자 다른경우
                        if(s.charAt(0) != stack.peek().charAt(stack.peek().length()-1)){
                            int len = stack.size();
                            answer[0] = len%n+1;
                            answer[1] = len/n+1;
                            return answer;
                        }
                        // 스택에 있는 경우
                        if(stack.search(s)!=-1){
                            int len = stack.size();
                            answer[0] = len%n+1;
                            answer[1] = len/n+1;
                            return answer;
                        }

                    }
                }
                
            }
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}