import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i=1;i<=total;i++){
            for(int j=1;j<=i;j++){
                if(i*j==total){
                    int garo = i;
                    int sero = j;
                    if((garo-2) * (sero-2) == yellow){
                        answer[0] = garo;
                        answer[1] = sero;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}