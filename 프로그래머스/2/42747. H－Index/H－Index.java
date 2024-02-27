import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<citations.length;i++){
            list.add(citations[i]);
        }
        Collections.sort(list);
        // 3번 이상 인용된 논문이 3편, 나머진 3번 이하로 인용
        int maxi = list.get(list.size()-1);
        for(int i=maxi;i>=0;i--){
            int cnt = 0;
            for(int j=0;j<list.size();j++){
                if(list.get(j) >= i){
                    cnt++;
                }
            }
            if(cnt >= i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}