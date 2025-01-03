import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        answer = new int[2];
        int idx = 1;
        boolean flag = true;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<words.length;i++){
            if(stack.isEmpty()) {
                stack.add(words[i]);
                idx++;
            }
            else{
                String now = stack.peek();
                char last = now.charAt(now.length() - 1);
                if(last == words[i].charAt(0)){
                    if(stack.contains(words[i])) {
                        flag = false;
                        break;
                    }
                    else{
                        stack.add(words[i]);
                        idx++;
                    }
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        if(flag) return answer;
        else{
            // 순서
            if(idx % n == 0) answer[0] = n;
            else answer[0] = idx % n;
            // 몇 번째
            if(idx % n == 0){
                answer[1] = idx / n;
            }
            else{
                answer[1] = idx / n + 1;
            }
        }
        return answer;
    }
}