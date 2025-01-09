import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1;i<=order.length;i++){
            dq.add(i);
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(true){
            if(!dq.isEmpty()) {
                int dqpoll = dq.pollFirst();
                stack.add(dqpoll);
            }
            if(stack.peek() > order[idx]) dq.addFirst(stack.pop());
            if(stack.peek() == order[idx]){
                idx++;
                if (idx >= order.length) {
                    return list.size() + 1;
                }
                stack.pop();
                list.add(order[idx]);
            }
            else{
                if(stack.peek() > order[idx]) break;
            }
        }
        answer = list.size();
        return answer;
    }
}