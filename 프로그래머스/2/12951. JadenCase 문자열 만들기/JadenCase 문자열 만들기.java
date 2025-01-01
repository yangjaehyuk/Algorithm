import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String tmp = s.toLowerCase();
        boolean flag = false;
        for(int i=0;i<tmp.length();i++){
            if(tmp.charAt(i) == ' '){
                answer += ' ';
                flag = false;
            }
            else{
                if(flag){
                    answer += tmp.charAt(i);
                    flag = true;
                }
                else{
                    if(Character.isDigit(tmp.charAt(i))){
                        // 숫자
                        answer += tmp.charAt(i);
                        flag = true;
                    }
                    else{
                        // 문자
                        answer += Character.toUpperCase(tmp.charAt(i));
                        flag = true;
                    }
                }
            }
        }
        return answer;
    }
}