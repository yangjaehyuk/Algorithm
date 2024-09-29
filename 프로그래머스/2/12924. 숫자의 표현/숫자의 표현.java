import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int divn = n/2 + 1;
        for(int i=1;i<divn;i++){
            int sum = i;
            for(int j=i+1;j<=divn;j++){
                sum += j;
                if(sum == n) answer++;
                else if(sum > n) break;
            }
        }
        return answer + 1;
    }
}