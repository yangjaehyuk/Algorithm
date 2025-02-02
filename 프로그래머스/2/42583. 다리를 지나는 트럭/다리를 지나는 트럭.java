import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int tmp = 0;
        Queue<Integer> ing = new LinkedList<>();
        Queue<Integer> end = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            wait.add(truck_weights[i]);
        }
        while(true){
            answer++;
            if(end.size() == truck_weights.length) break;
            if(ing.size() == bridge_length){
                int x = ing.poll();
                if(x != 0) end.add(x);
                tmp -= x;
            }
            if(!wait.isEmpty() && ing.size() < bridge_length) {
                int y = wait.peek();
                if (tmp + y <= weight) {
                    tmp += y; 
                    ing.add(wait.poll()); 
                } 
                else {
                    ing.add(0); 
                }
            }
            else if (wait.isEmpty()) {
                ing.add(0);
            }
        }
        return answer - 1;
    }
}