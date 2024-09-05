import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.add(arr[i]);
            }
            else{
                if(stack.peek() == arr[i]) continue;
                else stack.add(arr[i]);
            }
        }
        for(Integer i: stack){
            list.add(i);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}