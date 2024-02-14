import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            int start=s.charAt(i);
            int tmp=0;
            for(int j=0;j<index;j++){
                start++;
                if(start>122) start-=26;
                int k=0; 
                while (k<skip.length()) { 
                    if(skip.charAt(k)==start){
                        start++;
                        if(start>122) start-=26;
                        k=0;
                    } else {
                        k++; 
                    }
                }
            }
            if(start>122) start-=26;
            answer+=(char)start;
        }
        return answer;
    }
}