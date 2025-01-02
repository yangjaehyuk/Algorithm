import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        // 조건 1
        for(int i=n+1;i<1000001;i++){
            // 조건 2
            int num1 = 0;
            int nnum = 0;
            String num1B = Integer.toBinaryString(n);
            String iB = Integer.toBinaryString(i);
            for(int j=0;j<num1B.length();j++){
                if(num1B.charAt(j) == '1') num1++;
            }
            for(int j=0;j<iB.length();j++){
                if(iB.charAt(j) == '1') nnum++;
            }
            // 조건 3
            if(num1 == nnum){
                answer = i;
                break;
            }
        }
        return answer;
    }
}