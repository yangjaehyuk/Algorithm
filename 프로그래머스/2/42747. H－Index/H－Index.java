import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<citations.length;i++){
            list.add(citations[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        int tmp = 0;
        for(int i=0;i<citations.length;i++){
            if(list.get(i) <= tmp){
                break;
            }
            tmp++;
        }
        answer = tmp;
        return answer;
    }
}