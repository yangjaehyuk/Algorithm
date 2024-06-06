import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> lp = new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            lp.add(priorities[i]);
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        lp.sort(new Comparator<>(){
           public int compare(Integer i1, Integer i2){
               return i2 - i1;
           } 
        });
        int answer = 0;
        for(int i=0;i<priorities.length;i++){
            map.put(i, priorities[i]);
        }
        int step = 1;
        int idx = -1;
        for(Integer i: map.keySet()){
            idx++;
            if(map.get(i)==lp.get(0)){
                ans.add(i);
                break;
            }
        }
        // System.out.println(idx); // 시작 인덱스
        int lpIdx = 1;
        while(true){
            if(step==priorities.length) break;
            else{
                idx++;
                if(lp.get(lpIdx) == priorities[idx%priorities.length]){
                    ans.add(idx%priorities.length);
                    lpIdx++;
                    step++;
                }
            }
        }
        int check = 0;
        for(Integer i2: ans){
            check++;
            if(i2 == location){
                answer = check;
                break;
            }
        }
        return answer;
    }
}