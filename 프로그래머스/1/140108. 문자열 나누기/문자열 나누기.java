import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int idx=0;
        int same=0;
        int different=0;
        boolean check=false;
        for(int i=0;i<s.length();i++){
            if(arr[idx]==arr[i]){
                same++;
                check=false;
            }
            else{
                if(arr[idx]!=arr[i]){
                    different++;
                    if(same==different){
                        answer++;
                        idx=i+1;
                        check=true;
                    }
                }
            }
        }
        if(!check) answer++;
        return answer;
    }
}