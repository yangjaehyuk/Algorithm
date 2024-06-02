import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        boolean check = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                answer.append(' ');
                check = false;
            }
            else{
                if(i==0 && !Character.isDigit(s.charAt(0))) {
                    answer.append((char)(s.charAt(i)-32));
                    continue;
                }
                if(!check){
                    if(Character.isDigit(s.charAt(i))) answer.append(s.charAt(i));
                    else answer.append((char)(s.charAt(i)-32));
                    check = true;
                }
                else{
                    answer.append(s.charAt(i));
                }
            }
        }
        return answer.toString();
    }
}