import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int day = 0;
            int progress = progresses[i];
            int speed = speeds[i];
            while(true){
                if(progress>=100){
                    break;
                }
                else{
                    progress += speed;
                    day++;
                }
            }
            list.add(day);
        }
        int tmp = 0;
        for(int i=0;i<list.size();i++){
            if(tmp == 0){
                tmp = list.get(i);
                ans.add(tmp);
            }
            else{
                if(tmp < list.get(i)){
                    tmp = list.get(i);
                    ans.add(tmp);
                }
                else ans.add(tmp);
            }
        }
        Set<Integer> set = new HashSet<>(ans);
        List<Integer> setL = new ArrayList<>(set);
        Collections.sort(setL);
        answer = new int[set.size()];
        int idx = 0;
        for(Integer it: setL){
            int tm = 0;
            for(Integer i: ans){
                if(it==i){
                    tm++;
                }
            }
            answer[idx] = tm;
            idx++;
        }
        return answer;
    }
}