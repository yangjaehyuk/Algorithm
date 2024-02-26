import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        String[] ans = s.split("");
        boolean check = false;
        for(String item: ans){
            if(item.equals(" ")){
                answer += item;
                check = false;
            }
            else{
                if(!check){
                    item = item.toUpperCase();
                    answer += item;
                    check = true;
                }
                else{
                    answer += item;
                }
            }
        }
        return answer;
    }
}