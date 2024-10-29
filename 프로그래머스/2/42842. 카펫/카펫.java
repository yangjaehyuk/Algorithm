import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        boolean flag = false;
        int total = brown + yellow;
        
        for(int i=1;i<=total;i++){
            if(flag) break;
            int ygaro = i - 2;
            for(int j=1;j<=i;j++){
                if(i * j == total){
                    if(ygaro * (j - 2) == yellow) {
                        answer[0] = i;
                        answer[1] = j;
                        flag = true;
                    }
                }
            }
        }
        return answer;
    }
}