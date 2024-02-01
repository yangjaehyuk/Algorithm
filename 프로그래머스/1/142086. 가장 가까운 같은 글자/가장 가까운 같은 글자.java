import java.util.*;
class Solution {
    public int[] solution(String s) {
        Stack<Character> stack = new Stack<>();
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(stack.empty()){
                answer[0]=-1;
                stack.push(arr[i]);
            }
            else{
                if(stack.search(arr[i])==-1){
                    answer[i]=-1;
                    stack.push(arr[i]);
                }
                else{
                    answer[i]=stack.search(arr[i]);
                    stack.push(arr[i]);
                }
            }
        }
        return answer;
    }
}