import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dtwo = (long)Math.pow(d,2);
        int tmp = 0;
        for(int i=0;i<=d;i+=k){
            long xtwo = (long)Math.pow(i,2);
            long ytwo = (long)Math.sqrt(dtwo - xtwo);
            answer += ytwo / k + 1;
            
        }
        return answer;
    }
}