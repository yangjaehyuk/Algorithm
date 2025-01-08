import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        // m: 몇 명
        // p: 몇 번째
        StringBuilder answer = new StringBuilder();
        int idx = 1;
        int now = 0;
        while(true){
            if(answer.toString().length() == t) break;
            String tmp = Integer.toString(now, n);
            for(int i=0;i<tmp.length();i++){
                if(answer.toString().length() == t) break;
                if(idx == p){
                    answer.append(tmp.toString().charAt(i));
                }
                idx++;
                idx %= m;
                if(idx == 0) idx = m;
            }
            now++;
        }
        
        return answer.toString().toUpperCase();
    }
}