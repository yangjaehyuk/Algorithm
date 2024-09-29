import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String criteria = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0;i<criteria.length();i++){
            if(criteria.charAt(i) == '1') cnt++;
        }
        while(true){
            n += 1;
            int cnt2 = 0;
            String cri = Integer.toBinaryString(n);
            for(int j=0;j<cri.length();j++){
                if(cri.charAt(j) == '1') cnt2++;
            }
            if(cnt == cnt2) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}