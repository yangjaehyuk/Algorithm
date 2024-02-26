import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int len = binary.length();
        int subLen = binary.replace("1","").length();
        int res = len - subLen;
        int number = Integer.parseInt(binary, 2);
        while(true){
            number++;
            String tmp = Integer.toBinaryString(number);
            int len2 = tmp.length();
            int subLen2 = tmp.replace("1","").length();
            int res2 = len2 - subLen2;
            if(res == res2) break;
        }
        answer = number;
        return answer;
    }
}