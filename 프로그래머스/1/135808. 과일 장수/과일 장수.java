import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int num: score){
            list.add(num);
        }
        int idx=0;
        Collections.sort(list, Collections.reverseOrder());
        while(list.size()>=idx+m){
            int mini = 999;
            for(int i=idx;i<m+idx;i++){
                if(mini>list.get(i)) mini=list.get(i);
            }
            answer+=mini*m;
            idx+=m;
        }
        return answer;
    }
}