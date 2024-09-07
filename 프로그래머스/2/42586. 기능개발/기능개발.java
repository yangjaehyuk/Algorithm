import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<speeds.length;i++){
            int now = progresses[i];
            int speed = speeds[i];
            if(stack.isEmpty()){
                int tmp = 0;
                while(true){
                    if(now >= 100) break;
                    now+=speed;
                    tmp++;
                }
                stack.add(tmp);
            }
            else{
                int cri = stack.peek();
                int tmp = 0;
                while(true){
                    if(now >= 100) break;
                    now+=speed;
                    tmp++;
                }
                    
                if(cri >= tmp){
                    stack.add(cri);
                }
                else{
                    stack.add(tmp);
                }
            }
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Set<Integer> set = new HashSet(list);
        List<Integer> li = new ArrayList(set);
        Collections.sort(list);
        Collections.sort(li);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<li.size();i++){
            int cnt = 0;
            for(int j=0;j<list.size();j++){
                if(li.get(i) == list.get(j)) {
                    cnt++;
                    if(j==list.size()-1){
                        ans.add(cnt);
                    }
                }
                else{
                    if(cnt==0) continue;
                    else{
                        ans.add(cnt);
                        cnt=0;
                    }
                }
            }
           
        }
        answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}