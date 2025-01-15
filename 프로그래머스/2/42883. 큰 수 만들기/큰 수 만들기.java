import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for(int i=0;i<number.length() - k;i++){
            int maxi = 0;
            for(int j=idx;j<=i+k;j++){
                if(maxi < number.charAt(j) - '0'){
                    maxi = number.charAt(j) - '0';
                    idx=j+1;
                }
            }
            answer.append(maxi);
        }
        return answer.toString();
    }
}