import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            list.add(priorities[i]);
        }
        int idx = 0;
        while(true){
            if(Collections.max(list) == 0) break;
            else{
                int max = Collections.max(list);
                if(list.get(idx) == max){
                    queue.add(idx);
                    list.set(idx, 0);
                }
                else{
                    if(idx == list.size()-1) idx = 0;
                    else idx++;
                }
            }
        }
        int index = 1;
        for(Integer item: queue){
            if(item == location){
                answer = index;
                break;
            }                
            else index ++;
        }
        return answer;
    }
}