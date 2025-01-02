import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        int total = brown + yellow;
        int garo = 0;
        int sero = 0;
        boolean flag = false;
        for(int i=0;i<total;i++){
            for(int j=0;j<total;j++){
                if(i >= j && i * j == total){
                    if(i * 2 + (j - 2) * 2  == brown){
                        garo = i;
                        sero = j;
                        flag = true;
                        break;    
                    }
                    
                }
            }
            if(flag) break;
        }
        answer[0] = garo;
        answer[1] = sero;
        return answer;
    }
}