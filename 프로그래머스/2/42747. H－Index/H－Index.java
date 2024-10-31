import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int num = citations.length;
        Arrays.sort(citations);
        for(int i=0;i<num;i++){
            int nowv = citations[i]; // 인용
            if(nowv >= num) break;
            num --;
        }
        if(citations[num - 1] == 0) return 0;
        answer = num;
        return answer;
    }
}