import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[2];
        int zerocnt = 0;
        int cnt = 0;
        while(true){
            int tmp = 0;
            int len = 0;
            if(s.equals("1")) break;
            else{
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i) == '0') tmp++;
                }
                zerocnt += tmp;
                // 길이 0 개수 만큼 줄이고
                len = s.length() - tmp;
                // 이진 변환을 s로
                s = Integer.toBinaryString(len);
                cnt++;
            }
        }
        answer[0] = cnt;
        answer[1] = zerocnt;
        return answer;
    }
}