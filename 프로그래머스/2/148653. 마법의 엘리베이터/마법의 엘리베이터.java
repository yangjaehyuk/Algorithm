import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String tmp = String.valueOf(storey);
        for(int i=0;i<tmp.length();i++){
            stack.add(tmp.charAt(i) - '0');
        }
        boolean flag = false;
        while(!stack.isEmpty()){
            int x = stack.pop();
            if(flag) x+=1;
            if(x < 5){
                answer+=x;
                flag = false;
            }
            else{
                if(x == 5){
                    if(!stack.isEmpty() && stack.peek() < 5){
                        answer +=5;
                        flag = false;
                    }
                    else{
                        flag=true;
                        answer+=5;
                    }
                }
                else if(x > 9){
                    // System.out.println(len+" "+stack.size()+" "+x);
                    if(stack.size() == 0) answer++;
                    // answer += x - 10;
                    flag = true;
                }
                else{
                    if(stack.size() == 0) {
                        System.out.println(x+" "+answer);
                        if(x > 5) answer += 10 - x + 1;
                        else answer += x;
                    }
                    else{
                        
                        flag = true;
                        answer+=10-x;
                    }
                }
            }
        }
        return answer;
    }
}