import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<progresses.length;i++){
            int temp = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) temp++;
            if(stack.isEmpty()) stack.add(temp);
            else{
                if(stack.peek() >= temp){
                    int pe = stack.peek();
                    stack.add(pe);
                }
                else stack.add(temp);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.sort(list);
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) != list.get(i+1)){
                ans.add(num);
                num = 1;
            }
            else {
                num++;
            }
        }
        ans.add(num);
        answer = new int[ans.size()];
        int idx = 0;
        for(Integer i:ans){
            answer[idx] = i;
            idx++;
        }
        return answer;
    }
}