import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> stack = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(stack.size()!=k){
                stack.add(score[i]);
                Collections.sort(stack);
                answer[i]=stack.get(0);
            }
            else{
                if(score[i]<stack.get(0)){
                    answer[i]=stack.get(0);
                }
                else{
                    stack.remove(0);
                    stack.add(score[i]);
                    Collections.sort(stack);
                    answer[i]=stack.get(0);
                }
            }
        }
        return answer;
    }
}